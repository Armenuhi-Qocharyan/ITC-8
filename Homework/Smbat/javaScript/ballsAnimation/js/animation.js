var canvas = document.getElementById("my_canvas");
var c = canvas.getContext("2d");

//create te container
var container = {
    x: 0,
    y: 0,
    width: 1000,
    height: 500
};
//create the array of circles
var circles = [{
    x: 50,
    y: 100,
    r: 10,
    vx: 3,
    vy: 6,
    color: 200
}, {
    x: 150,
    y: 10,
    r: 10,
    vx: 8,
    vy: 2,
    color: 200
},{
    x: 80,
    y: 200,
    r: 10,
    vx: 6,
    vy: 8,
    color: 200
}, {
    x: 90,
    y: 150,
    r: 10,
    vx: 7,
    vy: 3,
    color: 25
},{
    x: 15,
    y: 100,
    r: 10,
    vx: 5,
    vy: 7,
    color: 25
}, {
    x: 80,
    y: 50,
    r: 10,
    vx: 6,
    vy: 3,
    color: 25
}, {
    x: 50,
    y: 25,
    r: 10,
    vx: 9,
    vy: 2,
    color: 120
},{
    x: 10,
    y: 300,
    r: 10,
    vx: 4,
    vy: 3,
    color: 120
}, {
    x: 100,
    y: 14,
    r: 10,
    vx: 8,
    vy: 6,
    color: 120
}];

function animate() {
    //draw the container
    c.fillStyle = "#000000";
    c.fillRect(container.x, container.y, container.width, container.height);

    for (var i = 0; i < circles.length; i++) {
        //draw the circles
        c.fillStyle = 'hsl('+ circles[i].color + ', 100%, 50%)';
        c.beginPath();
        c.arc(circles[i].x, circles[i].y, circles[i].r, 0, Math.PI * 2, true);
        c.fill();

        //cheeck ball collision with line
        if (circles[i].x - circles[i].r + circles[i].vx < container.x || circles[i].x + circles[i].r + circles[i].vx > container.x + container.width) {
            circles[i].vx = -circles[i].vx;
        }

        if (circles[i].y + circles[i].r + circles[i].vy > container.y + container.height || circles[i].y - circles[i].r + circles[i].vy < container.y) {
            circles[i].vy = -circles[i].vy;
        }

        //cheeck ball collision
        for (var j = 0; j < circles.length; ++j) {
            if (i !== j) {
                var distance = Math.sqrt( (circles[i].x - circles[j].x)*(circles[i].x - circles[j].x)
                    + (circles[i].y - circles[j].y) * (circles[i].y - circles[j].y));

                if (distance <= (circles[i].r + circles[j].r)) {
                    if (circles[i].color === circles[j].color) {
                        circles[i].r += circles[j].r;
                        circles.splice(j, 1);
                        if (i >= circles.length)i--;
                    } else {
                        circles[i].vy = -circles[i].vy;
                        circles[i].vx = -circles[i].vx;
                    }
                }
            }
        }

        circles[i].x += circles[i].vx;
        circles[i].y += circles[i].vy;

    }

    requestAnimationFrame(animate);
}
requestAnimationFrame(animate);