var canvas = document.getElementById("my_canvas");
var c = canvas.getContext("2d");

//create te container that will hold the boincing balls.
var container = {
  x: 0,
  y: 0,
  width: 600,
  height: 500
};
//create the array of circles that will be animated
var circles = [{
  x: 50,
  y: 100,
  r: 10,
  vx: 0.01,
  vy: 0.01,
  color: 125
}, {
  x: 50,
  y: 100,
  r: 10,
  vx: 0.1,
  vy: 0.1,
  color: 205
}, {
  x: 250,
  y: 100,
  r: 10,
  vx: 100,
  vy: 20,
  color: 25
}];

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
    if (i==circles.length-1){
alert( circles[i].x);
alert( circles[i-1].x);
	if (circles[i].x == circles[i-1].x + circles[i-1].vx){
        alert("kkkkk");
        }
    }else {
        if (circles[i].x == circles[i+1].x & circles[i].y == circles[i+1].y ){
	alert("rrrrr");
	}
    }
    circles[i].x += circles[i].vx;
    circles[i].y += circles[i].vy;
    circles[i].vx +=0.1;
    circles[i].vy +=0.1;
  }
  requestAnimationFrame(animate);
}
requestAnimationFrame(animate);
