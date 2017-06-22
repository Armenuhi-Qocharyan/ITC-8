var getShip = function () {
    alert(this.id);
};
var dropShip = function () {
    alert(this.id);
};

var drawTable = function (location) {
    var newTable = document.createElement("TABLE");
    newTable.setAttribute("id", "myBattleTable");
    location.appendChild(newTable);

    for (var i = 0; i < 10; i++) {
        var newTrow = document.createElement("tr");
        newTrow.setAttribute("id", location.title + "tr" + i);
        newTable.appendChild(newTrow);
        for (var j = 0; j < 10; j++) {
            var newCol = document.createElement("TD");
            newCol.setAttribute("id", location.title + "tr" + i + "col" + j);
            newCol.setAttribute("class", "");
            newCol.addEventListener("mouseup",dropShip);
            //newCol.appendChild(document.createTextNode("B"))
            newTrow.appendChild(newCol);
        }
    }
    return newTable;
};

var drawBattle = function (location) {
    btn = document.createElement("button");
    btn.setAttribute("id", "ship" + 1)
    btn.style.width = "40px";
    btn.style.height = "40px";
    btn.setAttribute("id", "ship1");
    btn.setAttribute("draggable", "true");
    btn.addEventListener("mousedown",getShip);
    //btn.addEventListener("mouseup",dropShip);
    location.appendChild(btn);
};


var div1 = document.createElement("div");
var div2 = document.createElement("div");
var div3 = document.createElement("div");

div1.setAttribute("class", "board");
div1.setAttribute("title", "board1");


div2.setAttribute("class", "board");
div2.setAttribute("title", "board2");

div3.setAttribute("class", "shipBoard");

drawTable(div1);
drawTable(div2);
drawBattle(div3);

document.body.appendChild(div1);
document.body.appendChild(div2);
document.body.appendChild(div3);



