var checkEmail = false,
    checkPsw = false,
    checkUname = false,
    checkRepeat = false;


function validator() {
    if (true == checkEmail && true == checkPsw && true == checkUname && true == checkRepeat) {
        document.getElementById("submit").disabled = false;
        name = document.getElementById('user').value;
        localStorage.setItem("name", name);
    }
}

function validateEmail(email) {
    var regularExpression = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    if ("" == email) {
        document.getElementById("alertEmail").style.display = "block";
        document.getElementById("alertEmail").innerHTML = "Please, fill out this field";
        document.getElementById("submit").disabled = true;
        checkEmail = false;
    } else if (!regularExpression.test(email)) {
        document.getElementById("alertEmail").style.display = "block";
        document.getElementById("alertEmail").innerHTML = "Invalid mail format";
        document.getElementById("submit").disabled = true;
        checkEmail = false;
    } else {
        document.getElementById("alertEmail").style.display = "none";
        checkEmail = true;
        validator();
    }
}

function validatePassword(password) {
    var regularExpression = /^(?=.*[0-9])(?=.*[a-z])[a-zA-Z0-9!@#$%^&*]{6,20}$/;
    if ("" == password) {
        document.getElementById("alertPsw").style.display = "block";
        document.getElementById("submit").disabled = true;
        document.getElementById("alertPsw").innerHTML = "Please, fill out this field";
    } else if (!regularExpression.test(password)) {
        document.getElementById("alertPsw").style.display = "block";
        document.getElementById("submit").disabled = true;
        document.getElementById("alertPsw").innerHTML = "Password should contain 6-20 symbols(required one lowercase letter and one number)";
        checkPsw = false;
    } else {
        document.getElementById("alertPsw").style.display = "none";
        checkPsw = true;
        validator();
    }
}

function validateRepeat(repeat) {
    var password = document.getElementById("password").value;
    if ("" == repeat) {
        document.getElementById("alertRepeat").style.display = "block";
        document.getElementById("submit").disabled = true;
        document.getElementById("alertRepeat").innerHTML = "Please, fill out this field";
    } else if (repeat != password) {
        document.getElementById("alertRepeat").style.display = "block";
        document.getElementById("submit").disabled = true;
        document.getElementById("alertRepeat").innerHTML = "Passwords doesn't match";
        checkRepeat = false;
    } else {
        document.getElementById("alertRepeat").style.display = "none";
        checkRepeat = true;
        validator();
    }
}

function validateUsername(username) {
    if ("" == username) {
        document.getElementById("alertUname").style.display = "block";
        document.getElementById("submit").disabled = true;
        document.getElementById("alertUname").innerHTML = "Please, fill out this field";
    } else if (username.length > 15 || username.indexOf(' ') != -1) {
        document.getElementById("alertUname").style.display = "block";
        document.getElementById("submit").disabled = true;
        document.getElementById("alertUname").innerHTML = "Username should not contain spaces and more than 15 symbols";
        checkUname = false;
    } else {
        document.getElementById("alertUname").style.display = "none";
        checkUname = true;
        validator();
    }
}
