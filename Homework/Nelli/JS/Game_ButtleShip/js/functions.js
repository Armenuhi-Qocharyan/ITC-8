document.getElementById("start").addEventListener("click", startGame);

function printShips(size, direction , id) {
    document.getElementById(id).style.background = "red";
    for (var i = 0; i < size; ++i) {
        if (direction === "rigth") {
            newId = (Number(id) + i) + "";
            document.getElementById(newId).style.background = "red";
        } else if (direction === "bottom") {
            newId = (Number(id) + i * 10) + "";
            document.getElementById(newId).style.background = "red";
        }
    }

}

var size = 0;
var direction = "";
var id = "";
function allowDrop(ev) {
    ev.preventDefault();
}

function drag(ev) {
    ev.dataTransfer.setData("text", ev.target.id);
    size = ev.target.id;
}

function drop(ev) {
    ev.preventDefault();
    var data = ev.dataTransfer.getData("text");
  //  ev.target.style.background = "url('images/shp.png')";
    id = ev.target.id;
    printShips(size , "rigth" , id);
}

function startGame() {
    document.getElementById("photo").style.display = "none";
    document.getElementById("start").style.display = "none";
    document.getElementById("ships").style.display = "block";
    document.getElementById("shipArea1").style.display = "inline-block";
    drowTable(10 , 10 , "shipArea1");
    drowTable(10 , 10 , "shipArea2");
    drowShip(4);
    drowShip(3);
    drowShip(2);
    drowShip(1);
    setElementId("shipArea1");

 }


function drowTable(row, column, id) {
    var content = "<table cellpadding='18' cellspacing='18'>";
    for (var i = 1; i <= row; ++i) {
        content += "<tr>";
        for (var j = 1; j <= column; ++j) {
            content += "<td class='partOfShip' ondrop='drop(event)' ondragover='allowDrop(event)'></td>";
        }
        content += "</tr>";
    }
    content += "</table>";
    document.getElementById(id).innerHTML += content;
}

function drowShip(size) {
    var content = "<img src='images/shp.png' class='part' id= " + size + " draggable='true' ondragstart='drag(event)'>";
    document.getElementById("ships").innerHTML += content;
}

function setElementId(parentId) {
    var row = document.getElementById(parentId).childNodes[0].childNodes[0].childElementCount;
    var column = document.getElementById(parentId).childNodes[0].childNodes[0].childNodes[0].childElementCount;

    for (var i = 0; i < row; ++i) {
        for (var j = 0; j < column; ++j) {
            document.getElementById(parentId).childNodes[0].childNodes[0].childNodes[i].childNodes[j].id = i + '' + j;
        }
    }
}


