// ==========================================
// 1. DATA CONFIGURATION & DOM RENDER
// ==========================================
const COMMUNICATIONS = [
    { name: "GitHub", url: "https://github.com/ROYALKINGSJ", icon: "/ICONS/github.png" },
    { name: "Email", url: "mailto:technologiccompany.sanskar+sanskarjaiswal.portfolio@gmail.com", icon: "/ICONS/email.png" },
    { name: "LinkedIn", url: "https://www.linkedin.com/in/tech-com-35705a235", icon: "/ICONS/linkedin.png" },
    { name: "Patreon", url: "https://patreon.com/TECHCOM?utm_medium=unknown&utm_source=join_link&utm_campaign=creatorshare_creator&utm_content=copyLink", icon: "/ICONS/patreon.png" }
];

const SKILLS = [
    "C#", "Python [Pandas, Numpy, Matplotlib, Seaborn]", "Java OOP", 
    "C / C++", "SQL Database Management", "3D Modeling & Rendering",
    "Git / Github"
];

const PROJECTS = [
    { title: "Unity Game Dev", desc: "Developing smooth player movement scripts and resolving complex physics jittering in 3D environments.", statusText: "ENGINE DEV", url: "#" },
    { title: "MIT Attendance Hub", desc: "Full-stack portal featuring secure user auth, API key management, and automated CSV data handling.", statusText: "LIVE DEPLOYMENT", url: "https://github.com/ROYALKINGSJ/attendance-calculator" }
];

document.getElementById('comms-container').innerHTML = COMMUNICATIONS.map(link => 
    `<a href="${link.url}" target="_blank" class="comm-btn"><img src="${link.icon}" alt="icon"> ${link.name}</a>`
).join('');

document.getElementById('skills-container').innerHTML = SKILLS.map(skill => `<div class="skill-node">${skill}</div>`).join('');

document.getElementById('projects-container').innerHTML = PROJECTS.map(proj => `
    <a href="${proj.url}" ${proj.url !== "#" ? 'target="_blank"' : ''} class="project-card">
        <h3 class="proj-title">${proj.title}</h3>
        <p class="proj-desc">${proj.desc}</p>
        <div class="proj-meta"><div class="proj-status">${proj.statusText}</div><span>>_</span></div>
    </a>
`).join('');

// Mouse Spotlight on Glass Panels
document.querySelectorAll('.glass-panel').forEach(panel => {
    panel.addEventListener('mousemove', e => {
        const rect = panel.getBoundingClientRect();
        panel.style.setProperty('--mouse-x', `${e.clientX - rect.left}px`);
        panel.style.setProperty('--mouse-y', `${e.clientY - rect.top}px`);
    });
});

// ==========================================
// 2. LIGHT / DARK MODE TOGGLE
// ==========================================
const themeToggleBtn = document.getElementById("theme-toggle");
const savedTheme = localStorage.getItem("portfolio-theme") || "dark";
document.documentElement.setAttribute("data-theme", savedTheme);
themeToggleBtn.innerText = savedTheme === "light" ? "🌙 DARK MODE" : "☀️ LIGHT MODE";

themeToggleBtn.addEventListener("click", () => {
    const newTheme = document.documentElement.getAttribute("data-theme") === "light" ? "dark" : "light";
    document.documentElement.setAttribute("data-theme", newTheme);
    localStorage.setItem("portfolio-theme", newTheme);
    themeToggleBtn.innerText = newTheme === "light" ? "🌙 DARK MODE" : "☀️ LIGHT MODE";
});

// ==========================================
// 3. GENERATIVE PHYSICS ENGINE V3 (SHOCKWAVES & DATA FRAGMENTS)
// ==========================================
const bgCanvas = document.getElementById('bgCanvas');
const bgCtx = bgCanvas.getContext('2d');
let orbs = [];
let dataParticles = [];
let globalHue = 275;
let mouseX = -1000;
let mouseY = -1000;

window.addEventListener('mousemove', (e) => {
    mouseX = e.clientX;
    mouseY = e.clientY;
});

// Click Shockwave Physics
window.addEventListener('mousedown', () => {
    orbs.forEach(orb => {
        const dx = orb.x - mouseX;
        const dy = orb.y - mouseY;
        const dist = Math.sqrt(dx * dx + dy * dy);
        
        // Massive velocity spike based on proximity to click
        if (dist < 1000) {
            const force = (1000 - dist) / 1000;
            orb.vx += (dx / dist) * force * 30; 
            orb.vy += (dy / dist) * force * 30;
        }
    });
});

class Orb {
    constructor(canvasWidth, canvasHeight) {
        this.x = Math.random() * canvasWidth;
        this.y = Math.random() * canvasHeight;
        this.vx = (Math.random() - 0.5) * 2;
        this.vy = (Math.random() - 0.5) * 2;
        this.radius = Math.random() * 300 + 400; 
        this.baseAlpha = Math.random() * 0.4 + 0.3;
        this.currentAlpha = this.baseAlpha;
        
        // New organic movement properties
        this.angle = Math.random() * Math.PI * 2;
        this.turnSpeed = (Math.random() - 0.5) * 0.02;

        this.hue = Math.random() * 360; // Starts random, but will immediately adapt
    }

