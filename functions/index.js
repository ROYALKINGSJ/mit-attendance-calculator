const { onObjectFinalized } = require("firebase-functions/v2/storage");
const admin = require("firebase-admin");
const { setGlobalOptions } = require("firebase-functions/v2");

admin.initializeApp();

// Set max instances to prevent high costs
setGlobalOptions({ maxInstances: 10 });

exports.limitUploads = onObjectFinalized(async (event) => {
  // 1. Get File Info
  const filePath = event.data.name; // File path: uploads/{userId}/{fileName}
  const bucketName = event.data.bucket; // Storage bucket name
  
  // Safety Check: Ensure file is in the "uploads" folder
  if (!filePath.startsWith("uploads/")) return null;

  const parts = filePath.split("/");
  if (parts.length < 3) return null; // Ensure structure is correct
  const userId = parts[1]; 
  
  // 2. Get Today's Date (YYYY-MM-DD)
  const today = new Date().toISOString().split('T')[0];
  const statsRef = admin.firestore().collection("user_stats").doc(userId);

  // 3. Run Transaction
  await admin.firestore().runTransaction(async (t) => {
    const doc = await t.get(statsRef);
    const data = doc.data() || {};

    // Check if the count for TODAY is already 3 or more
    if (data.date === today && data.count >= 3) {
        console.log(`⛔ LIMIT EXCEEDED: User ${userId} tried to upload a 4th file.`);
        
        // DELETE the file immediately
        const bucket = admin.storage().bucket(bucketName);
        await bucket.file(filePath).delete();
        console.log(`🗑️ Deleted spam file: ${filePath}`);
    } else {
        // ✅ ALLOWED: Increment the server-side counter
        const newCount = (data.date === today) ? (data.count || 0) + 1 : 1;
        t.set(statsRef, { date: today, count: newCount });
        console.log(`✅ Upload allowed for ${userId}. Count: ${newCount}/3`);
    }
  });
});