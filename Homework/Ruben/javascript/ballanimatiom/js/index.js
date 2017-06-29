var canvas = document.getElementById("my_canvas");
var c = canvas.getContext("2d");
var circles = [];
//create te container that will hold the boincing balls.
var container = {
  x: 0,
  y: 0,
  width: 600,
  height: 500
};
//create the array of circles that will be animated
function ball(x,y,r,vx,vy,color){
  this.x = x;
  this.y = y;
    this.r = r;
    this.vx = vx;
    this.vy = vy;
    this.color = color;
};

circles[0] = new ball(50, 100, 10, 1, 6, 150);
circles[1] = new ball(60, 200, 10, 4, 3, 205);
circles[2] = new ball(70, 150, 10, 6, 4, 15);
circles[3] = new ball(80, 250, 10, 5, 4, 50);
circles[4] = new ball(90, 190, 10, 4, 3, 205);
circles[5] = new ball(100, 19, 10, 3, 5, 205);
circles[6] = new ball(310, 120, 10, 4, 5, 15);
circles[7] = new ball(220, 220, 10, 4, 1, 15);
circles[8] = new ball(530, 155, 10, 5, 4, 150);
circles[9] = new ball(440, 250, 10, 4, 5, 150);
circles[10] = new ball(500, 180, 10, 6, 6, 50);
circles[11] = new ball(460, 100, 10, 4, 3, 50);


function animate() {
  //draw the container
  c.fillStyle = "#000000";
  c.fillRect(container.x, container.y, container.width, container.height);
  for (var i = 0; i < circles.length; i++) {
    //draw the circles
    c.fillStyle = 'hsl(' + circles[i].color + ', 100%, 50%)';
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
    circles[i].x += circles[i].vx;
    circles[i].y += circles[i].vy;
    circles[i].vx +=0.1;
    circles[i].vy +=0.1;
  }
  requestAnimationFrame(animate);
}
requestAnimationFrame(animate);

