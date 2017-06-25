var checkEmail = false;
var checkPsw = false;
var checkUname = false;
var checkRepeat = false;


function validator () {
    if (true == checkEmail && true == checkPsw && true == checkUname && true == checkRepeat) {
        document.getElementById("submit").disabled=false;
	name = document.getElementById('user').value;
	localStorage.setItem("name",name);
    }   
}


function validateEmail(email) {
    var regularExpression = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if (!regularExpression.test(email)) {
        document.getElementById("alertEmail").style.display="block";
        document.getElementById("submit").disabled=true;
        checkEmail=false;
    } else {
        document.getElementById("alertEmail").style.display="none";
        checkEmail=true;
        validator();
    }
}

function validatePassword(password) {
    var regularExpression = /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9!@#$%^&*]{6,20}$/;
    if(!regularExpression.test(password)) {
        document.getElementById("alertPsw").style.display="block";
        document.getElementById("submit").disabled=true;
        checkPsw=false;
    } else {
        document.getElementById("alertPsw").style.display="none";
        checkPsw=true;
        validator();
    }
}

function validateRepeat (repeat) {
    var password = document.getElementById("password").value;
    if (repeat != password) {
        document.getElementById("alertRepeat").style.display="block";
        document.getElementById("submit").disabled=true;
        checkRepeat=false;
    } else {
        document.getElementById("alertRepeat").style.display="none";
        checkRepeat=true;
        validator();
    }
}

function validateUsername (username) {
    if (username.length > 15) {
        document.getElementById("alertUname").style.display="block";
        document.getElementById("submit").disabled=true;
        checkUname=false;
    } else {
        document.getElementById("alertUname").style.display="none";
        checkUname=true;
        validator();
    }
}

