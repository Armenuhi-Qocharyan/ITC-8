function validator () {

    var username = document.getElementById("user").value;
    var password = document.getElementById("password").value;
    var repeat = document.getElementById("repeat").value;
    var email = document.getElementById("email").value;
    var checkEmail = validateEmail(email);
    var checkPassword = validatePassword(password);

    if (checkEmail == false) {
        document.getElementById("alertEmail").style.display="block";
    } else {
        document.getElementById("alertEmail").style.display="none";
    }

    if (checkPassword == false) {
        document.getElementById("alertPsw").style.display="block";
    } else {
        document.getElementById("alertPsw").style.display="none";
    }

    if (repeat != password) {
        document.getElementById("alertRepeat").style.display="block";
    } else {
        document.getElementById("alertRepeat").style.display="none";
    }

    if (username.length > 15) {
        document.getElementById("alertUname").style.display="block";
    } else {
        document.getElementById("alertUname").style.display="none";
    }

}


function validateEmail(email) {
    var regularExpression = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return regularExpression.test(email);
}

function validatePassword(password) {
    var regularExpression  = /^[a-zA-Z0-9!@#$%^&*]{6,16}$/;

    return regularExpression.test(password);
}
