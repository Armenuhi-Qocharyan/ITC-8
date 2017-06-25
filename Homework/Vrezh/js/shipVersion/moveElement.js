var startButton = document.getElementById('startButton');
var startImage = document.getElementById('startImage');
var replaceButton = document.getElementById('replace');
replaceButton.style.display = "none";

function startGame() {
    startButton.style.display = "none";
    startImage.style.display = "none";
    var shipArea = createShipArea();
    var workAre = workArea();

    function workArea() {
        this.table = document.createElement('table');
        this.table.id = "workArea";
        for (var i = 0; i < 10; ++i) {
            var tr = document.createElement("tr");
            for (var j = 0; j < 10; ++j) {
                var td = document.createElement("td");
                td.classList.add("square");
                var aText = document.createTextNode(" ");
                td.appendChild(aText);
                td.id = "sq";
                tr.appendChild(td);
            }
            this.table.style.float = "right";
            this.table.appendChild(tr);
            document.body.appendChild( this.table);
        }
    }

    function replaceArea() {
        for (var i = 0; i < 10; ++i) {
            for (var j = 0; j < 10; ++j) {
                document.getElementById('workArea').rows[i].cells[j].style.background = "grey";

            }
        }
    }

    function createShipArea() {
        var shipArea = document.createElement('div');
        shipArea.id = "shipArea";
        shipArea.style.float = "left";
        shipArea.style.background = "grey";
        document.body.appendChild(shipArea);
        shipArea.style.margin = "10px";
        shipArea.style.width = "300px";
        shipArea.style.height = screen.height / 2 + "px";
        return shipArea;
    }

    var shipItem = function (rotate) {
        this.ship = document.createElement('div');
        if (rotate) {
            this.ship.style.float = "left";
        }
        this.ship.style.background = "red";
        this.ship.id = "ship";
        this.ship.style.margin = "0px";
        this.ship.style.left = shipArea.style.left;
        this.ship.style.width = "40px";
        this.ship.style.height = "40px";
        this.ship.style.position = "absolute";
    }

    var shipDiv = function (number, rotate) {
        this.number = number;
        this.ship = document.createElement('div');
        this.ship.style.background = "red";
        this.rotate = rotate;
        this.items = [];
        if (this.rotate) {
            this.ship.style.width = this.number * 40 + "px";
            this.ship.style.height = "40px";
        } else {
            this.ship.style.width = "40px";
            this.ship.style.height = this.number * 40 + "px";
        }
        for (var i = 0; i < this.number; ++i) {
            this.items[i] = new shipItem(this.rotate);
            this.ship.appendChild(this.items[i].ship);
        }
        var ship1 = this;
        this.ship.onmousedown = function (e) {
            mouseDown(e, ship1.ship);
        }
        this.ship.ondragstart = function () {
            return false;
        };
        this.ship.ondblclick = function (e) {
            ship1.ship.style.display = "none";
            ship1 = new shipDiv(ship1.number, !ship1.rotate);
            shipArea.appendChild(ship1.ship);
        }
    }

    function mouseDown(e, ship) {
        var coords = ship.getBoundingClientRect();
        var shiftX = e.pageX - coords.left;
        var shiftY = e.pageY - coords.top;

        ship.style.position = 'absolute';
        moveAt(e);
        function moveAt(e) {
            ship.style.left = e.pageX - shiftX + 'px';
            ship.style.top = e.pageY - shiftY + 'px';
        }

        document.onmousemove = function (e) {
            moveAt(e);
            ship.style.display = "none";
            var elem1 = document.elementFromPoint(e.clientX, e.clientY);

            if (elem1 && elem1.id == 'sq') {
                ship.style.left = elem1.getBoundingClientRect().left + 'px';
                ship.style.top = elem1.getBoundingClientRect().top + 'px';
            }
            ship.style.display = "block";
        }
        ship.onmouseup = function (e) {
            document.onmousemove = null;
            ship.onmouseup = null;
            var bound = ship.getBoundingClientRect();
            ship.style.display = "none";
            var elem1 = document.elementFromPoint(e.clientX, e.clientY);

            if (elem1 && elem1.id == 'sq') {
                ship.style.left = elem1.getBoundingClientRect().left + 'px';
                ship.style.top = elem1.getBoundingClientRect().top + 'px';
                if (elementHov(e, bound)) {
                    shipArea.removeChild(ship);
                    if (shipArea.childNodes.length == 0) {
                        replaceButton.style.display = "block";
                        replaceButton.onclick = function () {
                            replaceArea()
                        }
                    }
                    return;
                }
            }
            ship.style.display = "block";
        }
    }

    function createShips() {
         for (var i = 1; i <= 4; ++i) {
             for (var j = 4; j > 0; j -= i) {
                 function create () {
                     var ship = new shipDiv(i, true);
                     shipArea.appendChild(ship.ship);
                 }
                 create();
             }
         }
     }
    createShips();
    document.onmouseup = function () {
        document.onmousemove = null;
    }

    function elementHov(e, bound) {
        var h = bound.height / 40;
        var w = bound.width / 40;
        var left = e.clientX - 39;
        var top = e.clientY - 39;
        var isCorrect = true;
        var counter = w > h ? w : h;
        for (var j = 0; j < counter; ++j) {
            var element;
            if (w > h) element = document.elementFromPoint(e.clientX + 40 * j, e.clientY);
            else element = document.elementFromPoint(e.clientX, e.clientY + 40 * j);

            if (element.id != 'sq') {
                isCorrect = false;
            }
        }
        if (isCorrect) {
            for (var i = 0; i < h + 2; ++i) {
                for (var j = 0; j < w + 2; ++j) {
                    var element = document.elementFromPoint(left + 40 * j, top + 40 * i);
                    if (element && element.id == 'sq') {
                        element.id = "sqr";
                        element.style.background = "green";
                    }
                }
            }
            for (var j = 0; j < counter; ++j) {
                function create() {
                    var element;
                    if (w > h) element = document.elementFromPoint(bound.left + 40 * j, bound.top);
                    else element = document.elementFromPoint(bound.left, bound.top + 40 * j);
                    var item = new shipItem(false);
                    element.style.background = "red";
                    element.id = "contain";
                    element.onmousedown = function () {
                        element.style.background = "red";
                    }
                }
                create();
            }
            return true;
        }
        return false;
    }
}


