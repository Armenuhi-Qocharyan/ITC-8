document.getElementById("start").addEventListener("click", startGame);
Ships = {
    '1': 4,
    '2': 3,
    '3': 2,
    '4': 1
};
function checkShip(size, id) {
    if (size === 0) {
        return true;
    }
    if (Number(id) % 10 + Number(size) > 11) {
        alert("false");
        return false;
    }
    var x = Number(id[0]);
    var y = Number(id[1]);
    for (var i = x - 1; i <= x + 1; ++i) {
        for (var j = y -1; j <= y + 1 ; ++j) {
            if ((i !== -1 && j !== -1) && (i !== 10 && j !== 10)) {
                var newId = "" + i + j;
                if (document.getElementById(newId).style.backgroundColor !== "") {

                    return false;
                }
            }
        }
    }
    id = "" + x + (y + 1);
    return checkShip(size -1, id)
}

function printShips(size, direction , id) {
    if (checkShip(size, id)) {
        for (var i = 0; i < size; ++i) {
            if (direction === "rigth") {
                newId = (Number(id) + i);
                if (newId < 10) {
                    newId = "0" + newId
                } else {
                    newId += "";
                }
                document.getElementById(newId).style.backgroundImage = "url('images/shp.jpg')";
                document.getElementById(newId).style.backgroundSize = "cover";
                document.getElementById(newId).style.backgroundColor = "red";
            } else if (direction === "bottom") {
                newId = "" + i + id;
                document.getElementById(newId).style.backgroundImage = "url('images/shp.jpg')";
                document.getElementById(newId).style.backgroundSize = "cover";
                document.getElementById(newId).style.backgroundColor = "red";
            }
        }
        --Ships[size];
        if (Ships[size] === 0) {
            size += "";
            document.getElementById(size).style.display = 'none';
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
    size = Number(ev.target.id);
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
    var content = "<img src='images/shp.png' class='part' id= " + size + " draggable='true' ondragstart='drag(event)' style='width:" + size * 40 + "px '>";
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


