// Create canvas
var canvas = document.getElementById("my_canvas");
var c = canvas.getContext("2d");

var container = {
    x: 0,
    y: 0,
    width: 500,
    height: 300
};

// Create balls
var circles = [{x: 50, y: 10, r: 5, vx: 6, vy: 6, color: "#ff0000"}, 
               {x: 250, y: 200, r: 5, vx: 6, vy: 6, color: "#ff0000"}, 
               {x: 70, y: 160, r: 6, vx: 5, vy: 5, color: "#ff0000"}, 
               {x: 270, y: 250, r: 6, vx: 5, vy: 5, color: "#ff0000"}, 
               {x: 40, y: 180, r: 7, vx: 4, vy: 4, color: "#ff0000"}, 
               {x: 140, y: 70, r: 7, vx: 4, vy: 4, color: "#ff0000"}, 
               {x: 20, y: 30, r: 8, vx: 3, vy: 3, color: "#ff0000"}, 
               {x: 110, y: 40, r: 8, vx: 3, vy: 3, color: "#ff0000"}, 
               {x: 90, y: 80, r: 9, vx: 2, vy: 2, color: "#ff0000"}, 
               {x: 180, y: 220, r: 9, vx: 2, vy: 2, color: "#ff0000"}, 
               {x: 30, y: 90, r: 6, vx: 6, vy: 6, color: "#00ff00"}, 
               {x: 230, y: 140, r: 6, vx: 5, vy: 5, color: "#00ff00"}, 
               {x: 60, y: 190, r: 7, vx: 5, vy: 5, color: "#00ff00"}, 
               {x: 160, y: 170, r: 7, vx: 6, vy: 6, color: "#00ff00"}, 
               {x: 250, y: 50, r: 8, vx: 4, vy: 4, color: "#00ff00"}, 
               {x: 80, y: 150, r: 8, vx: 4, vy: 4, color: "#00ff00"}, 
               {x: 170, y: 260, r: 9, vx: 3, vy: 3, color: "#00ff00"}, 
               {x: 10, y: 60, r: 9, vx: 3, vy: 3, color: "#00ff00"}, 
               {x: 210, y: 100, r: 10, vx: 2, vy: 2, color: "#00ff00"}, 
               {x: 50, y: 280, r: 10, vx: 2, vy: 2, color: "#00ff00"}, 
               {x: 150, y: 20, r: 7, vx: 6, vy: 6, color: "#0000ff"}, 
               {x: 190, y: 130, r: 7, vx: 6, vy: 6, color: "#0000ff"}, 
               {x: 280, y: 210, r: 8, vx: 5, vy: 5, color: "#0000ff"}, 
               {x: 60, y: 110, r: 8, vx: 5, vy: 5, color: "#0000ff"}, 
               {x: 220, y: 260, r: 9, vx: 4, vy: 4, color: "#0000ff"}, 
               {x: 20, y: 170, r: 9, vx: 4, vy: 4, color: "#0000ff"}, 
               {x: 150, y: 280, r: 6, vx: 3, vy: 3, color: "#0000ff"}, 
               {x: 60, y: 100, r: 6, vx: 3, vy: 3, color: "#0000f"}, 
               {x: 280, y: 10, r: 10, vx: 2, vy: 2, color: "#0000ff"}, 
               {x: 90, y: 230, r: 10, vx: 2, vy: 2, color: "#0000ff"}];

// Decide which action will be completed
function action(current) {
    console.log("action");
    for (var i = 0, len = circles.length; i < len; ++i) {
        console.log("check distance");
        if (i != current && bump(current, i)) {
            console.log("bubbles are near");
            if (circles[i].color == circles[current].color) {
                // Absorb such one
                console.log("absorbstart");
                circles[current].r += circles[i].r;
                circles.splice(i, 1);
                console.log("absorbend");
            } else {
                // Reflect movement
                console.log("reflectstart");
                circles[i].vx = -circles[i].vx;
                circles[i].vy = -circles[i].vy;
                circles[current].vx = -circles[current].vx;
                circles[current].vy = -circles[current].vy;
                console.log("reflectend");
            }
        }
    }
}

// Check if bubbles bump or not
function bump(current, other) {
    console.log("bump");
    return (Math.abs(circles[current].x - circles[other].x) == circles[current].r + circles[other].r) && (Math.abs(circles[current].y - circles[current].y) == circles[current].r + circles[other].r);
}

// Run animation
function animate() {
    // Draw canvas
    c.fillStyle = "#002";
    c.fillRect(container.x, container.y, container.width, container.height);

    for (var i = 0, len = circles.length; i < len; i++) {
        // Draw circles
        c.fillStyle = circles[i].color;
        c.beginPath();
        c.arc(circles[i].x, circles[i].y, circles[i].r, 0, Math.PI * 2, true);
        c.fill();

        // Reflect balls from left and right walls
        if (circles[i].x - circles[i].r + circles[i].vx < container.x || circles[i].x + circles[i].r + circles[i].vx > container.x + container.width) {
            circles[i].vx = -circles[i].vx;
        }

        // Reflect balls from top and bottom walls
        if (circles[i].y + circles[i].r + circles[i].vy > container.y + container.height || circles[i].y - circles[i].r + circles[i].vy < container.y) {
            circles[i].vy = -circles[i].vy;
        }

        // Take any actions with balls
        action(i);
        circles[i].x += circles[i].vx;
        circles[i].y += circles[i].vy;
    }
    requestAnimationFrame(animate);
}
requestAnimationFrame(animate);
