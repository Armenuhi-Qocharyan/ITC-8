function calculator(firstNumber , secondNumber , operator) {
    var first = Number(firstNumber);
    var second = Number(secondNumber);
    var result = 0;
    switch(operator) {
        case '+':
            result = first + second;
            break;
        case '-':
            result = first - second;
            break;
        case '*':
            result = first * second;
            break;
        case '/':
            if (second !== 0) {
                result = first / second;
            } else {
                alert ("Divison 0 !!!");
                document.getElementById('result').disabled = true;
            }
            break;
    }
    document.getElementById('result').value = result;
    return String(result);
}
var input = "";
var firstNumber = "";
var secondNumber = "";
var operator = "";

function getInput(digit){
    //alert("f : " + firstNumber + " s : " + secondNumber + " o ; " + operator);
    if (isNaN(digit)) {
        if (digit === 'C') {
            document.getElementById('result').value = " ";
            firstNumber = "";
            secondNumber = "";
            operator = "";
        }else if (firstNumber === "") {
            document.getElementById('result').value += digit;
            if (digit !== "="){
                operator = digit;
            }
            firstNumber = input;
            input = "";
        } else if (secondNumber === "") {
            if (operator !== "" && input !== "") {
                secondNumber = input;
                firstNumber = calculator(firstNumber , secondNumber , operator);
                input = "";
                secondNumber = "";
                operator = "";
            }
            if (digit !== "="){
                operator = digit;
                document.getElementById('result').value += digit;
            }

        } else if (digit === '=') {
            if (firstNumber !== "" && secondNumber !== "" && operator !== "") {
                input = calculator(firstNumber , secondNumber , operator);
                operator = "";
                firstNumber = "";
                secondNumber = "";
            }else {
                document.getElementById('result').value += "";
            }
        }
    } else {
        if (operator === "" && firstNumber !== "") {
            firstNumber += digit;
        } else {
            input += digit;
        }
        document.getElementById('result').value += digit;
    }
}

function Sin() {
    number = Number(document.getElementById('result').value);
    result = Math.sin(number);
    firstNumber = result;
    document.getElementById('result').value = result;
}
function Cos() {
    number = Number(document.getElementById('result').value);
    result = Math.cos(number);
    firstNumber = result;
    document.getElementById('result').value = result;
}
function Ceil() {
    number = Number(document.getElementById('result').value);
    result = Math.ceil(number);
    firstNumber = result;
    document.getElementById('result').value = result;
}

function Abs() {
    number = Number(document.getElementById('result').value);
    result = Math.abs(number);
    firstNumber = result;
    document.getElementById('result').value = result;
}
function Log() {
    number = Number(document.getElementById('result').value);
    result = Math.log(number);
    firstNumber = result;
    document.getElementById('result').value = result;
}
function Sqrt() {
    number = Number(document.getElementById('result').value);
    result = Math.sqrt(number);
    firstNumber = result;
    document.getElementById('result').value = result;
}
function Exp() {
    number = Number(document.getElementById('result').value);
    result = Math.exp(number);
    firstNumber = result;
    document.getElementById('result').value = result;
}