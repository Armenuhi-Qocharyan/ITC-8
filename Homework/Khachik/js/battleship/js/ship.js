var sh = 0;
var top = 0;

$(document).ready(function(){
	var rows = 10;
	var cols = 10;
	var squareSize = 50;
	var gameBoardContainer = document.getElementById("gameboard");
	var p = 0;

	var left = 0;
	for (var i = 0; i < cols; i++) {
		for (j = 0; j < rows; j++) {
			
			var square = document.createElement("div");
			gameBoardContainer.appendChild(square);

			square.id = 's' + j + i;			

			var topPosition = j * squareSize;
			var leftPosition = i * squareSize;			

			square.style.top = topPosition + 'px';
			square.style.left = leftPosition + 'px';						
		}
	}

	var shipsContainer = document.getElementById("shipCont");
	for (var i = 0; i < 4; ++i) {
		var ship = document.createElement("div");
		ship.className = "ship_2 ";
		ship.id = "ship_" + p++;
		shipsContainer.appendChild(ship);
	}
	for (var i = 0; i < 2; ++i) {
		var ship = document.createElement("div");
		ship.className = "ship_3 ";
		ship.id = "ship_" + p++;
		shipsContainer.appendChild(ship);
	}
	for (var i = 0; i < 2; ++i) {
		var ship = document.createElement("div");
		ship.className = "ship_4 ";
		ship.id = "ship_" + (p++);
		shipsContainer.appendChild(ship);
		top = Number(ship.style.top);
		left = Number(ship.style.left);
	}
});

/*Dragndrop*/

$(document).ready(function(){
	for(var i = 0; i < 8; ++i){
		drag(i);
	}
});

var drag = function(shNum){
		var ship = document.getElementById('ship_' + shNum);
		ship.onmousedown = function(e) { 

		    ship.style.position = 'absolute';

		    moveAt(e);
		    document.body.appendChild(ship);
		    ship.style.zIndex = 1000; 
		    function moveAt(e) {
		        ship.style.left = e.pageX - ship.offsetWidth / 2 + 'px';
		        ship.style.top = e.pageY - ship.offsetHeight / 2 + 'px';
		    }
		    document.onmousemove = function(e) {
		        moveAt(e);
		    }
		    ship.onmouseup = function(e) {
		    	ship.style.display = 'none';
		    	var elem = document.elementFromPoint(event.clientX, event.clientY);
		    	ship.style.display = endDrag(elem, ship);
		        document.onmousemove = null;
		        ship.onmouseup = null;
		    }
		}
		ship.ondragstart = function() {
		    return false;
		};
}

var endDrag = function(elem, ship) {
	if (elem.id === "" || elem.id === "shipCont") {
		return "block";
	} else {
		elem.style.backgroundColor = "#afafaf";
		return "none";
	}

}
