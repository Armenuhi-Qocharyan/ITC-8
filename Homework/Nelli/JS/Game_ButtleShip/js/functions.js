document.getElementById("start").addEventListener("click", startGame);
Ships = {'1': 4, '2': 3, '3': 2, '4': 1};

var player_2Area = [
    ['0','0','0','1','1','1','0','0','1','1'],
    ['1','0','0','0','0','0','0','0','0','0'],
    ['1','0','0','0','0','0','0','0','0','0'],
    ['1','0','1','1','0','0','1','1','1','0'],
    ['1','0','0','0','0','0','0','0','0','0'],
    ['0','0','0','0','0','0','0','1','0','0'],
    ['0','0','0','0','0','0','0','0','0','0'],
    ['1','0','1','0','0','0','0','0','1','0'],
    ['0','0','0','0','0','0','0','0','1','0'],
    ['0','0','0','1','0','0','0','0','0','0']
];

var player1Count = 0,
    player2Count = 0,
    size = 0,
    id = "";

function startGame() {
    document.getElementById("start").style.display = "none";
    document.getElementById("ships").style.display = "block";
    document.getElementById("shipArea1").style.display = "inline-block";
    drowTable(10 , 10 , "shipArea1");
    drowTable(10 , 10 , "shipArea2");
    drowShip(4);
    drowShip(3);
    drowShip(2);
    drowShip(1);
    setElementId("shipArea1", "");
    setElementId("shipArea2", "s");
}

function drowTable(row, column, id) {
    var content = "<table cellpadding='18' cellspacing='18'>";
    for (var i = 1; i <= row; ++i) {
        content += "<tr>";
        for (var j = 1; j <= column; ++j) {
            content += "<td class='partOfShip' ondrop='drop(event)' ondragover='allowDrop(event)' onclick='find(this.id)'></td>";
        }
        content += "</tr>";
    }
    content += "</table>";
    document.getElementById(id).innerHTML += content;
}

function drowShip(size) {
    content = "<img src='images/shp.png' class='part' id= " + size + " draggable='true' ondragstart='drag(event)' style='width:" + size * 40 + "px '>";
    document.getElementById("ships").innerHTML += content;
}

function setElementId(id, content) {
    var row = document.getElementById(id).childNodes[0].childNodes[0];
    var column = row.childNodes[0];
    for (var i = 0; i < row.childElementCount; ++i) {
        for (var j = 0; j < column.childElementCount; ++j) {
            row.childNodes[i].childNodes[j].id = content + i + '' + j;
        }
    }
}

function  setClass(id, color, imagePath) {
    var element = document.getElementById(id);
    element.style.backgroundImage = imagePath;
    element.style.backgroundSize = "cover";
    element.style.backgroundColor = color;
}


function allowDrop(ev) {
    ev.preventDefault();
}

function drag(ev) {
    ev.dataTransfer.setData("text", ev.target.id);
    size = Number(ev.target.id);
}

function drop(ev) {
    ev.preventDefault();
    id = ev.target.id;
    printShips(size , id);
}

function checkShip(size, id) {
    if (size === 0) {
        return true;
    }
    if (Number(id) % 10 + Number(size) > 10) {
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

function noShips() {
    for (var i = 1; i < 5; ++i) {
        i = i + "";
        if (Ships[i] !== 0) {
            return false;
        }
    }
    return true;
}

function printShips(size, id) {
    var newId = "";
    if (checkShip(size, id)) {
        for (var i = 0; i < size; ++i) {
            newId = (Number(id) + i);
            if (newId < 10) {
                newId = "0" + newId
            } else {
                newId += "";
            }
            setClass(newId, "red", "url('images/shp.jpg')");
        }
        --Ships[size];
        if (Ships[size] === 0) {
            size += "";
            document.getElementById(size).style.display = 'none';
        }
    } else {
        alert("Wrong location try again");
    }
    if (noShips()) {
        document.getElementById("shipArea2").style.display = "inline-block";
        document.getElementById("ships").style.display = "none";

    }
}

function  find(id) {
    var element = document.getElementById(id);
    if (id[0] === 's') {
        var i = Number(id[1]);
        var j = Number(id[2]);
        if (element.style.backgroundColor === "yellow" ||element.style.backgroundColor === "green") {
            return;
        }
        if (player_2Area[i][j] === '1') {
            setClass(id, "yellow", "url('images/del.jpg')");
            ++player1Count;
        } else {
            element.style.opacity = "0.2";
        }
        if (player1Count === 20) {
            alert("You win");
            Hide("shipArea1", "shipArea2");
        }
        setTimeout(computerStep , 400);
    }
}

function  computerStep() {
    var i = Math.ceil(Math.random() * 10 - 1);
    var j = Math.ceil(Math.random() * 10 - 1);
    var id = String(10 * i + j);
    var element = document.getElementById(id);
    if (element.style.backgroundColor === "yellow" || element.style.backgroundColor === "green") {
        computerStep();
    }else if (element.style.backgroundColor === "red") {
        setClass(id, "yellow", "url('images/del.jpg')");
        ++player2Count;
        if (player2Count === 20) {
            alert("Computer win");
            Hide("shipArea1", "shipArea2");
        }
    } else {
        element.style.opacity = "0.2";
    }
}

function Hide(id1, id2) {
    document.getElementById(id1).style.display = "none";
    document.getElementById(id2).style.display = "none";
}