var scores = 0,
    board = [],
    layingShips = 0,
    shipsOnBoard = 0,
    hitten = 0,
    missed = 0,
    start = false;

document.getElementById("button").addEventListener('click', function start() {
    // Prepare area
    var content = document.getElementById("cont");
    content.setAttribute("id", "content");
    document.body.style.backgroundImage = "url('sources/wallpaper.jpg')";
    var button = document.getElementById("button");
    button.style.display = 'none';
    var play = document.getElementById("play");
    play.style.display = 'block';

    // Create initial board
    for (var i = 0; i < 10; ++i) {
        board[i] = [];
        for (var j = 0; j < 10; ++j) {
            board[i][j] = 0;
        } 
    }
    drawTable();
});

function drawTable() {
    var rows = 10,
        columns = 10,
        side = 40,
        content = document.getElementById("content");

    // Create cells
    for (var i = 0; i < rows; ++i) {
        for (var j = 0; j < columns; ++j) {
            var cell = document.createElement('div');
            content.appendChild(cell);
            cell.setAttribute("id", id);
            cell.setAttribute("class", "cell");
            marginTop = i * side + 60;
            marginLeft = j * side + 100;
            cell.style.top = marginTop + "px";
            cell.style.left = marginLeft + "px";
            var id = "cell_" + i + "_" + j; 
            cell.addEventListener("click", function() {
                if (hitShip(this.id) === "finish") {
                    document.getElementById("finish").style.display = "block";
                } else if (hitShip(this.id) === "gameover") {
                    document.getElementById("gameover").style.display = "block";
                }
            });
        }
    }
    drawShipContainer();
}

// Draw ship container with ships
function drawShipContainer() {
    var shipContainer = document.getElementById("shipContainer");
    shipContainer.style.display = 'block';
    for (var i = 1, j = 4; i < 5; ++i, --j) {
        var className = "ship_" + i;
        drawShip(className, j, shipContainer);
    }
}

// Draw current ship in container
function drawShip(className, count, shipContainer) {
    for (var i = 0; i < count; ++i) {
        ++layingShips;
        var currentShip = document.createElement('div');
        currentShip.className = className;
        currentShip.id = "ship_" + layingShips;
        var top = (layingShips < 7) ? "60px" : "160px",
            right = (layingShips < 7) ? layingShips * 40.5 : (layingShips - 6) * 40.5;
        currentShip.style.top = top;
        currentShip.style.right = right + "px";
        shipContainer.appendChild(currentShip);
        currentShip.addEventListener('hover', drag(layingShips));
    }
}

// Drag and drop functionality
var drag = function(shipNumber) {
    var ship = document.getElementById("ship_" + shipNumber);
    // Catch click event
    ship.onmousedown = function(e) {
        ship.style.position = "absolute";
        moveAt(e);
        document.body.appendChild(ship);
        ship.style.zIndex = 1000;

        // Function for walking after mouse
        function moveAt(e) {
            ship.style.left = e.pageX + 'px';
            ship.style.top = e.pageY + 'px';
        }

        // Move ship after mouse
        document.onmousemove = function(e) {
            moveAt(e);
        };

        // Drop ship into board
        ship.onmouseup = function(e) {
            ship.style.display = "none";
            var element = document.elementFromPoint(e.clientX, e.clientY);
            if (endDrag(element, ship) === "block") {
                var shipContainer = document.getElementById("shipContainer");
                ship.style.display = "block";
                shipContainer.appendChild(ship);
                ship.style.top = (Number(ship.className[6]) * 40) + "px";
                ship.style.left = Number(ship.id[6] * 40) + "px";
            }

            document.onmousemove = null;
            ship.onmouseup = null;
        }
    }
    ship.ondragstart = function() {
        return false;
    }
}

var endDrag = function(element, ship) {
    var check = false;
    if (element.id === "" || element.id === "shipContainer" ||
        element.id[0] === "" || element.id === "play") {
        return "block";
    } else {
        check = locate(element, ship, check);
        if (check === true) {
            return locateShip(element, ship);
        } else {
            return "block";
        }
    }
}

// Check location possibility for each ship
function locate(element, ship, check) {
    for (var i = 0; i < Number(ship.className[6]); ++i) {
        if (Number(element.id[6]) + i === 10) {
            return "block";
        } 
        var newElement = document.getElementById("ship_" + element.id[4] + (Number(element.id[6] + i)));
        check = true;
        if (!shipIsInBoard(newElement, ship)) {
            check = false;
            break;
        }
    }
    return check;
}

// Check if ship can be located in board or not
function shipIsInBoard(element, ship) {
    var x = Number(element.id[4]),
        y = Number(element.id[6]);
    for (var i = x -1; i <= x + 1; ++i) {
        for (var j = y - 1; j <= y + 1; ++j) {
            var newID = "ship_" + i + "_" + j;
            if (i != -1 && j != -1 && i != 10 && j != 10) {
                if (document.getElementById(newId).style.backgroundColor != "") {
                return false;
                }
            }
        }
    }
    return true;
}

function locateShip(element, ship) {
    ++shipsOnBoard;
    var x = Number(element.id[4]),
        y = Number(element.id[6]);
    for (var o = 0; i < Number(ship.className[6]); ++i) {
        document.getElementById("ship_" + x + "_" + (y + i)).style.background = "a7a7a7";
        board[x][y + i] = 1;
    }

    if (shipsOnBoard === 10) {
        document.getElementById("play").style.display = "inline-block";
    }
    return "none";
}

function clearBoard() {
    document.getElementById("play").style.display = "none";
    for (var i = 0; i < 10; ++i) {
        for (var j = 0; j < 10; ++j) {
            document.getElementById("ship_" + i + "_" + j).style.backgroundColor = "#fff";
        }
    }
}

document.addEventListener('DOMContentLoaded', function() {
    document.getElementById("play").addEventListener("click", function() {
        if (shipsOnBoard === 10 && start === false) {
            clearBoard();
            start = true;
        }
    });
});

function hitShip(cellId) {
    if (start === true) {
        var x = cellId[4],
            y = cellId[6];
        if (board[x][y] === 1 && document.getElementById("ship_" + x + "_" + y).style.backgroundColor != "#ff0000") {
            document.getElementById("ship_" + x + "_" + y).style.backgroundColor = "#ff0000";
            ++hitten;
            if (hitten === 20) {
                return "finish";
            }
        } else if (document.getElementById("ship_" + x + "_" + y).style.opacity != "0.1" && document.getElementById("ship_" + x + "_" + y).style.backgroundColor != "#ff0000") {
            ++missed;
            document.getElementById("ship_" + x + "_" + y).style.opacity = "0.1";
            if (missed === 20) {
                return "gameover";
            }
        }

    }
}
