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
    var icon = document.createElement('div');
    icon.setAttribute("class", "fa fa-ship");
    icon.style.fontSize = '8px';
    icon.style.draggable = 'true';
    content.insertBefore(icon, content.children[3]);
}

function removeShips() {
    var ships = document.getElementsByClassName("fa fa-ship");
    for (var i = 0, len = ships.length; i < len; ++i) {
        ships[i].remove();
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
//                cell.setAttribute("id", "cell" + j + k);
            }
        }
    }
    showOwn();    
}

function dragStart(ev) {
    ev.dataTransfer.effectAllowed='move';
    ev.dataTransfer.setData("Text", ev.target.getAttribute('id'));   
    ev.dataTransfer.setDragImage(ev.target,100,100);
    return true;
}

function dragEnter(ev) {
    event.preventDefault();
    return true;
}

function dragOver(ev) {
    event.preventDefault();
}

function dragDrop(ev) {
    var data = ev.dataTransfer.getData("Text");
    ev.target.appendChild(document.getElementById(data));
    ev.stopPropagation();
    return false;
}


