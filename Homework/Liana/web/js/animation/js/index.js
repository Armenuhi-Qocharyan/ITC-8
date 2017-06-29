var canvas = document.getElementById("my_canvas"),
    c = canvas.getContext("2d"),
    circles = [],
    removed = false,
    container = {
        x: 0,
        y: 0,
        width: 600,
        height: 600
    };

function bubble(x, y, r, vx, vy, color, name) {
    this.x = x;
    this.y = y;
    this.r = r;
    this.vx = vx;
    this.vy = vy;
    this.color = color;
    this.name = name;

}

circles[0] = new bubble(50, 10, 10, 2, 4, 150, "a");
circles[1] = new bubble(150, 200, 12, 4, 3, 205, "b");
circles[2] = new bubble(60, 150, 5, 2, 4, 15, "c");
circles[3] = new bubble(100, 50, 15, 5, 1, 50, "d");
circles[4] = new bubble(20, 90, 10, 4, 3, 205, "e");
circles[5] = new bubble(70, 9, 8, 3, 5, 205, "f");
circles[6] = new bubble(250, 120, 14, 4, 5, 15, "g");
circles[7] = new bubble(90, 20, 9, 4, 1, 15, "h");
circles[8] = new bubble(16, 55, 16, 5, 4, 150, "i");
circles[9] = new bubble(170, 250, 5, 4, 5, 150, "j");
circles[10] = new bubble(220, 180, 10, 1, 6, 50, "k");
circles[11] = new bubble(270, 100, 6, 4, 3, 50, "l");

function check(index) {

    if (circles[index].x - circles[index].r + circles[index].vx <= container.x || circles[index].x + circles[index].r + circles[index].vx >= container.x + container.width) {
        circles[index].vx = -circles[index].vx;
    }

    if (circles[index].y + circles[index].r + circles[index].vy >= container.y + container.height || circles[index].y - circles[index].r + circles[index].vy <= container.y) {
        circles[index].vy = -circles[index].vy;
    }
    for (var i = 0; i < circles.length; ++i) {
        if (circles[index].name != circles[i].name) {
            var a = circles[index].x - circles[i].x,
                b = circles[index].y - circles[i].y,
                c = Math.sqrt(a * a + b * b);
				diff = circles[index].r + circles[i].r;
            if (c < diff) {
                if (circles[i].color != circles[index].color) {
                    circles[i].vx = -circles[i].vx;
					circles[i].vy = -circles[i].vy;
                } else {
                    if (circles[i].r > circles[index].r) {
                        circles[i].r += circles[index].r;
                        circles.splice(index, 1);
						if (index > 0) {
							index--;
						}
                    } else {
                        circles[index].r += circles[i].r;
                        circles.splice(i, 1);
						i--;
                    }
					
                }
            }

        }
    }
    if (circles.length == 4) {
        window.location.href = "";
    }
}


function animate() {
    c.fillStyle = "#092450";
    c.fillRect(container.x, container.y, container.width, container.height);

    for (var i = 0; i < circles.length; i++) {
        c.fillStyle = 'hsl(' + circles[i].color + ', 100%, 50%)';
        c.beginPath();
        c.arc(circles[i].x, circles[i].y, circles[i].r, 0, Math.PI * 2, true);
        c.fill();
        check(i);
        if (circles[i]) {
            circles[i].x += circles[i].vx;
            circles[i].y += circles[i].vy;
        }
    }


    requestAnimationFrame(animate);
}
requestAnimationFrame(animate);
