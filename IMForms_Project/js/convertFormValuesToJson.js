var getFormValues = function () {
    var inputs = document.getElementsByClassName("inputs");
    var jsontext = "{";
    for (var i = 0, length = inputs.length; length > i; i++) {
        jsontext += '"' + inputs[i].name + '"' + ":" + '"' + inputs[i].value + '"' + ",";
    }
    jsontext += "}";
    alert(jsontext);
}

var submitBtn = document.getElementById("submit_btn");
submitBtn.addEventListener("click", getFormValues);