var canvas = document.getElementById("my_canvas");
var c = canvas.getContext("2d");
var count = 18;
var onOff = false;

var start = function () {
  onOff = true;
}

//create te container that will hold the boincing balls.
var container = {
  x: 0,
  y: 0,
  width: 600,
  height: 300
};
//create the array of circles that will be animated
var circles = [{
  r: 20,
  vx: 3,
  vy: 2,
  color: 125
}, {
  r: 20,
  vx: 1,
  vy: 3,
  color: 205
}, {
  r: 20,
  vx: 7,
  vy: 5,
  color: 325
},{
  r: 10,
  vx: 6,
  vy: 3,
  color: 125
}, {
  r: 10,
  vx: 4,
  vy: 8,
  color: 205
}, {
  r: 10,
  vx: 1,
  vy: 2,
  color: 325
},{
  r: 5,
  vx: 2,
  vy: 6,
  color: 125
}, {
  r: 5,
  vx: 3,
  vy: 3,
  color: 205
}, {
  r: 5,
  vx: 9,
  vy: 4,
  color: 325
},{
  r: 20,
  vx: 3,
  vy: 2,
  color: 125
}, {
  r: 20,
  vx: 1,
  vy: 3,
  color: 205
}, {
  r: 20,
  vx: 7,
  vy: 5,
  color: 325
},{
  r: 10,
  vx: 6,
  vy: 3,
  color: 125
}, {
  r: 10,
  vx: 4,
  vy: 8,
  color: 205
}, {
  r: 10,
  vx: 1,
  vy: 2,
  color: 325
},{
  r: 5,
  vx: 2,
  vy: 6,
  color: 125
}, {
  r: 5,
  vx: 3,
  vy: 3,
  color: 205
}, {
  r: 5,
  vx: 9,
  vy: 4,
  color: 325
}, 
];

for(var i = 0; i < circles.length; ++i) {
  circles[i].x =  Math.floor((Math.random() * 500) + 20);
  circles[i].y =  Math.floor((Math.random() * 250) + 20);
}

function animate() {
  //draw the container
  c.fillStyle = "#000000";
  c.fillRect(container.x, container.y, container.width, container.height);

  //loop throughj the circles array
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

    circles[i].x += circles[i].vx
    circles[i].y += circles[i].vy
    for(var j = 0; j < circles.length; ++j){
      if (Math.abs(circles[i].x - circles[j].x) < (circles[i].r + circles[j].r) && i!=j && 
        (Math.abs(circles[i].y - circles[j].y) < (circles[i].r + circles[j].r))) {
        if(circles[i].r >= circles[j].r && count > 3  && onOff === true){
          circles[i].vx = -circles[i].vx;
          circles[i].vy = -circles[i].vy;
          circles[j].r = 0;
          circles[j].x = 0;
          circles[j].y = 0;
          circles[j].vy = 0;
          circles[j].vx = 0;
          circles[i].r += 5;
          count--;
        }
        if (onOff === false) {
          circles[i].vx = -circles[i].vx;
          circles[i].vy = -circles[i].vy;
        }
      }
    }
  }

  setTimeout(animate,100);
}
setTimeout(animate,100);
