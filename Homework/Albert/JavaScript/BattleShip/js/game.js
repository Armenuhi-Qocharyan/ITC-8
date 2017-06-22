var idName = ['form_4_1','form_3_1','form_3_2','form_2_1','form_2_2','form_2_3','form_1_1','form_1_2','form_1_3','form_1_4'];
var index = 0;

var createForm = function(row, column,formType) {
    var forma = "";
    if (formType == 'form') {
        forma = "<div id='ship' class='myForms'>";
    }
    forma += "<table name='myForms' class = 'forma' cellpadding='10'>";
    for (var i = 0; i < row; ++i) {
        forma += "<tr onclick='rowClick(this)'>";
        for (var j = 0; j < column; j++) {
            forma += "<td onclick='columnClick(this)'>" + "</td>";
        }
        forma += "</tr>";
    }
    forma += "</table>";
    forma += "</div>";
    //++index;
    return forma;
}
document.getElementById('gamer_1').innerHTML = createForm(10,10, 'table');
document.getElementById('gamer_2').innerHTML = createForm(10,10, 'table');
document.getElementById('forms').innerHTML += createForm(4,1, 'form');
document.getElementById('forms').innerHTML += createForm(3,1, 'form');
document.getElementById('forms').innerHTML += createForm(3,1, 'form');
document.getElementById('forms').innerHTML += createForm(2,1, 'form');
document.getElementById('forms').innerHTML += createForm(2,1, 'form');
document.getElementById('forms').innerHTML += createForm(2,1, 'form');
document.getElementById('forms').innerHTML += createForm(1,1, 'form');
document.getElementById('forms').innerHTML += createForm(1,1, 'form');
document.getElementById('forms').innerHTML += createForm(1,1, 'form');
document.getElementById('forms').innerHTML += createForm(1,1, 'form');


var rowClick = function(table) {
    alert("Row index is: " + table.rowIndex);
}

var columnClick = function(table) {
    alert("Column index is: " + table.cellIndex);
}

var ship = document.getElementById('ship');
ship.onmousedown = function (e) {
    ship.style.position = 'absolute';
    moveAt(e);
    document.body.appendChild(ship);
    ship.style.zIndex = 1000;

    function moveAt(e) {
        ship.style.left = e.pageX - ship.offsetWidth / 2 + 'px';
        ship.style.top = e.pageY - ship.offsetHeight / 2 + 'px';
    }

    document.onmousemove = function (e) {
        moveAt(e);
    }

    ship.onmouseup = function () {
        document.onmousemove = null;
        ship.onmouseup = null;
    }
}

ship.ondragstart = function () {
    return false;
};
