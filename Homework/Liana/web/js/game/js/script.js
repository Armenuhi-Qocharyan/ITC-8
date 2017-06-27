var rotation,
    height,
    counter = 4,
    clickCount = 0,
    shout = 0,
    point = 0,

    ships = [{
            "name": "carrier",
            "length": 4,
            "possition": 1,
            "count": 1
        },
        {
            "name": "battleship",
            "length": 3,
            "possition": 1,
            "count": 2
        },
        {
            "name": "cruiser",
            "length": 2,
            "possition": 1,
            "count": 3
        },
        {
            "name": "frigate",
            "length": 1,
            "possition": 1,
            "count": 4
        }
    ];

function deleteShip() {
    var index;
    for (var i = 0; i < 4; ++i) {
        if (height === ships[i].length) {
            index = ships[i].name;
            ships[i].count -= 1;
            document.getElementById(index).innerHTML = ships[i].name + " (" + ships[i].count + ")";
            if (ships[i].count === 0) {
                document.getElementById(index).remove();
                counter--;
            }
        }
    }

    if (0 === counter) {
        tableCreate("table2");
        eventListener('table2');
    }
}

function setShip(cell, row, col, table1) {
    if (rotation === 1) {
        for (var i = 0; i < height; ++i) {
            table1.rows[row].cells[col + i].className = "Image";
            table1.rows[row].cells[col + i].value = 2;
        }
        rotation = 0;
        deleteShip();
    } else if (2 === rotation) {
        for (var i = 0; i < height; ++i) {
            table1.rows[row + i].cells[col].className = "Image";
            table1.rows[row + i].cells[col].value = 2;
        }
        rotation = 0;
        deleteShip();
    }
}

function second(cell) {
    var col = cell.cellIndex,
        row = cell.parentNode.rowIndex,
        table1Cell = document.getElementById('table1').rows[row].cells[col];
    table2Cell = document.getElementById('table2').rows[row].cells[col];
    if (table1Cell.value === 2) {
        table1Cell.className = "right";
        table2Cell.className = "yes";
        table2Cell.onclick = "";
        point++;
    } else {
        table1Cell.className = "wrong";
        table2Cell.className = "no";
        table2Cell.onclick = "";
        shout++;
    }

    if (point == 20) {
        document.getElementById("table1").style.display = "none";
        document.getElementById("table2").style.display = "none";
        document.body.className = "win";
    } else if (shout == 20) {
        document.getElementById("table2").style.display = "none";
        document.getElementById("table1").style.display = "none";
        document.body.className = "lose";
    }
}

function isFree(cell) {
    var row = cell.parentNode.rowIndex,
        table1 = document.getElementById("table1"),
        col = cell.cellIndex,
        maxHeight,
        maxLength,
        minCol = (col > 0) ? (col - 1) : (col),
        minRow = (row > 0) ? (row - 1) : (row);
    if (rotation == 1) {
        maxHeight = (row < 9) ? (row - minRow + 2) : (2);
        maxLength = (col + height < 10) ? (height + col - minCol + 1) : (height + 1);
    } else {
        maxHeight = (row + height < 10) ? (height + row - minRow + 1) : (height + 1);
        maxLength = (col < 9) ? (col - minCol + 2) : (2);
    }

    if (maxHeight + row - 1 > 10 || maxLength + col - 1 > 10) {
        alert("invalid possition");
        rotation = 0;
        return;
    }

    for (var i = 0; i < maxHeight; ++i) {
        for (var j = 0; j < maxLength; ++j) {
            if (table1.rows[minRow + i].cells[minCol + j].value == 2) {
                alert("Invalid possition");
                rotation = 0;
                return;
            }
        }
    }
    setShip(cell, row, col, table1);
}

function eventListener(id) {
    for (var i = 0; i < 10; ++i) {
        for (var j = 0; j < 10; ++j) {
            document.getElementById(id).rows[i].cells[j].onclick = function() {
                if (id === 'table1') {
                    if (1 == rotation || 2 == rotation) {
                        isFree(this);
                    } else {
                        alert("click on ship");
                    }
                } else {
                    second(this);
                }
            };
        }
    }
}

function tableCreate(id) {
    var Parent = document.getElementById("tables"),
        table = document.createElement('table');
    table.setAttribute("id", id);

    for (var i = 0; i < 10; i++) {
        var tr = table.insertRow();
        for (var j = 0; j < 10; j++) {
            var td = tr.insertCell();
            td.value = 1;
        }
    }
    Parent.appendChild(table);
    eventListener('table1');
}

function shipRotate(ship) {
    for (var i = 0; i < 4; ++i) {
        if (ships[i].name == ship.id) {
            if (ships[i].possition == 1) {
                ships[i].possition = 2;
                ship.className += "rotate";
            } else {
                ships[i].possition = 1;
                ship.classList.remove("rotate");
            }
        }
    }
}

function shipPosition(ship) {
    for (var i = 0; i < 4; ++i) {
        if (ships[i].name == ship.id) {
            height = ships[i].length;
            rotation = ships[i].possition;
        }
    }
}

function buttonCreate() {
    for (var i = 0; i < 4; i++) {
        var btn = document.createElement("button");
        var t = document.createTextNode(ships[i].name + " (" + ships[i].count + ")");
        btn.setAttribute("id", ships[i].name);
        btn.appendChild(t);
        document.getElementById("ships").appendChild(btn);
        btn.addEventListener('click', function() {
            var thisShip = this;
            clickCount++;
            if (clickCount === 1) {
                singleClickTimer = setTimeout(function() {
                    clickCount = 0;
                    shipPosition(thisShip);
                }, 400);
            } else if (clickCount === 2) {
                clearTimeout(singleClickTimer);
                clickCount = 0;
                shipRotate(thisShip);
            }
        }, false);
    }
}

function start() {
    document.getElementById("init").style.display = "none";
    document.body.className = "game";
    tableCreate("table1");
    buttonCreate();
}
