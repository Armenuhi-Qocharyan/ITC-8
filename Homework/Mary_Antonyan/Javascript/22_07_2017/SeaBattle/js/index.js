var dragged;

function showOther() {
    var otherTable = document.getElementById("other");
    otherTable.style.width = '100%';

    var ownTable = document.getElementById("own");
    ownTable.style.width = '0';

    removeShips();
}

function showOwn() {
    var ownTable = document.getElementById("own");
    if (ownTable.style.width != '100%') {
        ownTable.style.width = '100%';

        var otherTable = document.getElementById("other");
        otherTable.style.width = '0';

        drawShips();
    }
}

function drawShips() { 
    var content = document.getElementById("content");
    for (var i = 0; i < 4; ++i) {
        var icon = document.createElement('span');
        icon.setAttribute("class", "fa fa-ship");
        icon.style.fontSize = '24px';
        icon.style.draggable = 'true';
        content.appendChild(icon);
        icon.addEventListener("drag", function(event) {
        }, false);

        icon.addEventListener("dragstart", function(event) {
            dragged = event.target;
            event.target.style.opacity = 0.5;
        }, false);

        icon.addEventListener("dragend", function(event) {
            event.target.style.opacity = "";
        }, false);

        icon.addEventListener("dragover", function(event) {
            event.preventDefault();
        }, false);

        icon.addEventListener("dragleave", function(event) {
            if (event.target.className == "cell dropzone") {
                event.target.style.background = "";
            }
        }, false);

        icon.addEventListener("drop", function(event) {
            event.preventDefault();
            if (event.target.className == "cell dropzone") {
                event.target.style.background = "";
                dragged.parentNode.removeChild(dragged);
                event.target.appendChild(dragged);
            }
        }, false);
    }
}

function removeShips() {
    for (var i = 0; i < 4; ++i) {
        content.removeChild(content.lastChild);
    }
}

function createTable() {
    var button = document.getElementById("button");
    button.style.display = 'none';
    var tables = document.getElementsByClassName("table");
    for (var i = 0, count = tables.length; i < count; ++i) {
        for (var j = 0; j < 10; ++j) {
            var row = tables[i].insertRow(j); 
            for (var k = 0; k < 10; ++k) {
                var cell = row.insertCell(k);
                cell.setAttribute("class", "cell");
                cell.className += " dropzone";
            }
        }
    }
    showOwn();    
}
