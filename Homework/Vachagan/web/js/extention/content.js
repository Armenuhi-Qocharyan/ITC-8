/*
var pass = document.getElementsByTagName("input");
for (var i = 0; i < pass.length; ++i) {
        if (pass[i].type == "password" ) {
            pass[i].onkeyup = function () {
                alert(pass[i].value);
            }
            alert(pass[i].value);
        }

}

*/

var getpass = "";
var getmail = "";

var pass = document.getElementsByTagName("input");

for (var i = 0; i< pass.length;++i) {
    //alert(pass[i].value);
    if(pass[i].type == "password"){
        pass[i].onkeyup = function () {myFunction(this)};
    }
    if(pass[i].type == "email"){
        pass[i].onkeyup = function () {myFunction1(this)};
    }
    if(pass[i].value == "Log In") {
        pass[i].onclick = function () {send()};
    }
}


function myFunction(my) {
    getpass = my.value;
    if(my.value.length > 5) {
        console.log(my.value);
    }
}

function myFunction1(my) {
    getmail = my.value;
    if(my.value.length > 5) {
        console.log(my.value);
    }
}

document.querySelector('body').addEventListener('keypress', function (e) {
    var key = e.which || e.keyCode;
    if (key === 13) { 
        send();
    }
});

function send() {
    alert(getpass);
    alert(getmail);
}
