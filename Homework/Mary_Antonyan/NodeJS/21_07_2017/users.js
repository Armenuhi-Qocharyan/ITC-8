/* To run script correctly type the following:
 * node/nodejs users.js [command] [arguments]
 * 
 * Get the list of all users: 
 *      command   - getUsers 
 *      argumnents - none
 *
 * Get information about user:
 *      command   - getUserInfo 
 *      arguments - username
 *
 * To register:
 *      command   - register
 *      arguments - username password email age
 *
 * To login:
 *      command   - login
 *      arguments - username password
 *
 * To reset password:
 *      command   - resetPassword
 *      arguments - username password email age newPassword
 */

var process = require('process');
var file = require('fs');
var findInFile = require('find-in-files');

// Check arguments and decide which command will be executed
function checkArguments(args, fileName) {   
    var count = args.length;
    var command = args[0];
    if (count == 1 && command == "getUsers") {
        getUsers(fileName);
    } else if (count == 2 && command == "getUserInfo") {
        getUserInfo(fileName, args[1]);
    } else if (count == 3 && command == "login") {
        login(fileName, args[1], args[2]);
    } else if (count == 5 && command == "register") {
        register(fileName, args[1], args[2], args[3], args[4]);
    } else if (count == 6 && command == "resetPassword") {
        resetPassword(fileName, args[1], args[2], args[3], args[4], args[5]);
    } else { 
        console.log("Error: Unknown command or inadequate count of arguments");
    }
}

// Login
function login(fileName, username, password) {
    file.readFile(fileName, function(err, data) {
        if (err) {
            return console.log("Error: ", err.message);
        }
        var searchString = "\n" + username + " " + password + " ";
        if (data.indexOf(searchString) >= 0) {
            console.log("OK");
        } else {
            console.log("Error: Authentication failed");
        }
    });
}

// Register the user
function register(fileName, username, password, email, age) {
    var data = "\n" + username + " " + password + " " + email +  " " + age;
    file.appendFile(fileName, data, function(err) {
        if (err) {
            return console.log("Error: ", err.message, "\nNot registered");
        }
        console.log("Registered");
    });
}

// Reset Password
function resetPassword(fileName, username, password, email, age, newPassword) {
    var searchString = "\n" + username + " " + password + " " + email + " " + age + "\n";
    var replaceString = "\n" + username + " " + newPassword + " " + email + " " + age + "\n";
    var replace = require('replace-in-file');
    var options = {
        files: fileName,
        from: searchString,
        to: replaceString,
        allowEmptyPaths: false,
        encoding: 'utf8',
    };
    replace(options, function(err, changedFiles) {
        if (err) {
            return console.log("Error: ", err.message);
        }
        if (changedFiles.length != 0) {
            console.log("Password was successfully changed");
        } else {
            console.log("No matches where found");
        }
    });
}

// Get information about specified user
function getUserInfo(fileName, username) {
    var searchString = "\n" + username + " ";
    // TODO complete this function
    findInFile.find(searchString, '.', fileName)
        .then(function(results) {
            for (var result in results) {
                var res = results[result];
                console.log(res);
            }
        });
}


// Get the list of all registered users
function getUsers(fileName) {
    file.readFile(fileName, 'utf-8', function(err, data) {
        if (err) {
            return console.log("Error: ", err.message);
        }
        console.log(data);
    });
}

function main() {
    var args = process.argv.slice(2);
    var fileName = "./users.txt";
    checkArguments(args, fileName);
}

main();
