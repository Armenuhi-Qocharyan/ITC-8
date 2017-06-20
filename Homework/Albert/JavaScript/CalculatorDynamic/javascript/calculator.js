function createRow(rowNumber,index) {
    for (var i = 0; i < index; i++) {
        var button = document.createElement('button');
        button.setAttribute('value', rowNumber[i]);
        button.setAttribute('class', 'myButtons');
        button.innerHTML = rowNumber[i];
        document.getElementById("calculator").appendChild(button);
    }
    var br = document.createElement('br');
    document.getElementById("calculator").appendChild(br);
}

function createButtons() {
    var but = document.getElementById("but1");
    but.parentNode.removeChild(but);
    var row1 = ["log", "pow", "sqrt", "mod", "C"];
    var row2 = [1,2,3,"+"];
    var row3 = [4,5,6,"-"];
    var row4 = [7,8,9,"*"];
    var row5 = [".",0,"=","/"];
    createRow(row1,5);
    createRow(row2,4);
    createRow(row3,4);
    createRow(row4,4);
    createRow(row5,4);
    document.getElementById('input').value = "";

    document.querySelector('div').addEventListener('click', function(event) {
        if (event.target.tagName.toLowerCase() === 'button') {
            var value = event.target.getAttribute("value");
            if (value === 'log' || value == 'pow' || value == 'sqrt' || value == 'mod') {
                otherAction(value);
            }  else if (value == 'C') {
                input_c();
            } else if (value == '=') {
                equal();
            } else {
                input_text(value);
            }
        }
    });
}

var answer=0;

function input_text(input_number) {
    document.getElementById('input').value += input_number;
}
function input_c() {
    document.getElementById('input').value = "";
}
function equal() {
    try {
        answer = eval(document.form.input.value);
        if (!isFinite(answer)){
            document.form.input.value = "";
            alert("Divided by 0!!!");
            return;
        }
        document.form.input.value = answer;
    } catch (error) {
        alert("Please input correct number!!!");
        document.form.input.value = "";
    }
}
function otherAction(action) {
    number = eval(document.form.input.value);
    if (document.form.input.value == "") {
        alert("Input number!!!");
        document.form.input.value = "";
        return;
    }
    switch(action) {
        case "pow":
            result = number * number;
            document.form.input.value = result;
            break;
        case "sqrt":
            if (number < 0) {
                alert("The number is negative!!!");
                document.form.input.value = "";
                break;
            }
            result=Math.sqrt(number);
            break;
        case "mod":
            result=Math.abs(number);
            break;
        case "log":
            if (number <= 0) {
                alert("Please input correct number, the number is negative!!!");
                document.form.input.value = "";
                break;
            }
            result=Math.log(number);
            break;
    }
    document.getElementById('input').value = result;
}