    update(canvasWidth, canvasHeight, isLightMode) {
        // --- 1. DYNAMIC THEME COLOR SHIFTING ---
        // Dark Mode: Deep Purples & Pinks (~280) | Light Mode: Warm Sunrise Oranges (~40)
        let targetHue = isLightMode ? (Math.random() * 40 + 20) : (Math.random() * 60 + 260);

        // Smoothly morph the color towards the current theme's palette
        let hueDiff = targetHue - this.hue;
        if (hueDiff > 180) hueDiff -= 360;
        if (hueDiff < -180) hueDiff += 360;
        this.hue += hueDiff * 0.01; 

        if (this.hue > 360) this.hue -= 360;
        if (this.hue < 0) this.hue += 360;

        // --- 2. ORGANIC SWIRLING MOVEMENT ---
        // Slowly steer the orbs so they curve and swirl
        this.angle += this.turnSpeed;
        this.vx += Math.cos(this.angle) * 0.04;
        this.vy += Math.sin(this.angle) * 0.04;

        // Mouse repulsion
        const dx = this.x - mouseX;
        const dy = this.y - mouseY;
        const dist = Math.sqrt(dx * dx + dy * dy);
        
        if (dist < 400) {
            const force = (400 - dist) / 400;
            this.vx += (dx / dist) * force * 0.5;
            this.vy += (dy / dist) * force * 0.5;
        }

        // Friction and speed capping
        this.vx *= 0.96;
        this.vy *= 0.96;

        const speed = Math.sqrt(this.vx * this.vx + this.vy * this.vy);
        // Cap max speed, but force a minimum speed so they never stop sweeping
        if (speed > 2.5) {
            this.vx = (this.vx / speed) * 2.5;
            this.vy = (this.vy / speed) * 2.5;
        } else if (speed < 0.8) {
            this.vx *= 1.05;
            this.vy *= 1.05;
        }

        this.x += this.vx;
        this.y += this.vy;

        // Soft Wall Bounces
        if (this.x < -this.radius) this.vx += 0.5;
        if (this.x > canvasWidth + this.radius) this.vx -= 0.5;
        if (this.y < -this.radius) this.vy += 0.5;
        if (this.y > canvasHeight + this.radius) this.vy -= 0.5;

        // Keep opacity perfectly smooth (no blinking)
        this.currentAlpha = this.baseAlpha;
    }

    draw(ctx, isLightMode) {
        const gradient = ctx.createRadialGradient(this.x, this.y, 0, this.x, this.y, this.radius);
        const sat = isLightMode ? '90%' : '100%';
        const lit = isLightMode ? '55%' : '45%'; 
        
        gradient.addColorStop(0, `hsla(${this.hue}, ${sat}, ${lit}, ${this.currentAlpha})`);
        gradient.addColorStop(1, `hsla(${this.hue}, ${sat}, ${lit}, 0)`);
        
        ctx.fillStyle = gradient;
        ctx.beginPath(); ctx.arc(this.x, this.y, this.radius, 0, Math.PI * 2); ctx.fill();
    }
}
class DataParticle {
    constructor(canvasWidth, canvasHeight) {
        this.x = Math.random() * canvasWidth;
        this.y = Math.random() * canvasHeight;
        this.size = Math.random() * 3 + 1;
        this.vx = (Math.random() - 0.5) * 0.8;
        this.vy = (Math.random() - 0.5) * 0.8;
    }

    update(canvasWidth, canvasHeight) {
        // Scatter away from mouse
        const dx = this.x - mouseX;
        const dy = this.y - mouseY;
        const dist = Math.sqrt(dx * dx + dy * dy);
        
        if (dist < 150) {
            this.x += (dx / dist) * 3;
            this.y += (dy / dist) * 3;
        }

        this.x += this.vx;
        this.y += this.vy;

        // Wrap around screen
        if (this.x < 0) this.x = canvasWidth;
        if (this.x > canvasWidth) this.x = 0;
        if (this.y < 0) this.y = canvasHeight;
        if (this.y > canvasHeight) this.y = 0;
    }

    draw(ctx, hue, isLightMode) {
        const lightness = isLightMode ? '40%' : '70%';
        ctx.fillStyle = `hsla(${hue}, 100%, ${lightness}, 0.6)`;
        ctx.fillRect(this.x, this.y, this.size, this.size);
    }
}

function initBgCanvas() {
    bgCanvas.width = window.innerWidth;
    bgCanvas.height = window.innerHeight;
    orbs = [];
    dataParticles = [];
    
    const orbCount = window.innerWidth < 800 ? 4 : 6;
    for (let i = 0; i < orbCount; i++) orbs.push(new Orb(bgCanvas.width, bgCanvas.height));

    const particleCount = window.innerWidth < 800 ? 40 : 100;
    for (let i = 0; i < particleCount; i++) dataParticles.push(new DataParticle(bgCanvas.width, bgCanvas.height));
}

