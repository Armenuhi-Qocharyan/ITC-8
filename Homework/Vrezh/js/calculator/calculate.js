var value = 0;
function replace(selfID) {
    var valueObject = document.getElementById("val");
    value = Number(valueObject.value);
    valueObject.value = "";
    if (value != 0) {
        document.getElementById(selfID).disabled = true;
    }
    if (selfID == "sqrt" || selfID == "abs" || selfID == "log") {
        equa();
    }
}

function equa() {
    var valueObject = document.getElementById("val");
    var action = document.getElementsByName('act');
    action.forEach(function (item, i, arr) {
        if(item.disabled == true) {
            item.disabled = false;
            switch (item.getAttribute('id')) {
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
        }
    });

    valueObject.value = "";
    if (isNaN(value)) {
        document.getElementById("val").placeholder = "Pleas input correct numbers";
    } else {
        document.getElementById("val").placeholder = value;
    }
}




