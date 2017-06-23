var sh = 0;
var arr = [];
var countShips = 0;
var start = false;
var p = 0;
var count = 0;
var globalShip;

for(var i = 0; i < 10; i++){
    arr[i] = [];    
    for(var j = 0; j < 10; j++){ 
        arr[i][j] = 0;    
    }    
}

$(document).ready(function(){
	var rows = 10;
	var cols = 10;
	var squareSize = 40;
	var gameBoardContainer = document.getElementById("gameboard");
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
			square.addEventListener("click", function () {
				if (findShip(this.id) === "end"){
					document.getElementById("gameOver").style.display = "block";
			}});						
		}
	}
	var shipsContainer = document.getElementById("shipCont");
	createShip(4,"ship_1", shipsContainer);
	createShip(3,"ship_2", shipsContainer);
	createShip(2,"ship_3", shipsContainer);
	createShip(1,"ship_4", shipsContainer);
});

var createShip = function(size, class_name,shipsContainer){
	for(var i = 0; i < size; ++i){
		var ship = document.createElement("div");
		ship.className = class_name;
		ship.id = "ship_" + (p++);
		ship.horVer = "h";
		ship.style.top = (200 - Number(ship.className[5]) * 40 -40) + "px";
		ship.style.left = (p * 40 - 40) + "px";
		shipsContainer.appendChild(ship);
	}
}

/*Dragndrop*/


function keyDownTextField (e) {
  var keyCode = e.keyCode;
  	if(keyCode === 32) {
  		var x = Number(globalShip.offsetWidth);
  		var y = Number(globalShip.offsetHeight);		
  		globalShip.style.height = x + "px";
  		globalShip.style.width = y + "px";
  		if(globalShip.horVer === "h"){
  			globalShip.horVer = "v";
  		} else {
  			globalShip.horVer = "h";
  		}
  	}
}
$(document).ready(function(){
	for(var i = 0; i < 10; ++i){
		drag(i);
	}
	document.getElementById("start").addEventListener("click", function () {
		if(countShips === 10 && start === false) {
			clearBoard();
			start = true;
		}
	});
	
});
var drag = function(shNum){
		var ship = document.getElementById('ship_' + shNum);
		ship.onmousedown = function(e) { 
		    ship.style.position = 'absolute';
		    moveAt(e);
		    document.body.appendChild(ship);
		    ship.style.zIndex = 1000; 
		    function moveAt(e) {
		    	if(ship.horVer === "h"){
		        	ship.style.left = e.pageX - ship.offsetWidth / 2 + 'px';
		        	ship.style.top = e.pageY + 'px';
		        } else {
		        	ship.style.left = e.pageX  + 'px';
		        	ship.style.top = e.pageY + 'px';
		        }
		    }
		    document.onmousemove = function(e) {
		        moveAt(e);
		        globalShip = ship;
		        document.addEventListener("keydown", keyDownTextField, false);
		    }
		    ship.onmouseup = function(e) {
		    	ship.style.display = 'none';
		    	var elem = document.elementFromPoint(event.clientX, event.clientY);
		    	if (endDrag(elem, ship) === "block"){
		    		var shipsContainer = document.getElementById("shipCont");
		    		ship.style.display = "block";
		    		shipsContainer.appendChild(ship);
		    		ship.style.top = (160 - Number(ship.className[5]) * 40) + "px";
		    		ship.style.left = Number(ship.id[5] * 40) + "px";
		    		/*if (ship.horVer === "v") {
		    			var x = Number(ship.offsetWidth);
				  		var y = Number(ship.offsetHeight);		
				  		ship.style.height = x + "px";
				  		ship.style.width = y + "px";
		    		}*/

		    	} else {
		    		ship.style.display = "none";
		        }
		        document.onmousemove = null;
		        ship.onmouseup = null;
		    }
		}
		ship.ondragstart = function() {
		    return false;
		};
}

var endDrag = function(elem, ship) {
	var check = false;
	if (elem.id === "" || elem.id === "shipCont" || (elem.id[0] === "s" && elem.id[1] === "h" || elem.id === "start")) {
		return "block";
	} else {
		if(ship.horVer === "h"){
			for(var i = 0; i < Number(ship.className[5]); ++i) {
				if (Number(elem.id[1]) + i === 10) {
					return "block";
				}
				var newElem = document.getElementById("s" + (Number(elem.id[1]) + i) + elem.id[2]);
				check = true;
				if (!shipInBoard(newElem,ship)){
					check = false;
					break;
				}
			}
		} else {
			for(var i = 0; i < Number(ship.className[5]); ++i) {
				if (Number(elem.id[2]) + i === 10) {
					return "block";
				}
				var newElem = document.getElementById("s"  + elem.id[1] + (Number(elem.id[2]) + i));
				check = true;
				if (!shipInBoard(newElem,ship)){
					check = false;
					break;
				}
			}
		}
		if (check === true) {
			return drawShip(elem,ship,"h");
		} else {
			return "block";
		}
	}
}

var shipInBoard = function(elem, ship) {
	var x = Number(elem.id[1]);
	var y = Number(elem.id[2]);
	for(var i = x - 1; i <= x + 1; ++i){
		for(var j = y - 1; j <= y + 1; ++j){
			var newId = "s" + i + j;
			if (i != -1 && j != -1 && i != 10 && j != 10){
				if (document.getElementById(newId).style.backgroundColor != ""){
					return false;
				}
			}
		}
	}
	return true;
}

var drawShip = function(elem,ship) {
	countShips++;
	if(ship.horVer === "h"){
		var x = Number(elem.id[1]);
		var y = Number(elem.id[2]);
		for(var i = 0; i < Number(ship.className[5]); ++i) {
			document.getElementById("s" + (x  + i) + y).style.backgroundColor = "#afafaf";
			arr[x + i][y] = 1;
		}
		return "none";
	} else {
		var x = Number(elem.id[1]);
		var y = Number(elem.id[2]);
		for(var i = 0; i < Number(ship.className[5]); ++i) {
			document.getElementById("s" + x + (y + i)).style.backgroundColor = "#afafaf";
			arr[x][y + i] = 1;
		}
		return "none";
	}
 }

var clearBoard = function() {
	for (var i = 0; i < 10 ; ++i) {
		for (var j = 0; j < 10 ; ++j) {
			document.getElementById("s" + i + j).style.backgroundColor = "white";
		}
	}
}

var findShip = function(squareId) {
	if (start === true) {
		var x = squareId[1];
		var y = squareId[2];
		if(arr[x][y] ===  1){
			document.getElementById("s" + x + y).style.backgroundColor = "red";
			count++;
			if (count === 20) {
				return "end";
			}
		} else {
			document.getElementById("s" + x + y).style.backgroundColor = "#ddd";
		}
	}
}