var rotation,
    height,
    counter = 4,
    clickCount = 0;
var ships = [{
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
            if (ships[i].count === 0) {
                document.getElementById(index).remove();
                counter--;
            }
        }

    }

    if (0 === counter) {
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

function validCell(cell) {
    var col = cell.cellIndex;
    var row = cell.parentNode.rowIndex;
    var temp,
        isValid = true;
    var table1 = document.getElementById("table1");
    if ((row + height) > 10) {
        isValid = false;
        return;
    }

    for (var i = 0; i < height; ++i) {
        if (0 === row) {
            temp = row + i;
        } else {
            temp = row + i - 1;
        }

        if (table1.rows[temp].cells[col].value === 2) {
            isValid = false;
            break;
        }
        if (col < 9) {
            if (table1.rows[temp].cells[col + 1].value === 2) {
                isValid = false;
                break;
            }
        }

        if (col > 0) {
            if (table1.rows[temp].cells[col - 1].value === 2) {
                isValid = false;
                break;
            }
        }

    }
    if ((row + height) < 10) {
        if (table1.rows[row + height].cells[col].value === 2) {
            isValid = false;
        }

        if (col < 9) {
            if (table1.rows[row + height].cells[col + 1].value === 2) {
                isValid = false;
            }
        }

        if (col > 0) {
            if (table1.rows[row + height].cells[col - 1].value === 2) {
                isValid = false;
            }
        }

    }
    if (col > 0) {
        if (table1.rows[row].cells[col - 1].value === 2) {
            isValid = false;
        }
    }



    if (isValid) {
        setShip(cell, row, col, table1);
    }
}


function validCellRow(cell) {
    var col = cell.cellIndex;
    var row = cell.parentNode.rowIndex;
    var temp,
        isValid = true;
    var table1 = document.getElementById('table1');

    if ((col + height) > 10) {
        isValid = false;
        return;
    }

    for (var i = 0; i <= height; ++i) {
        temp1 = col + i;

        if (temp1 < 10) {
            if (table1.rows[row].cells[temp1].value === 2) {
                isValid = false;
                break;
            }
            if (row < 9) {
                if (table1.rows[row + 1].cells[temp1].value === 2) {
                    isValid = false;
                    break;
                }
            }

            if (row > 0) {

                if (table1.rows[row - 1].cells[temp1].value === 2) {
                    isValid = false;
                    break;
                }
            }
        }
    }

    if (row < 9 && col > 0) {
        if (table1.rows[row + 1].cells[col - 1].value === 2) {
            isValid = false;
        }
    }


    if (col > 0) {
        if (table1.rows[row].cells[col - 1].value === 2) {
            isValid = false;
        }

    }


    if (row > 0 && col > 0) {
        if (table1.rows[row - 1].cells[col - 1].value === 2) {
            isValid = false;
        }
    }

    if (isValid) {
        setShip(cell, row, col, table1)
    }

}


function second(cell) {
    var col = cell.cellIndex,
        row = cell.parentNode.rowIndex;
    table1Cell = document.getElementById('table1').rows[row].cells[col];
    if (table1Cell.value === 2) {
        table1Cell.className = "right";
    } else {
        table1Cell.className = "wrong";
    }
}


function eventListener(id) {

    for (var i = 0; i < 10; ++i) {
        for (var j = 0; j < 10; ++j) {
            document.getElementById(id).rows[i].cells[j].onclick = function() {
                if (id === 'table1') {
                    if (1 == rotation) {
                        validCellRow(this);
                    } else if (2 == rotation) {
                        validCell(this);
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
    var Parent = document.getElementById("tables");
    table = document.createElement('table');
    table.setAttribute("id", id);

    for (var i = 0; i < 10; i++) {
        var tr = table.insertRow();
        for (var j = 0; j < 10; j++) {
            var td = tr.insertCell();
            td.appendChild(document.createTextNode(""));
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
        var t = document.createTextNode(ships[i].name);
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
                shipRotate(this);
            }
        }, false);
    }
}

function start() {
    document.getElementById("init").style.display = "none";
    document.body.style.background = "#9de7f9";
    tableCreate("table1");
    tableCreate("table2");
    buttonCreate();
}