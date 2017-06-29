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

var circles = [new circle(10,10,5,3,3,'#ff0007'), new circle(50,80,5,3,3,'#ff0007'), new circle(90,110,5,-3,3,'#ff0007'),
                new circle(300,80,5,3,2,'#ff0007'), new circle(200,100,5,2,3,'#ff0007'), new circle(400,120,5,-2,-3,'#ff0007'),
                new circle(130,130,5,-3,-4,'#ff0007'), new circle(550,6,5,-3,-3,'#ff0007'), new circle(320,50,5,-3,2,'#ff0007'),
                new circle(25,170,5,2,-3,'#2826ff'), new circle(60,6,5,2,-3,'#2826ff'), new circle(400,100,5,2,-2,'#2826ff'),
                new circle(10,50,5,3,2,'#2826ff'), new circle(30,200,5,3,4,'#2826ff'), new circle(300,130,5,4,3,'#2826ff'),
                new circle(150,50,5,-2,3,'#2826ff'), new circle(130,10,5,4,2,'#2826ff'), new circle(500,25,5,3,-2,'#2826ff'),
                new circle(5,60,5,3,-3,'#3cff3c'), new circle(10,150,5,3,-2,'#3cff3c'),new circle(10,130,5,-3,2,'#3cff3c'),
                new circle(250,170,5,3,-3,'#3cff3c'), new circle(130,250,5,2,3,'#3cff3c'), new circle(200,50,5,3,3,'#3cff3c'),
                new circle(290,150,5,3,2,'#3cff3c'), new circle(150,10,5,3,-2,'#3cff3c'), new circle(60,200,5,3,-2,'#3cff3c'),
                new circle(200,200,5,3,2,'#fffb00'), new circle(220,220,5,2,3,'#fffb00'),new circle(220,50,5,3,3,'#fffb00'),
                new circle(25,156,5,3,-2,'#fffb00'), new circle(146,80,5,-2,3,'#fffb00'), new circle(85,168,5,-3,3,'#fffb00'),
                new circle(450,50,5,3,2,'#fffb00'), new circle(550,15,5,3,-2,'#fffb00'), new circle(10,200,5,3,-2,'#fffb00'),
                new circle(200,120,5,3,-2,'#b100ff'), new circle(120,10,5,2,3,'#b100ff'), new circle(80,200,5,-3,2,'#b100ff'),
                new circle(30,250,5,3,-2,'#b100ff'), new circle(300,10,5,2,3,'#b100ff'), new circle(450,200,5,-3,2,'#b100ff')];

function animate() {
    c.fillStyle = "#0c0606";
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
        var touchX = Math.abs(circles[i].x + circles[i].r - circles[j].x - circles[j].r) < circles[i].r + circles[j].r ? true : false;
        var touchY = Math.abs(circles[i].y + circles[i].r - circles[j].y - circles[j].r) < circles[i].r + circles[j].r ? true : false;
        if (circles[i] != circles[j] && touchX && touchY) {
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

