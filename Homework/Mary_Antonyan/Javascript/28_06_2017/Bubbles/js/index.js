var canvas = document.getElementById("my_canvas");
var c = canvas.getContext("2d");

var container = {
    x: 0,
    y: 0,
    width: 600,
    height: 300
};

var circles = [{
    x: 50,
    y: 100,
    r: 10,
    vx: 6,
    vy: 6,
    color: 125
}, {
    x: 150,
    y: 80,
    r: 20,
    vx: 4,
    vy: 4,
    color: 205
}, {
    x: 90,
    y: 150,
    r: 5,
    vx: 7,
    vy: 7,
    color: 25
}, {
    x: 100,
    y: 50,
    r: 15,
    vx: 5,
    vy: 5,
    color: 100
}];

function animate() {
    c.fillStyle = "#002";
    c.fillRect(container.x, container.y, container.width, container.height);

    for (var i = 0; i < circles.length; i++) {
        c.fillStyle = 'hsl(' + circles[i].color++ + ', 100%, 50%)';
        c.beginPath();
        c.arc(circles[i].x, circles[i].y, circles[i].r, 0, Math.PI * 2, true);
        c.fill();

        if (circles[i].x - circles[i].r + circles[i].vx < container.x || circles[i].x + circles[i].r + circles[i].vx > container.x + container.width) {
            circles[i].vx = -circles[i].vx;
        }

        if (circles[i].y + circles[i].r + circles[i].vy > container.y + container.height || circles[i].y - circles[i].r + circles[i].vy < container.y) {
            circles[i].vy = -circles[i].vy;
        }

        circles[i].x += circles[i].vx;
        circles[i].y += circles[i].vy;
    }
    requestAnimationFrame(animate);
}

// Draw circle following mouse
var targetX = 0,
    targetY = 0,
    x = 10,
    y = 10,
    velX = 0,
    velY = 0,
    speed = 2;

function update(){
    var tx = targetX - x,
    ty = targetY - y,
    dist = Math.sqrt(tx*tx+ty*ty),
    rad = Math.atan2(ty,tx),
    angle = rad/Math.PI * 180;

    velX = (tx/dist)*speed,
    velY = (ty/dist)*speed;

    x += velX
    y += velY

    c.clearRect(0,0,500,500);
    c.beginPath();
    c.arc(x,y,5,0,Math.PI*2);
    c.fillStyle = "#000";
    c.fill();

    setTimeout(update,10);
}

update();

canvas.addEventListener("mousemove", function(e){
    targetX = e.pageX;
    targetY = e.pageY;
});
requestAnimationFrame(animate);
