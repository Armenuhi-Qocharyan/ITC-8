
const ELEM_WIDTH = 40;
var replaceButton = document.getElementById('replaceButton');
var messageDiv = document.getElementById('absolute');
var shipPlace = shipArea(),
    warPlace = new warArea(),
    shipCount = 20,
    reg = /[0-9][0-9]$/;


replaceButton.style.display = "none";

function shipArea() {
    var area = document.createElement('div');
    area.className += "shipArea";
    document.body.appendChild(area);
    return area;
}

function warArea() {
    this.area = document.createElement('table');
    this.area.className = 'warArea';
    var tr,
        td;
    for (var i = 0; i < 10; ++i) {
        tr = document.createElement('tr');
        for (var j = 0; j < 10; ++j) {
            td = document.createElement('td');
            td.className += "warAreaItem";
            td.id = String(i) + String(j);
            tr.appendChild(td);
        }
        this.area.appendChild(tr);
    }
    document.body.appendChild(this.area);
}

function replaceWarArea () {
    replaceButton.style.display = "none";
    for (var i = 0; i < 10; ++i) {
        for (var j = 0; j < 10; ++j) {
            function create() {
                var cell = warPlace.area.rows[i].cells[j];
                cell.style.backgroundColor = "cadetblue";
                cell.onmousedown = function (mouse) {
                    if (cell.childNodes.length != 0) {
                        if (18 == --shipCount) {
                            messageDiv.style.display = "block";
                            messageDiv.style.height = screen.height;
                        }

                    } else {
                        cell.style.backgroundColor = "transparent";
                    }
                    cell.onmousedown == null;
                }
            }
            create();
        }
    }
}

function shipElement(rotate) {
    this.element = document.createElement('div');
    this.element.className = "shipElement";
    if (rotate) {
        this.element.style.float = "left";
    }
}

function ship(size, rotate) {
    this.size = size;
    this.rotate = rotate;
    this.ship = document.createElement('div');
    if (rotate) {
        this.ship.style.width = this.size * ELEM_WIDTH + "px";
        this.ship.style.height = ELEM_WIDTH + "px";
    } else {
        this.ship.style.width = ELEM_WIDTH + "px";
        this.ship.style.height = this.size * ELEM_WIDTH + "px";
        this.ship.style.float = "left";
    }
    var elem;
    for (var i = 0; i < this.size; ++i) {
        elem = new shipElement(rotate);
        this.ship.appendChild(elem.element);
    }

    var ship1 = this;
    this.ship.onmousedown = function (mouse) {
        mouseDown(mouse, ship1.ship, ship1);
    }
    this.ship.ondragstart = function () {
        return false;
    };
    this.ship.ondblclick = function (e) {
        shipPlace.removeChild(ship1.ship);
        ship1 = new ship(ship1.size, !ship1.rotate);
        shipPlace.appendChild(ship1.ship);
    }
}

function createShipArea() {
    var ships;
    for (var i = 1; i <= 4; i++) {
        for (var j = 4 - i; j >= 0 ; --j) {
            ships = new ship(i, false);
            shipPlace.appendChild(ships.ship);
        }
    }
}
createShipArea()

function mouseDown(mouse, ship, ship1) {
    var coords = ship.getBoundingClientRect();
    var shiftX = mouse.pageX - coords.left;
    var shiftY = mouse.pageY - coords.top;
    ship.style.position = 'absolute';
    moveAt(mouse);
    function moveAt(mouse) {
        ship.style.left = mouse.pageX  - shiftX + 'px';
        ship.style.top = mouse.pageY  - shiftY + 'px';
    }

    document.onmousemove = function (mouse) {
        moveAt(mouse);
        ship.style.display = "none";
        var elem1 = document.elementFromPoint(mouse.clientX, mouse.clientY);
        if (elem1 && elem1.id.match(reg)) {
            ship.style.left = elem1.getBoundingClientRect().left + 'px';
            ship.style.top = elem1.getBoundingClientRect().top + 'px';
        }
        ship.style.display = "block";
    };
    ship.onmouseup = function (mouse) {
        document.onmousemove = null;
        ship.style.display = "none";
        if (mouseUp(mouse, ship1)) {
            ship.style.display = "none";
        } else {
            ship.style.display = "block";
        }
    }
}

document.onmouseup = function () {
    document.onmousemove = null
};


function isFixed(ship, id) {
    if (id.match(reg)) {
        var nextRowId = !ship.rotate ? (Number(id[0]) + ship.size - 1) : Number(id[0]),
            nextCollId = !ship.rotate ? Number(id[1]) : (Number(id[1]) + ship.size - 1),
            nextId = String(nextRowId) + nextCollId,
            td = document.getElementById(nextId);
        if (!id.match(reg) || !td || (td && td.tagName != 'TD')) {
            return false;
        }
    } else return false;
    return true;
}

function  mouseUp(mouse, ship) {
    var element = document.elementFromPoint(mouse.clientX, mouse.clientY);
    if(isFixed(ship, element.id)){
        var row = ship.rotate ? (ship.size + 2) : 3,
            coll = ship.rotate ?  3: (ship.size + 2),
            rowId = Number(element.id[0]) - 1,
            collId = Number(element.id[1]) - 1,
            hoverElement,
            child;
        ship.ship.style.display = "block";
        for (var i = 0; i < row; ++i) {
            for (var j = 0; j < coll; ++j) {
                var hoverElement = document.getElementById(String(rowId + j) + String(collId + i));
                if (hoverElement && hoverElement.tagName == 'TD') {
                    hoverElement.id = "hover" + String(i) + j ;
                    hoverElement.style.background = "green";
                    var elem = document.elementFromPoint(hoverElement.getBoundingClientRect().left +2,hoverElement.getBoundingClientRect().top);
                    if (elem.className == "shipElement") {
                        child = new shipElement(false);
                        hoverElement.appendChild(child.element);
                    }
                }
            }
        }
        shipPlaceRemoveChild(ship.ship);
        return true;
    }
    return false;
}

function shipPlaceRemoveChild(ship) {
    shipPlace.removeChild(ship);
    if(shipPlace.childElementCount == 0) {
        shipPlace.style.display = "none";
        replaceButton.style.display = "block";
        warPlace.area.style.float = "none";
    }
}
function  reload() {
    location.reload();
}