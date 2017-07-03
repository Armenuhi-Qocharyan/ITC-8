var getFormValues = function () {
    var inputs = document.getElementsByClassName("inputs");
    myJson = {};
    for (var i = 0, length = inputs.length; length > i; i++) {
        myJson[inputs[i].name] = inputs[i].value;
    }
    console.log(myJson);
    alert(myJson.firstname);
};

var submitBtn = document.getElementById("submit_btn");
submitBtn.addEventListener("click", getFormValues);

