var canvas = document.getElementById("my_canvas");
var c = canvas.getContext("2d");
var container = {
    x: 0,
    y: 0,
    width: 600,
    height: 300
};

var circle = function(x,y,r,vx,vy,color){
    this.x = x;
    this.y = y;
    this.r = r;
    this.vx = vx; //aragutyun@ horizonakan
    this.vy = vy; //aragutyun@ uxxahayac
    this.color = color;
};

var circles = [new circle(10,20,5,-4,4,'#ff0007'), new circle(30,40,5,-4,3,'#ff0007'), new circle(50,60,5,-3,3,'#ff0007'),
                new circle(70,80,5,-3,-2,'#ff0007'), new circle(90,100,5,-2,-3,'#ff0007'), new circle(110,120,5,-2,-3,'#ff0007'),
                new circle(130,130,5,-3,-4,'#ff0007'), new circle(145,6,5,-3,-3,'#ff0007'), new circle(125,114,5,-3,2,'#ff0007'),
                new circle(150,170,5,2,-3,'#2826ff'), new circle(20,130,5,3,-3,'#2826ff'), new circle(150,10,5,2,-3,'#2826ff'),
                new circle(10,130,5,3,3,'#2826ff'), new circle(30,170,5,3,4,'#2826ff'), new circle(50,130,5,4,3,'#2826ff'),
                new circle(150,50,5,-2,3,'#2826ff'), new circle(130,10,5,4,2,'#2826ff'), new circle(150,25,5,3,-2,'#2826ff'),
                new circle(5,60,5,3,-3,'#3cff3c'), new circle(10,50,5,4,-3,'#3cff3c'),new circle(30,130,5,-3,2,'#3cff3c'),
                new circle(200,170,5,3,-3,'#3cff3c'), new circle(130,200,5,2,3,'#3cff3c'), new circle(200,50,5,3,3,'#3cff3c'),
                new circle(20,150,5,3,2,'#3cff3c'), new circle(150,5,5,3,-2,'#3cff3c'), new circle(60,200,5,3,-2,'#3cff3c'),
                new circle(200,200,5,3,2,'#fffb00'), new circle(220,220,5,2,3,'#fffb00'),new circle(220,50,5,4,3,'#fffb00'),
                new circle(25,156,5,3,-2,'#fffb00'), new circle(146,80,5,-2,3,'#fffb00'), new circle(85,168,5,-3,3,'#fffb00'),
                new circle(10,50,5,3,2,'#fffb00'), new circle(50,15,5,4,-2,'#fffb00'), new circle(150,75,5,3,-4,'#fffb00'),
                new circle(10,120,5,4,-3,'#b100ff'), new circle(120,10,5,4,3,'#b100ff'), new circle(80,200,5,-4,3,'#b100ff')];

function animate() {
    c.fillStyle = "#000000";
    c.fillRect(container.x, container.y, container.width, container.height);
    for (var i = 0; i < circles.length; i++) {
        c.fillStyle = circles[i].color;
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
        changePosition(i);
    }
    requestAnimationFrame(animate);
}
requestAnimationFrame(animate);

function changePosition(i) {
    for(var j = 0; j < circles.length; ++j) {
        if (circles[i] != circles[j] && checkTouch(i, j)) {
            if (circles[i].color == circles[j].color) {
                circles[i].r = circles[i].r + circles[j].r - 3;
                circles.splice(j, 1);
            } else {
                circles[i].vx = -circles[i].vx;
                circles[i].vy = -circles[i].vy;
                circles[j].vx = -circles[j].vx;
                circles[j].vy = -circles[j].vy;
            }
        }
    }
}

function checkTouch(i, j) {
        if (Math.abs(circles[i].x + circles[i].r - circles[j].x - circles[j].r) < circles[i].r + circles[j].r &&
            Math.abs(circles[i].y + circles[i].r - circles[j].y - circles[j].r) < circles[i].r + circles[j].r) {
            return true;
        }
    return false;
}

