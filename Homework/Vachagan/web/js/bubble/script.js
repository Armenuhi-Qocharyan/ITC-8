var c = document.getElementById("myCanvas");
var ctx = c.getContext("2d");

var canvas = {
    x: 0,
    y: 0,
    w: 900,
    h: 600
};

function circle(x,y,r,vx,vy,color) {
    this.x = x;
    this.y = y;
    this.r = r;
    this.vx = vx;
    this.vy = vy;
    this.color = color;
}

var array = [new circle(20,20,12,7,3,40),new circle(300,200,25,8,6,40),new circle(420,360,18,4,9,40),new circle(50,400,15,4,9,40),
    new circle(50,120,20,4,6,205),new circle(400,35,28,6,7,205),new circle(250,125,15,6,7,205),new circle(500,800,24,6,7,205),
    new circle(850,120,20,4,6,10),new circle(750,500,25,6,7,10),new circle(800,300,30,6,7,10),new circle(250,450,17,6,7,10)];

function animate() {
    ctx.fillStyle = "#000000";
    ctx.fillRect(canvas.x, canvas.y, canvas.w, canvas.h);
    for (var i = 0; i < array.length; i++) {
        meet();
        if(array[i] == undefined) {
            continue;
        }
        ctx.fillStyle = 'hsl(' + array[i].color + ', 100%, 50%)';
        ctx.beginPath();
        ctx.arc(array[i].x, array[i].y, array[i].r, 0, Math.PI * 2, true);
        ctx.fill();

        if (array[i].x - array[i].r + array[i].vx < canvas.x || array[i].x + array[i].r + array[i].vx > canvas.x + canvas.w) {
            array[i].vx = -array[i].vx;
        }

        if (array[i].y + array[i].r + array[i].vy > canvas.y + canvas.h || array[i].y - array[i].r + array[i].vy < canvas.y) {
            array[i].vy = -array[i].vy;
        }

        array[i].x += array[i].vx + 0.1;
        array[i].y += array[i].vy + 0.1;
    }

    requestAnimationFrame(animate);
}
requestAnimationFrame(animate);

function meet() {
    for (var k = 0; k < array.length; ++k ) {
        for (var j = k + 1; j < array.length; ++j ) {
            var length = Math.sqrt(Math.pow((array[k].x - array[j].x),2) + Math.pow((array[k].y - array[j].y),2));
            if(length < (array[k].r + array[j].r)){
                if(array[k].color == array[j].color ){
                    if(array[j].r > array[k].r) {
                        array[j].r = array[j].r + 4;
                        array[j].vx = array[j].vx - 1;
                        array[j].vy = array[j].vy - 1;
                        array.splice(k, 1);
                        continue;
                    } else {
                        array[k].r = array[k].r + 4;
                        array[k].vx = array[k].vx - 1;
                        array[k].vy = array[k].vy - 1;
                        array.splice(j, 1);
                        continue;
                    }
                }
               array[k].vx = -1*array[k].vx;
               array[k].vy = -1*array[k].vy;
               array[j].vx = -1*array[j].vx;
               array[j].vy = -1*array[j].vy;
            }
        }
    }
}
