const COUNT = 15,
    WIDTH = screen.width/2,
    HEIGHT = screen.height/2,
    OFFSET_LEFT = screen.width/4,
    OFFSET_TOP = screen.height/4;

var circles = [],
    colors = ["red", "green", "blue"],
    content = document.getElementById('container'),
    start = true;

var container = {
    x: OFFSET_LEFT,
    y: OFFSET_TOP,
    width: WIDTH,
    height: HEIGHT
};

(function main() {
    content.className = "container";
    content.style.width = WIDTH  +"px";
    content.style.height = HEIGHT + "px";
    content.style.marginLeft = OFFSET_LEFT + "px";
    content.style.marginTop = OFFSET_TOP + "px";
    createCircles();
    createObjects();
})();

function circle() {
    this.x = Math.random() * (WIDTH - OFFSET_LEFT) +  OFFSET_LEFT;
    this.y =  Math.random() * (HEIGHT - OFFSET_TOP) + OFFSET_TOP;
    this.r = Math.random() * (10 - 3) + 3;
    this.vx = Math.random() * (4 - 1) + 1;
    this.vy = Math.random() * (4 - 1) + 1
};

function  createCircles() {
    var crc;
    for (var i = 0, j = 0; i < COUNT; ++i) {
        crc = new circle();
        crc.color = colors[j];
        circles[i] = crc;
        j = j == 2 ? 0 : ++j;
    }
}

function createObjects() {
    for (var i = 0; i < COUNT; ++i) {
        var circle = document.createElement('div');
        circle.style.backgroundColor = circles[i].color;
        circle.style.left = circles[i].x + "px";
        circle.style.top = circles[i].y + "px";
        circle.className = "circle";
        content.appendChild(circle);
    }
}

var timeInterval = setInterval(moveObjects, 10);
function moveObjects() {
        for (var i = 0; i < circles.length; ++i) {
            if (circles[i] && circles[i].x + circles[i].vx < container.x || circles[i].x + 2 * circles[i].r	 > container.x + container.width) {
                circles[i].vx = -circles[i].vx;
            }

            if (circles[i] && circles[i].y + 2 * circles[i].r + circles[i].vy > container.y + container.height || circles[i].y + circles[i].vy < container.y) {
                circles[i].vy = -circles[i].vy;
            }

            circles[i].y += circles[i].vy;
            circles[i].x += circles[i].vx;
            content.childNodes[i].style.width = circles[i].r * 2 + "px";
            content.childNodes[i].style.height = circles[i].r * 2 + "px";
            content.childNodes[i].style.left = circles[i].x + "px";
            content.childNodes[i].style.top = circles[i].y + "px";
            for (var j = 0; j < circles.length; j++) {
                joinOrChangePosition(i, j);
            }
        }
}

function isTouch(i, j) {
        if (Math.abs((circles[i].x + circles[i].vx - (circles[j].x + circles[j].vx))) < Math.abs(circles[i].r + circles[j].r) &&
            Math.abs((circles[i].y + circles[i].vy - (circles[j].y + circles[j].vy))) < Math.abs(circles[i].r + circles[j].r)) {
            return true;
        }
    return false;
}

function joinOrChangePosition(i, j) {
    if (circles[i] && circles[j] && circles[i] != circles[j] && isTouch(i, j)) {
        if (circles[i].color == circles[j].color) {
            circles[i].r = Math.sqrt(Math.pow(circles[i].r, 2) + Math.pow(circles[j].r, 2));
            circles.splice(j, 1);
            content.removeChild(content.childNodes[j]);
        } else {
            circles[i].vx = circles[j].vx;
            circles[i].vy = circles[j].vy;
            circles[j].vx = -circles[j].vx;
            circles[j].vy = -circles[j].vy;
        }
    }
}

function  stop() {
    if (start) {
        start = false;
        clearInterval(timeInterval);
    } else {
        start = true;
        timeInterval = setInterval(moveObjects, 10);
    }
}






