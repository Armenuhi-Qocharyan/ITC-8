
inputValue = "";

    function sendValue(val){
        inputValue += val;
        document.getElementById("input").value = inputValue;
    }

    function sendId(myId) {
        switch (myId) {
            case "butC":
                inputValue = "";
                document.getElementById("input").value = inputValue;
                break;
            case "but^":
                inputValue = "Math.pow("+inputValue+",";
                document.getElementById("input").value = inputValue;
                break;
            case "butSqrt":
                inputValue = "Math.sqrt("+inputValue+")";
                document.getElementById("input").value = inputValue;
                break;
            case "butLog":
                inputValue = "Math.log("+inputValue+")";
                document.getElementById("input").value = inputValue;
                break;
            case "but=":
                Answer();
                break;

        }
    }

    function Answer() {
        var output = eval(inputValue);
        inputValue = output;
        document.getElementById("input").value = output;
    }

operator=["+","-","/",".","0",")","*"]
inputValue = "";
function Func() {
    var cnt = 0;
    for (var i = 1; i < 22; ++i) {
        if(i < 10) {
            var mybutton = document.createElement("button");
            var t = document.createTextNode(i);
            mybutton.value = i;
            mybutton.style = "width: 50px; height: 40px; color: blue";
            mybutton.appendChild(t);
            document.getElementById("btnDiv").appendChild(mybutton);
            mybutton.onclick = function () {
                inputValue += this.value;
                document.getElementById("input").value = inputValue;
                return false;
            };
        }

        if((i%3) == 0) {
            var mybutton = document.createElement("button");
            var t = document.createTextNode(operator[cnt]);
            mybutton.value = operator[cnt];
            mybutton.style = "width: 50px; height: 40px; color: blue";
            mybutton.appendChild(t);
            document.getElementById("btnDiv").appendChild(mybutton);
            mybutton.onclick = function () {
                inputValue += this.value;
                document.getElementById("input").value = inputValue;
                return false;
            };
            cnt++;
        }
    }
}








