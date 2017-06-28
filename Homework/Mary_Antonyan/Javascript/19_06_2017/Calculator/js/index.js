var keys = document.querySelectorAll(".button");
var dotPressed = false;
var operators = ["+", "-", "*", "/", "^", "&#8730", "log"];
var firstOperand = 0;
var secondOperand = 0;
var operation = "";

for (var i = 0, len = keys.length; i < len; ++i) {
    keys[i].onclick = function() {
        //Get input field value
        var input = document.getElementById("input");
        var inputValue = input.innerHTML;

        //Get button value
        var buttonValue = this.innerHTML;

        //Clear input field
        if (buttonValue == "C") {
            console.log("C pressed"); 
            input.innerHTML = "";
            dotPressed = false;
        } else if (buttonValue == "=") {
            console.log("= pressed");
            //Get result, show it in input field, empty operands and operation value
            input.innerHTML = getResult(firstOperand, secondOperand, operation);
            firstOperand = 0;
            secondOperand = 0;
            operation = "";
            dotPressed = false;
        } else if (operators.indexOf(buttonValue) > -1) {
            console.log("operation pressed");
            //If operation button is pressed
            if (!firstOperand) {
                //If first operand is empty
                firstOperand = inputValue;
                operation = buttonValue;
		input,innerHTML = "";
            } else {
                //If first operand is not empty and now is second operand's turn
                secondOperand = inputValue;
                input.innerHTML = getResult(firstOperand, secondOperand, operation);
                firstOperand = "";
                secondOPerand = "";
                operation = buttonValue;
            }
            dotPressed = false;
        } else if (buttonValue == ".") {
            console.log("dot pressed");
            //If pressed button is dot
            if (!dotPressed) {
                input.innerHTML += buttonValue;
                dotPressed = true;
            }
        } else {
            console.log("other key pressed");
            //If pressed button is number
            input.innerHTML += buttonValue;
        }
    }
}

function getResult(firstOperand, secondOperand, operation) {
    switch (operation) {
        case "+": {
            return firstOperand + secondOperand;
        }
        case "-": {
            return firstOperand - secondOperand;
        }
        case "*": {
            return firstOperand * secondOperand;
        }
        case "/": {
            return firstOperand / secondOperand;
        }
        case "^": {
            return Math.pow(firstOperand,secondOperand);
        }
        case "log": {
            return Math.log(firstOpernad) / Math.log(secondOperand);
        }
    }
}
