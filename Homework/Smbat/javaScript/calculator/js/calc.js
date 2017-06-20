/**
 * Created by smbat on 6/19/17.
 */

var calcScreen = document.getElementById("screen");

var currentAction = "";
var var1 = 0;
var var2 = 0;
var nextNumFlag = false;
var tasnordakanGorcakic = 1;

var inputNum = function(thisBtn) {
    if (nextNumFlag) {
        calcScreen.value = 0;
        nextNumFlag = false;
    }
    if (thisBtn.value == "." && tasnordakanGorcakic == 1) {
        tasnordakanGorcakic = 0.1;
    }
    else if (calcScreen.value == 0) {
        calcScreen.value = thisBtn.value;
    } else {
        if (tasnordakanGorcakic == 1) {
            calcScreen.value = calcScreen.value * 10 + thisBtn.value * 1;
        } else {
            calcScreen.value = calcScreen.value * 1 + ( thisBtn.value * tasnordakanGorcakic );
            tasnordakanGorcakic = tasnordakanGorcakic / 10;
        }
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
