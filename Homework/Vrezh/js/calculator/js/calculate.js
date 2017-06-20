var value = 0;
var act = "";

createNumberButtons(".", 4);
for(var i = 0; i <= 9; ++i) {
    createNumberButtons(i, 4);
}


function createNumberButtons(number, size) {
    var button = document.createElement('button');
    button.classList.add("number");

    button.classList.add("col-md-" + size) ;
    var node = document.createTextNode(number);
    button.appendChild(node);
    button.value = number;

    button.onclick = function () {
        numberClicked(button.value);
    }

    var content = document.getElementById('content');
    content.appendChild(button);
}

function numberClicked(number) {
    document.getElementById("val").value += number ;
    document.getElementById("val").focus();
}

function replace(selfID) {

    var valueObject = document.getElementById("val");
    value = Number(valueObject.value);
    valueObject.value = "";
    act = selfID;
}

function oneArgumentAction(item) {
    value = Number(document.getElementById("val").value)
        switch (item.getAttribute('id')) {
        case "sqrt" :value = Math.sqrt(value);
            break;
        case "abs" :value = Math.abs(value);
            break;
        case "log" :value = Math.log(value);
            break;
    }
    changeValue();
}

function equal() {
    var valueObject = document.getElementById("val");


            switch (act) {
                case "sum" :value += Number(valueObject.value);
                    break;
                case "sub" :value -= Number(valueObject.value);
                    break;
                case "mult" :value *= Number(valueObject.value);
                    break;
                case "dev" :value /= Number(valueObject.value);
                    break;
                case "sqrt" :value = Math.sqrt(value);
                    break;
                case "abs" :value = Math.abs(value);
                    break;
                case "pow" :value = Math.pow(value, Number(valueObject.value));
                    break;
                case "log" :value = Math.log(value);
                    break;
            }

    valueObject.value = "";
    changeValue();
}

function changeValue() {
    if (isNaN(value)) {
        document.getElementById("val").placeholder = "Pleas input correct numbers";
    } else {
        document.getElementById("val").value = value;
        document.getElementById("val").placeholder = "0";
    }
}




