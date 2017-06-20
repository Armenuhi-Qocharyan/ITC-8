var first = "free";
var second ="free";
var sign = "free";

function init () {
    var but = document.getElementById("but1");
    but.parentNode.removeChild(but);
    var operators = ["+", "-", "*", "/", "log", "C", "abs", "^", "sqrt", "="]; 
    var c = 0;
    for (var i = 0; i <= 8; ++i) {
        for (var j = i; j < i + 5; j++) {
            var button = document.createElement('button');
            button.setAttribute('value', j);
            button.innerHTML = j;
            document.getElementById("buttons").appendChild(button);
        }
        i += 4;
        var br = document.createElement('br');
        document.getElementById("buttons").appendChild(br);
    }

    for (i = 0; i < 2; ++i) {
        for (j = 0; j < 5; ++j) {
            var button = document.createElement('button');
            button.setAttribute('value', operators[c]);
            button.innerHTML = operators[c];
            document.getElementById("buttons").appendChild(button);
            c++;
        }
        var br = document.createElement('br');
        document.getElementById("buttons").appendChild(br);
    }
    document.querySelector('div').addEventListener('click', function(event) {
        if (event.target.tagName.toLowerCase() === 'button') {
            var value = event.target.getAttribute("value");
            if(isNaN(value)) {
                getOperator(value);
            } else {
                value = Number(value);
                getValue(value);
            }
        }
    });
}

function getValue(val) {
    if ("free" == first) {
        first = 0;
    }
    first = val + first * 10;
    document.getElementById("input").value = first;
}

function validation (operator) {
    result();
    if ("free" != second) {
        document.getElementById("input").value = second + operator;
    } else {
        document.getElementById("input").value = "";
    }

}


function getOperator(operator) {
    switch (operator) {
        case "C":
            first = "free";
            second = "free";
            document.getElementById("input").value = "input number";
            break;

        case "+":    
            validation (operator);
            if (second == "free") {
                second = 0;
            }
            if ("free" == first) {
                first = 0;
            }
            second += first;
            first = "free";
            sign = "+";
            break;

        case "-":
            validation (operator);
            if (first == "free") {
                first = 0;
            }
            if (second == "free") {
                second = first;
            } else {
                second -= first;
            }
            first = "free";
            sign = "-";
            break;

        case "/":
            validation (operator);

            if (first == "free") {
                first = 1;
            }
            if (second == "free") {
                second = first;
            } else {
                second /= first;
            }
            first = "free";
            sign = "/";
            break;

        case "*":
            validation (operator);
            if (first == "free") {
                first = 1;
            }
            if ("free" == second) {
                second = first;
            } else {
                second *= first;
            }
            first = "free";
            sign = "*";
            break;

        case "sqrt": 
            validation (operator);

            if ("free" == first) {
                first = 0;
            }
            second = Math.sqrt(second);
            sign = "sqrt";
            first = "free";
            break;
        case "^": 
            validation (operator);

            sign = "pow";
            first = "free";
            break;
        case "abs": 
            validation (operator);
            sign = "abs";
            first = "free";
            break;

        case "log": 
            validation (operator);
            sign = "log";
            first = "free";
            break;

        case "=":
            result();
            sign = "free";
            break;
    }
}

function result () { 
    switch (sign) {
        case "+":
            if ("free" != first) {
                second += first;
            }
            document.getElementById("input").value = second;
            first = "free";
            sign = "";
            break;
        case "-":
            if ("free" != first) {
                second -= first;
            }

            document.getElementById("input").value = second;
            first = "free";
            first = "free";
            sign = "";
            break;
        case "*":
            if ("free" != first) {
                second *= first;
            }
            document.getElementById("input").value = second;
            first = "free";
            sign = "";
            break;

        case "/":
            if ("free" != first) {
                second /= first;
            }
            document.getElementById("input").value = second;
            first = "free";
            sign = "";
            break;

        case "sqrt": 
            document.getElementById("input").value = second;
            sign = "";
            first = "free";
            break;

        case "pow":
            second = Math.pow(second, first);
            document.getElementById("input").value = second;
            sign = "";
            first = "free";
            break;
        case "abs":
            second = Math.abs(second);
            document.getElementById("input").value = second;
            sign = "";
            first = "free";
            break;

        case "log":
            second = Math.log(second);
            document.getElementById("input").value = second;
            sign = "";
            first = "free";
            break;

        case "free":
            second = first;
            first = "free";
            break;
    }
}
