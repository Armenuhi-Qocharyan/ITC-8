var scores = 0,
    board = [],
    layingShips = 0;

function start() {
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
}

function drawTable() {
    var rows = 10,
        columns = 10,
        side = 10,
        content = document.getElementById("content");

    // Create cells
    for (var i = 0; i < rows; ++i) {
        for (var j = 0; j < columns; ++j) {
            var cell = document.createElement('div');
            content.appendChild(cell);
            cell.setAttribute("id", id);
            cell.setAttribute("class", "cell");
            marginTop = i * side + 15;
            marginLeft = j * side + 25;
            cell.style.top = marginTop + "px";
            cell.style.left = marginLeft + "px";
            var id = "cell_" + i + "_" + j; 
           // cell.addEventListener("click",)
        }
    }
    drawShipContainer();
}

function drawShipContainer() {
    // Draw ship container with ships
    var shipContainer = document.getElementById("shipContainer");
    shipContainer.style.display = 'block';
    for (var i = 1, j = 4; i < 5; ++i, --j) {
        var className = "ship_" + i;
        drawShip(className, j, shipContainer);
    }
}

function drawShip(className, count, shipContainer) {
    // Draw current ship in container
    for (var i = 0; i < count; ++i) {
        ++layingShips;
        var currentShip = document.createElement('div');
        currentShip.className = className;
        var top = (layingShips < 7) ? "15px" : "40px",
            right = (layingShips < 7) ? layingShips * 10.5 : (layingShips - 6) * 10.5;
        currentShip.style.top = top;
        currentShip.style.right = right + "px";
        shipContainer.appendChild(currentShip);
    }
}


