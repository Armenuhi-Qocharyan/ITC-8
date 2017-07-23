/*
    npm install fs-finder
    npm install colors
                        RUN
    node user.js register username password email age
    node user.js login username password
    node user.js getUserInfo username
    node user.js getUsers
    node user.js resetPassword username email age newPassword
*/

var Finder = require('fs-finder');
var fs = require('fs');
var colors = require('colors/safe');
var allArgs = process.argv.slice(2);
var readMe = fs.readFileSync('users.txt','utf8');
var arrUsers = readMe.split('\n');

var register = function(myArgs) {
    for(var i=0; i <= myArgs.length; i++) {
        readMe = fs.readFileSync('users.txt','utf8');
        if (i == myArgs.length-1) {
            fs.writeFileSync('users.txt', readMe+myArgs[i]);
        } else {
            fs.writeFileSync('users.txt', readMe+myArgs[i]+',');
        }
    }
    fs.writeFileSync('users.txt', readMe+'\n');
    console.log(colors.green('\nREGISTERED\n'));
}

var login = function(myArgs) {
    var loginSuccess = false;
    for (var i=0; i < arrUsers.length; i++) {
        var oneUser = arrUsers[i].split(',');
        if (myArgs[0] === oneUser[0] && myArgs[1] === oneUser[1]) {
            loginSuccess = true;
        }
    } 
    if (loginSuccess == true) {
        console.log(colors.green('\nSuccessful Login\n'));
    } else {
        console.log(colors.red('\nLogin Failed\n'));
    }
}

var getUserInfo = function(myArgs) {
    var check = false;
    for (var i = 0; i < arrUsers.length; i++) {
        var oneUser = arrUsers[i].split(',');
        if (myArgs[0] === oneUser[0]) {
            console.log(colors.green('\nUsername : ',oneUser[0],'\nPassword : ', oneUser[1], '\nE-mail   : ', oneUser[2], '\nAge      : ', oneUser[3],'\n'));
            check = true
        }
    } 
    if (check == false) {
        console.log(colors.red("\nThere is no such user whose name is ", myArgs[0],'\n'));
    }
}

var getUsers = function() {
    var readMe = fs.readFileSync('users.txt','utf8');
    console.log(colors.yellow('\n\tList all users\n\n', readMe));
}

var updatePass = function(writeText) {
    fs.writeFileSync('users.txt',writeText[0] + '\n');
    for (var i = 1; i < writeText.length; i++) {
        var readMe = fs.readFileSync('users.txt','utf8');
        fs.writeFileSync('users.txt', readMe+writeText[i] + '\n');
    }

}

var resetPassword = function(myArgs) {
    var index = 0;
    var checkUser = false;
    for (var i=0; i < arrUsers.length; i++) {
        var oneUser = arrUsers[i].split(',');
        if (myArgs[0] === oneUser[0] && myArgs[1] === oneUser[2] && myArgs[2] === oneUser[3]) {
            checkUser = true;
            index = i;
        }
    } 
    if (checkUser == true) {
        arrUsers[index]=myArgs[0]+','+myArgs[3]+','+myArgs[1]+','+myArgs[2];
        updatePass(arrUsers);
        console.log(colors.green('\nPassword reseted\n'));
    } else {
        console.log(colors.red('\nNot find user\n'));
    }
}

var main = function() {
    if(allArgs[0] === 'register' && allArgs.length == 5) {
        var myArgs = allArgs.slice(1);
        register(myArgs);
    } else if (allArgs[0] === 'login' && allArgs.length == 3) {
        var myArgs = allArgs.slice(1);
        login(myArgs);
    } else if (allArgs[0] === 'getUserInfo' && allArgs.length == 2) {  
        var myArgs = allArgs.slice(1);
        getUserInfo(myArgs);
    } else if (allArgs[0] === 'getUsers' && allArgs.length == 1) {
        getUsers();
    } else if (allArgs[0] === 'resetPassword' && allArgs.length == 5) {
        var myArgs = allArgs.slice(1);
        resetPassword(myArgs);
    } else {
        console.log(colors.red("\nIncorrect Input\n"));
    }
}

main();
