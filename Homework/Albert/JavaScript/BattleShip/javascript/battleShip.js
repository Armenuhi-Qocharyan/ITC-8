var Ships = function(size, count, id) {
    this.size = size;
    this.count = count;
    this.id = id;
};
Ships.prototype.print = function(obj) {
    var ship = "<img src='images/ship3.png' class='img' id= "+this.id+" draggable='true' ondragstart='drag(event)' style='width:" + obj.size * 40 + "px '>";
    document.getElementById("forms").innerHTML += ship;
};
Ships.prototype.checkCount = function(obj) {
    if(obj.count === 0) {
        var removeShipImg = document.getElementById(obj.size);
        removeShipImg.parentNode.removeChild(removeShipImg);
    }
};
var ship1 = new Ships(1, 4, '1');
var ship2 = new Ships(2, 3, '2');
var ship3 = new Ships(3, 2, '3');
var ship4 = new Ships(4, 1, '4');

function createForm(row, column, id) {
    var table = "<table id='gamer_11' class='myTable' cellpadding='22' cellspacing='2'>";
    for (var i = 1; i <= row; ++i) {
        table += "<tr>";
        for (var j = 1; j <= column; ++j) {
            table += "<td class='tdClass'  onclick='findShips(this)' ondrop='drop(event)' ondragover='allowDrop(event)'></td>";
        }
        table += "</tr>";
    }
    table += "</table>";
    document.getElementById(id).innerHTML += table;
}

function startGame() {
    document.getElementById("shipImage").style.display = "none";
    document.getElementById("start").style.display = "none";
    document.getElementById("forms").style.display = "block";
    ship4.print(ship4);
    ship3.print(ship3);
    ship2.print(ship2);
    ship1.print(ship1);
    createForm(10,10, 'gamer_1');
    setElementId("gamer_1");
}

var start = 0;
var size = 0;
var id = "";
var arr = [];

for(var i = 0; i < 10; i++){
    arr[i] = [];
    for(var j = 0; j < 10; j++){
        arr[i][j] = 0;
    }
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
    printShips(size, id);
}

function checkLocation(size, id) {
    if (size === 0) {
        return true;
    }
    if (Number(id) % 10 + Number(size) > 10) {
        alert("Wrong location");
        return false;
    }
    var x = Number(id[0]);
    var y = Number(id[1]);
    for (var i = x - 1; i <= x + 1; ++i) {
        for (var j = y -1; j <= y + 1 ; ++j) {
            if ((i !== -1 && j !== -1) && (i !== 10 && j !== 10)) {
                var newId = "" + i + j;
                if (document.getElementById(newId).style.backgroundColor !== "") {
                    alert("Wrong location");
                    return false;
                }
            }
        }
    }
    id = "" + x + (y + 1);
    return checkLocation(size -1, id)
}

function printShips(size, id) {
    if (checkLocation(size, id)) {
        for (var i = 0; i < size; ++i) {
            var index = Number(id) + i;
            var x = Math.floor(index/10);
            var y = index%10;
            arr[x][y] = 1;
            var printId = (Number(id) + i);
            if (printId < 10) {
                printId = "0" + printId;
            }
            document.getElementById(printId).style.backgroundImage = "url('images/ship7.png')";
            document.getElementById(printId).style.backgroundSize = "cover";
            document.getElementById(printId).style.backgroundColor = "#1efcff";
            //document.getElementById(printId).setAttribute('class', 'printShips');
        }
        count(size);
        start+=1;
        checkStart();
    }
}

function checkStart() {
    if (start === 10) {
        document.getElementById('start1').style.visibility = 'visible';
    }
}
function count(size) {
    switch(size){
        case 1:
            ship1.count -= 1;
            ship1.checkCount(ship1);
            break;
        case 2:
            ship2.count -= 1;
            ship2.checkCount(ship2);
            break;
        case 3:
            ship3.count -= 1;
            ship3.checkCount(ship3);
            break;
        case 4:
            ship4.count -= 1;
            ship4.checkCount(ship4);
            break;
    }
}

function setElementId(tableId) {
    var row = document.getElementById(tableId).childNodes[0].childNodes[0].childElementCount;
    var column = document.getElementById(tableId).childNodes[0].childNodes[0].childNodes[0].childElementCount;
    for (var i = 0; i < row; ++i) {
        for (var j = 0; j < column; ++j) {
            document.getElementById(tableId).childNodes[0].childNodes[0].childNodes[i].childNodes[j].id = i + '' + j;
        }
    }
}

function Play() {
    for (var i = 0; i < 10; ++i) {
        for (var j = 0; j < 10; ++j) {
            document.getElementById('gamer_1').style.backgroundImage = "url('images/sea2.jpg')";
            document.getElementById('gamer_11').style.opacity = 1;
            document.getElementById(i + '' + j).style.backgroundImage = "url(images/harc.png";
            document.getElementById(i + '' + j).style.backgroundSize = "cover";
            document.getElementById(i + '' + j).style.backgroundColor = "#1efcff";
            //document.getElementById(i + '' + j).setAttribute('class', 'play');
        }
    }
    document.getElementById('start1').style.visibility = 'hidden';
}

var win = 0;

function findShips(td) {
    var idTD = td.id;
    var x = Math.floor(idTD/10);
    var y = idTD%10;
    if(document.getElementById('start1').style.visibility === 'hidden'){
        if(arr[x][y] ===  1){
            document.getElementById(x +''+ y).style.backgroundImage = "url('images/x.jpeg')";
            arr[x][y] = 2;
            win++;
        } else if(arr[x][y] ===  0){
            document.getElementById(x + '' + y).style.backgroundImage = "url('images/o1.png')";
            document.getElementById(x + '' + y).style.backgroundColor = "#ffffff";
        }
    }
    if (win === 20 ) {
        newGame();
        return 0;
    }
}

function newGame() {
    document.getElementById('start1').style.visibility = 'visible';
    document.getElementById('start1').innerHTML = "New Game";
    document.getElementById("forms").style.display = "none";
    document.getElementById("gamer_1").style.display = "none";
    document.getElementById('win').style.display = 'block';
    document.getElementById('start1').onclick = function() {
        location.reload();
    };
}
