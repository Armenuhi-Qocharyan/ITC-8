/**
 * Created by smbat on 6/19/17.
 */

var calcScreen = document.getElementById("screen");

var currentAction = "";
var var1 = 0;
var nextNumFlag = false;
var tasnordakanFlag = false;

var inputNum = function(thisBtn) {
    if (nextNumFlag) {
        calcScreen.value = "0";
        tasnordakanFlag = false;
        nextNumFlag = false;
    }
    if (thisBtn.value == ".") {
        if (!tasnordakanFlag) {
            tasnordakanFlag = true;
            calcScreen.value = calcScreen.value + thisBtn.value;
        }
        return;
    }
    else if (calcScreen.value == "0") {
        calcScreen.value = thisBtn.value;
    } else {
	calcScreen.value = calcScreen.value + thisBtn.value;
    }
}

var btnaction = function(thisBtn) {
    switch (currentAction) {
        case "":
        case "=":
            var1 = calcScreen.value * 1;
            break;
        case "+":
            var1 = var1 + calcScreen.value * 1;
            calcScreen.value = var1;
            break;
        case "-":
            var1 = var1 - (calcScreen.value * 1);
            calcScreen.value = var1;
            break;
        case "*":
            var1 = var1 * (calcScreen.value * 1);
            calcScreen.value = var1;
            break;
        case "/":
            if (calcScreen.value == 0) {
                var1 = 0;
                break;
            }
            var1 = var1 / (calcScreen.value * 1);
            calcScreen.value = var1;
            break;


    }
    switch (thisBtn.value) {
        case "sqrt":
            if (calcScreen.value < 0) {
                var1 = 0;
                calcScreen.value = 0;
                break;
            }
            calcScreen.value = Math.sqrt(var1);
            return;
        case "del":
            calcScreen.value = 0;
            var1 = 0;
            return;
        case "abs":
            if (calcScreen.value < 0) {
                calcScreen.value = -1 * calcScreen.value;
            }
            return;
        case "log":
                calcScreen.value = Math.log(calcScreen.value);
            return;
    }
    currentAction = thisBtn.value;
    nextNumFlag = true;
    tasnordakanGorcakic = 1;

}
