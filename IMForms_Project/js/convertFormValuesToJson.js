ElementArray =[];

var getFormValues = function () {
    var inputs = document.getElementsByClassName("inputs");
    myJson = {};
    for (var i = 0, length = inputs.length; length > i; i++) {
        myJson[inputs[i].name] = inputs[i].value;
    }
    console.log(myJson);
    alert(myJson.firstname);
}

function print() {
    var drop = document.getElementById("dropArea");
    alert(drop.childElementCount);
    for(var i = 1;i <= drop.childElementCount ;++i) {
        //console.log(drop.childNodes[i].name);
        ElementArray[i] = drop.childNodes[i].name;
    }
}

var submitBtn = document.getElementById("submit_btn");
submitBtn.addEventListener("click", getFormValues);
submitBtn.addEventListener("click", print);

