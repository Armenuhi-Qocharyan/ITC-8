function input_text(input_number) {
    document.getElementById('input').value += input_number;
}
function input_c() {
    document.getElementById('input').value = "";
}
var first=0;
var second=0;
var operator="";
var index=0;

function operators(oper) {
    if (index === 0) {
        first = Number(document.getElementById('input').value);
    }
    operator=oper;
    document.getElementById('input').value = "";
    index+=1;
}

function equal() {
    second = Number(document.getElementById('input').value);
    var result=0;
    if ((isNaN(first)) || (isNaN(second)))  {
        alert("Please input only number!");
        document.getElementById('input').value = "";
        return;
    }
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
                alert ("Divided by 0 !!!");
                document.getElementById('input').value = "";
            }
            break;
        case "pow":
            result=first*first;
            break;
        case "sqrt":
            if (first < 0) {
                alert("Negative number!");
                document.getElementById('input').value = "";
                break;
            }
            result=Math.sqrt(first);
            break;
        case "modul":
            result=Math.abs(first);
            break;
        case "log":
            if (first <= 0) {
                alert("The number must be greater than 0!!!");
                document.getElementById('input').value = " ";
                break;
            }
            result=Math.log(first);
            break;
    }
    document.getElementById('input').value = result;
    index=0;
}
