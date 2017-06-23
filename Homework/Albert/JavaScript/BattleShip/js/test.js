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
//var ship = document.getElementsByName('myForms');

//var ship = document.getElementsByClassName('myForms');
ship.onmousedown = function (e) { // 1. отследить нажатие
    // подготовить к перемещению
    // 2. разместить на том же месте, но в абсолютных координатах
    ship.style.position = 'absolute';
    moveAt(e);
    // переместим в body, чтобы мяч был точно не внутри position:relative
    document.body.appendChild(ship);

    ship.style.zIndex = 1000; // показывать мяч над другими элементами

    // передвинуть мяч под координаты курсора
    // и сдвинуть на половину ширины/высоты для центрирования
    function moveAt(e) {
        ship.style.left = e.pageX - ship.offsetWidth / 2 + 'px';
        ship.style.top = e.pageY - ship.offsetHeight / 2 + 'px';
    }

    // 3, перемещать по экрану
    document.onmousemove = function (e) {
        moveAt(e);
    }

    // 4. отследить окончание переноса
    ship.onmouseup = function () {
        document.onmousemove = null;
        ship.onmouseup = null;
    }
}

ship.ondragstart = function () {
    return false;
};
/*
 $(document).ready(function(){
 for(var i = 0; i < 8; ++i){
 drag(i);
 }
 });
 */




//var drag = function(number)







/*
 function createForm(row,column) {
 var table = document.createElement('table');
 table.setAttribute('class', 'formClass');
 //formTable.setAttribute('id', "form_" + row + "_" + i++);
 //allForms.appendChild(formTable);

 for (var i = 0; i < row; ++i) {
 var tr = document.createElement('tr');
 //allForms.appendChild(formTr);
 for (var j = 0; j < column; ++j) {
 var td = document.createElement('td');
 //allForms.appendChild(formTd);
 tr.appendChild(td);
 }
 table.appendChild(tr);

 }
 allForms.appendChild()
 }

 ////////////////////////////////

 var createTable = function(row, column, idName) {
 var forma = "<table class='forma' cellpadding='10'>";
 for (var i = 0; i < row; ++i) {
 forma += "<tr>";
 for (var j = 0; j < column; j++) {
 forma += "<td>" + "</td>";
 }
 forma += "</tr>";
 }
 return forma;

 }

 ////////////////////////////////

 var createForm = function(row, column) {
 var forma = "<div class='myForms'>";
 forma += "<table cellpadding='10' id='ball'>";
 for (var i = 0; i < row; ++i) {
 forma += "<tr>";
 for (var j = 0; j < column; j++) {
 forma += "<td>" + "</td>";
 }
 forma += "</tr>";
 }
 forma += "</table>";
 forma += "</div>";
 return forma;
 }


 /////////////////////////////////////////////////


 */
/*
 var idName = ['form_4_1','form_3_1','form_3_2','form_2_1','form_2_2','form_2_3','form_1_1','form_1_2','form_1_3','form_1_4'];
 var index = 0;

 var createForm = function(row, column,formType) {
 var forma = "";
 if (formType == 'form') {
 forma = "<div id='idName[index]'' class='myForms'>";
 }
 forma += "<table cellpadding='10'>";
 for (var i = 0; i < row; ++i) {
 forma += "<tr>";
 for (var j = 0; j < column; j++) {
 forma += "<td>" + "</td>";
 }
 forma += "</tr>";
 }
 forma += "</table>";
 forma += "</div>";
 ++index;
 return forma;
 }

 /////////////////////

 var createForm = function (count) {
 var allForms = document.getElementById("forms");
 for (var i = 0; i < count; ++i) {
 var ship = document.createElement("div");
 ship.className = "ship";
 //ship.id = "ship_" + i++;
 allForms.appendChild(ship);
 }
 }
 document.getElementById('forms').innerHTML += createForm(2);

 ///////////////////

 var createArea = function() {
 var table = document.getElementById("gamer_1");
 for (var i = 0; i < 10; ++i) {
 var tr = document.createElement("tr");
 for (var j = 0; j < 10; ++j) {
 var td = document.createElement("td");
 td.classList = "square";
 var aText = document.createTextNode('aaaa');
 td.appendChild(aText);
 td.onmouseup = function () {
 console.log("1");
 }
 tr.appendChild(td);
 }
 table.appendChild(tr);
 }
 $(document).ready(function(){
 createArea();
 });

 }
 */