function animateBgCanvas() {
    bgCtx.clearRect(0, 0, bgCanvas.width, bgCanvas.height);
    const isLightMode = document.documentElement.getAttribute('data-theme') === 'light';
    
    bgCtx.globalCompositeOperation = isLightMode ? 'multiply' : 'screen';

    let avgHue = 0;
    for (let i = 0; i < orbs.length; i++) {
        orbs[i].update(bgCanvas.width, bgCanvas.height, isLightMode); // Added isLightMode here
        orbs[i].draw(bgCtx, isLightMode);
        avgHue += orbs[i].hue;
    }
    
    globalHue = avgHue / orbs.length;
    document.documentElement.style.setProperty('--dynamic-hue', globalHue);

    bgCtx.globalCompositeOperation = 'source-over'; 

    // Draw Data Particles
    for (let i = 0; i < dataParticles.length; i++) {
        dataParticles[i].update(bgCanvas.width, bgCanvas.height);
        dataParticles[i].draw(bgCtx, globalHue, isLightMode);
    }

    requestAnimationFrame(animateBgCanvas);
}

window.addEventListener('resize', initBgCanvas);
initBgCanvas();
animateBgCanvas();


// ==========================================
// 4. LED MATRIX GLITCH ENGINE
// ==========================================
const ledCanvas = document.getElementById('ledCanvas');
const ledCtx = ledCanvas.getContext('2d', { willReadFrequently: true });
let dots = [];
const DOT_SIZE = 4; const GAP = 2; const SPACING = DOT_SIZE + GAP;

function initLEDMatrix() {
    const wrapper = document.querySelector('.led-wrapper');
    ledCanvas.width = wrapper.clientWidth; ledCanvas.height = wrapper.clientHeight;

    const offCanvas = document.createElement('canvas');
    offCanvas.width = ledCanvas.width; offCanvas.height = ledCanvas.height;
    const oCtx = offCanvas.getContext('2d', { willReadFrequently: true });

    oCtx.fillStyle = 'white'; oCtx.textBaseline = 'middle'; oCtx.textAlign = 'center';
    
    const targetText = "ROYALKINGSJ"; 
    let fontSize = ledCanvas.width / (targetText.length * 0.55); 
    if (fontSize > 110) fontSize = 110; 
    
    oCtx.font = `900 ${fontSize}px 'Rajdhani', sans-serif`;
    oCtx.fillText(targetText, ledCanvas.width / 2, ledCanvas.height / 2);

    const imgData = oCtx.getImageData(0, 0, ledCanvas.width, ledCanvas.height).data;
    dots = [];

    for (let y = 0; y < ledCanvas.height; y += SPACING) {
        for (let x = 0; x < ledCanvas.width; x += SPACING) {
            const i = (y * ledCanvas.width + x) * 4;
            if (imgData[i + 3] > 128) {
                dots.push({ x: x, y: y, originalX: x, originalY: y, baseAlpha: 1, currentAlpha: 1 });
            }
        }
    }
}

let lastGlitchTime = 0;
const GLITCH_SPEED_MS = 100;

function animateLEDMatrix(timestamp) {
    if (!lastGlitchTime) lastGlitchTime = timestamp;
    const delta = timestamp - lastGlitchTime;

    let tearYOffset = -1;
    let tearStrength = 0;
    if (Math.random() < 0.05) {
        tearYOffset = Math.floor(Math.random() * ledCanvas.height);
        tearStrength = (Math.random() - 0.5) * 50; 
    }

    if (delta > GLITCH_SPEED_MS) {
        for (let i = 0; i < dots.length; i++) {
            dots[i].currentAlpha = Math.random() < 0.15 ? 0.1 : dots[i].baseAlpha; 
            
            if (Math.abs(dots[i].y - tearYOffset) < 15) {
                dots[i].x = dots[i].originalX + tearStrength;
            } else {
                dots[i].x += (dots[i].originalX - dots[i].x) * 0.2; 
            }
        }
        lastGlitchTime = timestamp;
    }

    ledCtx.clearRect(0, 0, ledCanvas.width, ledCanvas.height);
    const theme = document.documentElement.getAttribute('data-theme');
    const lightness = theme === 'light' ? '30%' : '60%'; 
    
    ledCtx.shadowBlur = Math.random() > 0.9 ? 25 : 10; 
    ledCtx.shadowColor = `hsl(${globalHue}, 100%, ${lightness})`;

    for (let i = 0; i < dots.length; i++) {
        ledCtx.fillStyle = `hsla(${globalHue}, 100%, ${lightness}, ${dots[i].currentAlpha})`;
        ledCtx.fillRect(dots[i].x, dots[i].y, DOT_SIZE, DOT_SIZE);
    }

    requestAnimationFrame(animateLEDMatrix);
}

window.addEventListener('resize', initLEDMatrix);
document.fonts.ready.then(() => { initLEDMatrix(); requestAnimationFrame(animateLEDMatrix); });