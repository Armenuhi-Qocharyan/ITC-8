var Finder = require('fs-finder');
var fs = require('fs');
var colors = require('colors/safe');
var replace = require("replace");
var allArgs = process.argv.slice(2);
var fd = fs.openSync("users.txt", 'a');
/*
var search = function(username, password) {
    var search = username + "," + password + ",";
    fs.readFile("users.txt", function(err, data) {
        if (err) throw err;
        if (data.indexOf(search) >= 0) {
            return true;
        }
        return false;
    });
}
*/
var register = function(myArgs) {
    var length = myArgs.length;
    var userInfo = "";
    for (var i = 0; i < length - 1; ++i) {
        userInfo += myArgs[i] + ",";
    }
    userInfo += myArgs[length - 1] + "\n";
    fs.readFile("users.txt", function(err, data) {
        if (err) throw err;
        if (data.indexOf(userInfo) >= 0) {
            console.log(colors.red.bold('\nRegister Failed\n'));
        } else {
            fs.appendFile('users.txt', userInfo, function(err) {
                if (err) throw err;
                console.log(colors.green('\nREGISTERED\n'));
            });
        }
    });
}

var login = function(myArgs) {
    var search = myArgs[0] + "," + myArgs[1] + ",";
    fs.readFile("users.txt", function(err, data) {
        if (err) throw err;
        if (data.indexOf(search) >= 0) {
            console.log(colors.green.bold('\nSuccessful Login\n'));
        } else {
            console.log(colors.red.bold('\nLogin Failed\n'));
        }
    });
}

var getUserInfo = function(myArgs) {
    var search = myArgs[0] + ",";
    fs.readFile("users.txt", "utf8", function(err, data) {
        if (err) throw err;
        if (data.indexOf(search) >= 0) {
            console.log(data);
        } else {
            console.log(colors.red.bold('\nLogin Failed\n'));
        }
    });
}

var getUsers = function() {
    var fileContent = fs.readFileSync('users.txt', 'utf8');
    console.log(colors.yellow('\n\tList all users\n\n', fileContent));
}

var updatePass = function(myArgs) {
    var search = myArgs[0] + "," + myArgs[1] + ",";
    fs.readFile("users.txt", function(err, data) {
        if (err) throw err;
        if (data.indexOf(search) >= 0) {
            replace({
                regex: myArgs[0] + "," + myArgs[1],
                replacement: myArgs[0] + "," + myArgs[2],
                paths: ['users.txt'],
                recursive: true,
                silent: true,
            });
            console.log(colors.red.bold('\nPassword updated\n'));
        } else {
            console.log(colors.green('\nNo users\n'));
        }
    });
}


var main = function() {
    var command = allArgs[0];
    var argsLength = allArgs.length;
    switch (command) {
        case 'register':
            if (allArgs.length == 5) {
                var myArgs = allArgs.slice(1);
                register(myArgs);
                break;
            }
            console.log("error");
            break;
        case 'login':
            if (allArgs.length == 3) {
                var myArgs = allArgs.slice(1);
                login(myArgs);
                break;
            }
            console.log("error");
            break;
        case 'updatePass':
            if (allArgs.length == 4) {
                var myArgs = allArgs.slice(1);
                updatePass(myArgs);
                break;
            }
            console.log("error");
            break;

        case 'getUserInfo':
            if (allArgs.length == 2) {
                var myArgs = allArgs.slice(1);
                getUserInfo(myArgs);
                break;
            }
            console.log("error");
            break;
        case 'getUsers':
            if (allArgs.length == 1) {
                var myArgs = allArgs.slice(1);
                getUsers(myArgs);
                break;
            }
            console.log("error");
            break;
    }
}

main();