first = 0;
second = 0;
output = 0;
operator = "";
inputValue = "";

    function sendValue(val){
        inputValue += val;
        first = parseFloat(inputValue);
        document.getElementById("input").value = first;
    }

    function sendId(myId) {
        switch (myId) {
            case "butC":
                first = 0;
                second = 0;
                inputValue = "";
                document.getElementById("input").value = first;
                break;
            case "but+":
                second = first;
                inputValue = "";
                operator = "+";
                document.getElementById("input").value = operator;
                break;
            case "but-":
                second = first;
                inputValue = "";
                operator = "-";
                document.getElementById("input").value = operator;
                break;
            case "but/":
                second = first;
                inputValue = "";
                operator = "/";
                document.getElementById("input").value = operator;
                break;
            case "but*":
                second = first;
                inputValue = "";
                operator = "*";
                document.getElementById("input").value = operator;
                break;
            case "but^":
                second = first;
                inputValue = "";
                operator = "^";
                document.getElementById("input").value = operator;
                break;
            case "butSqrt":
                output = Math.sqrt(first);
                first = output;
                inputValue = "";
                document.getElementById("input").value = output;
                break;
            case "butLog":
                output = Math.log(first);
                first = output;
                inputValue = "";
                document.getElementById("input").value = output;
                break;
            case "but=":
                inputValue = "";
                Answer();
                break;
        }
    }
function Answer() {
        switch (operator) {
            case "+":
                output = second + first;
                first = output;
                second = 0;
                document.getElementById("input").value = output;
                break;
            case "-": {
                output = second - first;
                first = output;
                second = 0;
                document.getElementById("input").value = output;
                break;
            }
            case "/": {
                output = second / first;
                first = output;
                second = 0;
                document.getElementById("input").value = output;
                break;
            }
            case "*": {
                output = second * first;
                first = output;
                second = 0
                document.getElementById("input").value = output;
                break;
            }
            case "^": {
                output = Math.pow(second,first);
                first = output;
                second = 0;
                document.getElementById("input").value = output;
                break;
            }
        }
}





