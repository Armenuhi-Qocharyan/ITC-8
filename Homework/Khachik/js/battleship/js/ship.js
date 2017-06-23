var sh = 0;
var top = 0;
var arr = [];
var countShips = 0;
var start = false;

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
			square.addEventListener("click", function () {findShip(this.id)});						
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
	document.getElementById("start").addEventListener("click", function () {
		if(countShips === 8) {
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
		        ship.style.left = e.pageX - ship.offsetWidth / 2 + 'px';
		        ship.style.top = e.pageY + 'px';
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
	if (elem.id === "" || elem.id === "shipCont" || (elem.id[0] === "s" && elem.id[1] === "h")) {
		return "block";
	} else {
		return shipInBoard(elem, ship);;
	}
}

var shipInBoard = function(elem,ship) {
	var retVal = 0; 
	retVal = ship_1(elem,ship);
	if (retVal === "block") {
		return  "block";
	}
	retVal = ship_2(elem,ship);
	if (retVal === "block") {
		return  "block";
	}
	retVal = ship_3(elem,ship);
	return retVal;
}


var ship_1 = function(elem,ship) {
	if (ship.id[5] === "0" || ship.id[5] === "1" || ship.id[5] === "2" || ship.id[5] === "3") {
		if(elem.id[1] === "9" || elem.style.backgroundColor === "rgb(175, 175, 175)" || elem.style.backgroundColor === "rgb(221, 221, 221)"){
			ship.style.position = "absolute";
			ship.style.top = "81px";
			ship.style.left = Number(ship.id[5]) * 40 + "px";
			return "block";
		}
		
		
		var pos = Number(elem.id[1]) + 1;
		
		
		if (document.getElementById(elem.id[0] + (pos) + (Number(elem.id[2]))).style.backgroundColor === "rgb(221, 221, 221)") {
			ship.style.position = "absolute";
			ship.style.top = "81px";
			ship.style.left = Number(ship.id[5]) * 40 + "px";
			return "block";		
		}
		elem.style.backgroundColor = "#afafaf";
		arr[pos - 1][elem.id[2]] = 1;
		arr[pos ][elem.id[2]] = 1;
		document.getElementById(elem.id[0] + pos + elem.id[2]).style.backgroundColor = "#afafaf";
		if(elem.id[2] != "9"){
			document.getElementById(elem.id[0] + (pos - 1) + (Number(elem.id[2]) + 1)).style.backgroundColor = "#ddd";
			document.getElementById(elem.id[0] + (pos) + (Number(elem.id[2]) + 1)).style.backgroundColor = "#ddd";
		}
		if(elem.id[1] != "8"){
			if(elem.id[2] != "9"){
				document.getElementById(elem.id[0] + (pos + 1) + (Number(elem.id[2]) + 1)).style.backgroundColor = "#ddd";
			}
			document.getElementById(elem.id[0] + (pos + 1) + (Number(elem.id[2]) )).style.backgroundColor = "#ddd";
			if(elem.id[2] != "0"){
				document.getElementById(elem.id[0] + (pos + 1) + (Number(elem.id[2]) - 1)).style.backgroundColor = "#ddd";
			}
		}
		if(elem.id[2] != "0"){
			document.getElementById(elem.id[0] + (pos - 1) + (Number(elem.id[2]) - 1)).style.backgroundColor = "#ddd";
			document.getElementById(elem.id[0] + (pos) + (Number(elem.id[2]) - 1)).style.backgroundColor = "#ddd";
		}
		if(elem.id[1] != "0") {
			if(elem.id[2] != "0"){
				document.getElementById(elem.id[0] + (pos - 2)  + (Number(elem.id[2]) - 1)).style.backgroundColor = "#ddd";
			}
			if(elem.id[2] != "9"){
				document.getElementById(elem.id[0] + (pos - 2) + (Number(elem.id[2]) + 1)).style.backgroundColor = "#ddd";
			}
			document.getElementById(elem.id[0] + (pos - 2) + (Number(elem.id[2]) )).style.backgroundColor = "#ddd";
		}
		countShips++;
		return "none";
	}

}

var ship_2 = function(elem,ship) {
	if (ship.id[5] === "4" || ship.id[5] === "5") {
		if(elem.id[1] === "9" || elem.id[1] === "8" || elem.style.backgroundColor === "rgb(175, 175, 175)" || elem.style.backgroundColor === "rgb(221, 221, 221)"){
			ship.style.position = "absolute";
			ship.style.top = "81px";
			ship.style.left = Number(ship.id[5]) * 40 + "px";
			return "block";
		}


		var pos = Number(elem.id[1]) + 1;
		if (document.getElementById(elem.id[0] + (pos) + (Number(elem.id[2]))).style.backgroundColor === "rgb(221, 221, 221)" || 
			document.getElementById(elem.id[0] + (pos + 1) + (Number(elem.id[2]))).style.backgroundColor === "rgb(221, 221, 221)") {
			ship.style.position = "absolute";
			ship.style.top = "81px";
			ship.style.left = Number(ship.id[5]) * 40 + "px";
			return "block";		
		}
		elem.style.backgroundColor = "#afafaf";
		arr[pos - 1][elem.id[2]] = 1;
		document.getElementById(elem.id[0] + pos++ + elem.id[2]).style.backgroundColor = "#afafaf";
		if(elem.id[2] != "9"){
			document.getElementById(elem.id[0] + (pos - 2) + (Number(elem.id[2]) + 1)).style.backgroundColor = "#ddd";
			document.getElementById(elem.id[0] + (pos - 1) + (Number(elem.id[2]) + 1)).style.backgroundColor = "#ddd";
			document.getElementById(elem.id[0] + (pos ) + (Number(elem.id[2]) + 1)).style.backgroundColor = "#ddd";
			
		}
		if(elem.id[1] != "7"){
			if(elem.id[2] != "9"){
				document.getElementById(elem.id[0] + (pos + 1) + (Number(elem.id[2]) + 1)).style.backgroundColor = "#ddd";
			}
			document.getElementById(elem.id[0] + (pos + 1) + (Number(elem.id[2]) )).style.backgroundColor = "#ddd";
			if(elem.id[2] != "0"){
				document.getElementById(elem.id[0] + (pos + 1) + (Number(elem.id[2]) - 1)).style.backgroundColor = "#ddd";
			}
		} 
		if(elem.id[2] != "0"){
			document.getElementById(elem.id[0] + (pos - 2) + (Number(elem.id[2]) - 1)).style.backgroundColor = "#ddd";
			document.getElementById(elem.id[0] + (pos - 1) + (Number(elem.id[2]) - 1)).style.backgroundColor = "#ddd";
			document.getElementById(elem.id[0] + (pos ) + (Number(elem.id[2]) - 1)).style.backgroundColor = "#ddd";
		}

		if(elem.id[1] != "0") {
			if(elem.id[2] != "0"){
				document.getElementById(elem.id[0] + (pos - 3) + (Number(elem.id[2]) - 1)).style.backgroundColor = "#ddd";
			}
			if(elem.id[2] != "9"){
				document.getElementById(elem.id[0] + (pos - 3) + (Number(elem.id[2]) + 1)).style.backgroundColor = "#ddd";
			}
			document.getElementById(elem.id[0] + (pos - 3) + (Number(elem.id[2]) )).style.backgroundColor = "#ddd";
		}
		
		arr[pos - 1][elem.id[2]] = 1;
		arr[pos][elem.id[2]] = 1;
		document.getElementById(elem.id[0] + pos + elem.id[2]).style.backgroundColor = "#afafaf";
		countShips++;
		return "none";
	}
}

var ship_3 = function(elem, ship) {
	if (ship.id[5] === "6" || ship.id[5] === "7") {
		if(elem.id[1] === "9" || elem.id[1] === "8" || elem.id[1] === "7" || elem.style.backgroundColor === "rgb(175, 175, 175)" || elem.style.backgroundColor === "rgb(221, 221, 221)"){
			ship.style.position = "absolute";
			ship.style.top = "81px";
			ship.style.left = Number(ship.id[5]) * 40 + "px";
			return "block";
		}
		
		var pos = Number(elem.id[1]) + 1;
		if (document.getElementById(elem.id[0] + (pos) + (Number(elem.id[2]))).style.backgroundColor === "rgb(221, 221, 221)" || 
			document.getElementById(elem.id[0] + (pos + 1) + (Number(elem.id[2]))).style.backgroundColor === "rgb(221, 221, 221)" ||
			document.getElementById(elem.id[0] + (pos + 2) + (Number(elem.id[2]))).style.backgroundColor === "rgb(221, 221, 221)") {
			ship.style.position = "absolute";
			ship.style.top = "81px";
			ship.style.left = Number(ship.id[5]) * 40 + "px";
			return "block";		
		}
		elem.style.backgroundColor = "#afafaf";
		arr[pos - 1][elem.id[2]] = 1;
		if(elem.id[2] != "9"){
			document.getElementById(elem.id[0] + (pos - 1) + (Number(elem.id[2]) + 1)).style.backgroundColor = "#ddd";
			document.getElementById(elem.id[0] + (pos) + (Number(elem.id[2]) + 1)).style.backgroundColor = "#ddd";
			document.getElementById(elem.id[0] + (pos + 1) + (Number(elem.id[2]) + 1)).style.backgroundColor = "#ddd";
			document.getElementById(elem.id[0] + (pos + 2) + (Number(elem.id[2]) + 1)).style.backgroundColor = "#ddd";
	
		}
		if(elem.id[1] != "6"){
			if(elem.id[2] != "9"){
				document.getElementById(elem.id[0] + (pos + 3) + (Number(elem.id[2]) + 1)).style.backgroundColor = "#ddd";
			}
			if(elem.id[2] != "0"){
				document.getElementById(elem.id[0] + (pos + 3) + (Number(elem.id[2]) - 1)).style.backgroundColor = "#ddd";
			}
			document.getElementById(elem.id[0] + (pos + 3) + (Number(elem.id[2]))).style.backgroundColor = "#ddd";
		}
		if(elem.id[2] != "0"){
			document.getElementById(elem.id[0] + (pos + 2) + (Number(elem.id[2]) - 1)).style.backgroundColor = "#ddd";
			document.getElementById(elem.id[0] + (pos + 1) + (Number(elem.id[2]) - 1)).style.backgroundColor = "#ddd";
			document.getElementById(elem.id[0] + (pos) + (Number(elem.id[2]) - 1)).style.backgroundColor = "#ddd";
			document.getElementById(elem.id[0] + (pos - 1) + (Number(elem.id[2]) - 1)).style.backgroundColor = "#ddd";
		}
		if(elem.id[1] != "0") {
			if(elem.id[2] != "0"){
				document.getElementById(elem.id[0] + (pos - 2) + (Number(elem.id[2]) - 1)).style.backgroundColor = "#ddd";
			}
			if(elem.id[2] != "9"){
				document.getElementById(elem.id[0] + (pos - 2) + (Number(elem.id[2]) + 1)).style.backgroundColor = "#ddd";
			}
			document.getElementById(elem.id[0] + (pos - 2) + (Number(elem.id[2]))).style.backgroundColor = "#ddd";
		}
		document.getElementById(elem.id[0] + pos++ + elem.id[2]).style.backgroundColor = "#afafaf";
		arr[pos - 1][elem.id[2]] = 1;
		document.getElementById(elem.id[0] + pos++ + elem.id[2]).style.backgroundColor = "#afafaf";
		arr[pos - 1][elem.id[2]] = 1;
		arr[pos ][elem.id[2]] = 1;
		document.getElementById(elem.id[0] + pos + elem.id[2]).style.backgroundColor = "#afafaf";
		countShips++;
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
		} else {
			document.getElementById("s" + x + y).style.backgroundColor = "#ddd";
		}
	}
}