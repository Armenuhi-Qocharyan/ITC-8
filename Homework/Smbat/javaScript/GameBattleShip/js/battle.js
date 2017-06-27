var getShip = function () {
    currentShip = this;
};
var clickInTable = function () {
    if (gameIsStarted) {
        if (this.id[0] !== '2') return;
        var i = (+this.id[2]),
            j = (+this.id[4]);
        if (arrBoard1[i][j] === 1) {
            this.style.backgroundColor = "red";
            document.getElementById("1." + i + '.' + j).style.backgroundColor = "black";
            ++wound;
            if (wound === 20) {
                gameIsStarted = false;
                alert("Game Over");
            }
        } else {
            this.style.backgroundColor = "green";
        }

    } else if (currentShip !== null) {
        if (checkValidDrop(currentShip.className, this.id)) {
            drawShipInBoard(currentShip, this);
            hideShip(currentShip);
            currentShip = null;
            --shipCount;
            gameIsStarted = (shipCount === 0);
        } else {
            alert("Invalid Position");
        }
    }
};

var drawTable = function (location, tableId) {
    var newTable = document.createElement("TABLE");
    newTable.setAttribute("id", "myBattleTable");
    location.appendChild(newTable);

    for (var i = 0; i < 10; i++) {
        var newTrow = document.createElement("tr");
        newTrow.setAttribute("id", location.title + "tr" + i);
        newTable.appendChild(newTrow);
        for (var j = 0; j < 10; j++) {
            var newCol = document.createElement("TD");
            newCol.setAttribute("id", tableId + "."  + i + "." + j);
            newCol.setAttribute("class", "");
            newCol.addEventListener("click",clickInTable);
            newTrow.appendChild(newCol);
        }
    }
    return newTable;
};

var drawShip = function (location, size) {
    btn = document.createElement("button");
    btn.setAttribute("class", "ship" + size);
    btn.style.width = "40px";
    btn.style.height = (size * 40) + "px";
    btn.setAttribute("draggable", "true");
    btn.addEventListener("click",getShip);
    location.appendChild(btn);
    return btn;
};

var hideShip = function (ship) {
        ship.style.display = "none";
};

var checkValidDrop  = function(shipType, position){
    if (position[0] !== "1") return false;
    var shipLength = +(shipType[4]),
        row = +(position[2]),
        col = +(position[4]);
    for (var i = row; i < row + shipLength; ++i) {
        if (i > 9 || arrBoard1[i][col] !== undefined) return false;
    }
    return true;
};

var drawShipInBoard = function (ship, position) {
    var shipLength = +(ship.className[4]),
        row = +(position.id[2]),
        col = +(position.id[4]);
    for (var i = row - 1; i < row + shipLength +1; ++i) {
        if (i < 0 || i > 9) continue;
        for (var j = col - 1; j <= col + 1; j++) {
            if (j < 0 || j > 9) continue;
            if (i >= row && i < row + shipLength && j === col){
                document.getElementById("1." + i + "." +j).style.backgroundColor = "yellow";
                arrBoard1 [i][j] = 1;
            } else {
                //document.getElementById("1." + i + "." +j).style.backgroundColor = "green";
                arrBoard1 [i][j] = 0;
            }
        }
    }
};

var declareArr = function (arr) {
    for(var i = 0; i < 10; i++) {
        arr[i] = [];
    }
};

var tablesDiv = document.createElement("div"),
    div1 = document.createElement("div"),
    div2 = document.createElement("div"),
    div3 = document.createElement("div");

var gameIsStarted = false,
    currentShip = null,
    shipCount = 10,
    wound = 0,
    arrBoard1 = [];

declareArr(arrBoard1);

div1.setAttribute("class", "board");
div1.setAttribute("title", "board1");
div2.setAttribute("class", "board");
div2.setAttribute("title", "board2");
div3.setAttribute("class", "shipBoard");
tablesDiv.setAttribute("class", "tablesDiv");

drawTable(div1, 1);
drawTable(div2, 2);

drawShip(div3, 4);
drawShip(div3, 3);
drawShip(div3, 3);
drawShip(div3, 2);
drawShip(div3, 2);
drawShip(div3, 2);
drawShip(div3, 1);
drawShip(div3, 1);
drawShip(div3, 1);
drawShip(div3, 1);

tablesDiv.appendChild(div1);
tablesDiv.appendChild(div2);
document.body.appendChild(div3);
document.body.appendChild(tablesDiv);
