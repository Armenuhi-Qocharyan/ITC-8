var canvas = document.getElementById("my_canvas");
var c = canvas.getContext("2d");

//create te container
var container = {
    x: 0,
    y: 0,
    width: 600,
    height: 300
};

//create the array of circles that will be animated
var circles =[];
var colors = ["red", "green", "blue"];
createCircles()
function  createCircles() {
    var circle;
    for (var i = 0, j = 0; i < 9; ++i) {
        circle = {
            x: Math.random() * (600 - 30) + 30,
            y: Math.random() * (300 - 40) + 40,
            r: Math.random() * (15 - 3) + 3,
            vx: Math.random() * (5 - 1) + 1,
            vy: Math.random() * (5 - 1) + 1,
            color: colors[j],
        }
        circles[i] = circle;
        j = j == 2 ? 0 : ++j;
    }
}

function animate() {
    //draw the container
    c.fillStyle = "#000000";
    c.fillRect(container.x, container.y, container.width, container.height);

    //loop throughj the circles array
    for (var i = 0; i < circles.length; i++) {
        //draw the circles
        c.fillStyle = circles[i].color//'hsl(' + circles[i].color++ + ', 100%, 50%)';
        c.beginPath();
        c.arc(circles[i].x, circles[i].y, circles[i].r, 0, Math.PI * 2, true);
        c.fill()

        //time to animate our circles ladies and gentlemen.
        if (circles[i].x - circles[i].r + circles[i].vx < container.x || circles[i].x + circles[i].r + circles[i].vx > container.x + container.width) {
            circles[i].vx = -circles[i].vx;
        }

        if (circles[i].y + circles[i].r + circles[i].vy > container.y + container.height || circles[i].y - circles[i].r + circles[i].vy < container.y) {
            circles[i].vy = -circles[i].vy;
        }

        circles[i].x += circles[i].vx
        circles[i].y += circles[i].vy
        for (var j = 0; j < circles.length; j++) {
            joinOrChangePosition(circles[i], circles[j], j);
        }
    }
    requestAnimationFrame(animate, 70)
}
requestAnimationFrame(animate)

function isTouch(circle1, circle2) {
    for (var i = 0; i < 8; ++i) {
        if (Math.abs((circle1.x + circle1.r + circle1.vx - (circle2.x + circle2.r + circle2.vx))) < Math.abs(circle1.r + circle2.r) &&
            Math.abs((circle1.y + circle1.r + circle1.vy - (circle2.y + circle2.r + circle2.vy))) < Math.abs(circle1.r + circle2.r)) {
            return true;
        }
    }
    return false;
}

function joinOrChangePosition(circle1, circle2, deleteIndex) {
    if (circle1 && circle2 && circle1 != circle2 && isTouch(circle1, circle2)) {
        if (circle1.color == circle2.color) {
            circle1.r = Math.sqrt(Math.pow(circle1.r, 2) + Math.pow(circle2.r, 2));
            circles.splice(deleteIndex, 1);
        } else {
            circle1.vx = circle2.vx;
            circle1.vy = circle2.vy;
            circle2.vx = -circle2.vx;
            circle2.vy = -circle2.vy;
        }
    }
}

function reload() {
    location.reload();
}