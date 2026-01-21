import streamlit as st
import pandas as pd

# --- 1. SETUP & DATA ---
st.set_page_config(page_title="Attendance Calculator", page_icon="📅", layout="wide)

st.title("🎓 Attendance Calculator")
st.write("Calculate your current attendance and safe bunks based on your semester schedule.")
st.write("Currently only for F section, semester 2")

# Your Schedule Data
SCHEDULE_LIST = [
    ["EMSB", "OOPS", "CM", "ACE"],       # Monday
    ["EVS", "CM", "EMSB", "FEE"],        # Tuesday
    ["DV_LAB", "OOPS", "ACE", "FEE", "EVS"], # Wednesday
    ["OOPS", "EMSB", "CM", "FEE", "OOPS_LAB"], # Thursday
    ["CAEG", "CM", "ACE", "CPI"]         # Friday
]

# Total occurrences of each day in the semester (Mon, Tue, Wed, Thu, Fri)
ADDITION_CONST_LIST = [15, 15, 13, 15, 12]

SAFE_ATTENDANCE_PERCENTAGE = st.number_input("Target Attendance Percentage", min_value=0, max_value=100, value=80)
st.caption("We recommend at least 80% taking a 5% margin of error")

# Initialize Dictionary for Totals
subjects = ["CM", "ACE", "FEE", "OOPS", "EVS", "EMSB", "CAEG", "OOPS_LAB", "CPI", "DV_LAB"]
total_classes = {sub: 0 for sub in subjects}
leaves_taken = {sub: 0 for sub in subjects}

# --- 2. CALCULATE TOTAL SEMESTER CLASSES ---
# This preserves your original logic: iterating days and adding the constants
for i, daily_subjects in enumerate(SCHEDULE_LIST):
    occurrence_count = ADDITION_CONST_LIST[i]
    for subject in daily_subjects:
        if subject in total_classes:
            total_classes[subject] += occurrence_count

# --- 3. USER INPUT ---
st.divider()
input_method = st.radio("How do you want to enter your leaves?", 
                        ["By Days Missed (e.g., I missed 2 Mondays)", "By Subject Missed (e.g., I skipped 3 CM classes)"])

if input_method == "By Days Missed (e.g., I missed 2 Mondays)":
    st.info("Enter how many full days you have missed:")
    col1, col2 = st.columns(2)
    with col1:
        mon = st.number_input("Mondays Missed", min_value=0, step=1)
        tue = st.number_input("Tuesdays Missed", min_value=0, step=1)
        wed = st.number_input("Wednesdays Missed", min_value=0, step=1)
    with col2:
        thu = st.number_input("Thursdays Missed", min_value=0, step=1)
        fri = st.number_input("Fridays Missed", min_value=0, step=1)
    
    days_missed = [mon, tue, wed, thu, fri]

    # Calculate subject leaves based on schedule
    for i, count in enumerate(days_missed):
        if count > 0:
            for subject in SCHEDULE_LIST[i]:
                if subject in leaves_taken:
                    leaves_taken[subject] += count

elif input_method == "By Subject Missed (e.g., I skipped 3 CM classes)":
    st.info("Enter individual classes skipped:")
    # Create a nice grid for inputs
    cols = st.columns(3)
    for i, sub in enumerate(subjects):
        with cols[i % 3]:
            leaves_taken[sub] = st.number_input(f"{sub} Skipped", min_value=0, step=1)

# --- 4. CALCULATIONS & OUTPUT ---
st.divider()
if st.button("Calculate Attendance", type="primary"):
    results = []
    
    for sub in subjects:
        total = total_classes[sub]
        skipped = leaves_taken[sub]
        
        # Avoid division by zero
        if total == 0:
            current_pct = 0.0
        else:
            current_pct = ((total - skipped) / total) * 100
        
        # Calculate Leaves Left (Safe Bunks)
        # Formula: (Current_Attendance - Required) * Total_Classes
        # Note: This formula assumes 'Attendance Now' is your projected final attendance.
        # If your logic was "how many MORE can I take", we use the logic below:
        
        safe_bunks = int((current_pct - SAFE_ATTENDANCE_PERCENTAGE) / 100 * total)
        
        # Visual Status
        status = "✅ Safe" if current_pct >= SAFE_ATTENDANCE_PERCENTAGE else "⚠️ Danger"
        
        results.append({
            "Subject": sub,
            "Total Classes": total,
            "Skipped": skipped,
            "Attendance %": f"{current_pct:.2f}%",
            "Safe Bunks Left": safe_bunks if safe_bunks > 0 else 0,
            "Status": status
        })

    # Display as a neat table
    df = pd.DataFrame(results)
    st.dataframe(df, hide_index=True, use_container_width=True)

    # Simple Summary
    st.caption(f"*Safe Bunks Left calculates how many more classes you can miss while staying above {SAFE_ATTENDANCE_PERCENTAGE}%.*")

st.markdown(
    "<div style='text-align: right; margin-top: 50px; color: gray;'>Made by Sanskar Jaiswal</div>",
    unsafe_allow_html=True
)