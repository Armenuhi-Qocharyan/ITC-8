var getShip = function () {
    console.log(this.className);
    currentShip = this;
};

var dropShip = function () {
    if (gameIsStarted) {

    } else if (currentShip != null) {
        if (checkValidDrop(currentShip.className, this.id)) {
            drawShipInBoard(currentShip, this);
            console.log(this.id);
            hideShip(currentShip);
            currentShip = null;
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
            newCol.addEventListener("click",dropShip);
            //newCol.appendChild(document.createTextNode("B"))
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

    return true;
};

var dropToBoard = function () {

};

var drawShipInBoard = function (ship, position) {
    var shipLength = +(ship.className[4]),
        row = +(position.id[2]),
        col = +(position.id[4]);
        //console.log(row, col);

    for (var i = row - 1; i < row + shipLength +1; ++i) {
        if (i < 0) continue;
        for (var j = col - 1; j <= col + 1; j++) {
            if (j < 0) continue;
            document.getElementById("1." + i + "." +j).style.backgroundColor = "green";
            console.log(i, j);

        }
    }
    //position.style.backgroundColor = 'green';
};

var div1 = document.createElement("div");
var div2 = document.createElement("div");
var div3 = document.createElement("div");

var gameIsStarted = false,
    currentShip;


div1.setAttribute("class", "board");
div1.setAttribute("title", "board1");

div2.setAttribute("class", "board");
div2.setAttribute("title", "board2");

div3.setAttribute("class", "shipBoard");

table1 = drawTable(div1, 1);
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

document.body.appendChild(div1);
document.body.appendChild(div2);
document.body.appendChild(div3);
