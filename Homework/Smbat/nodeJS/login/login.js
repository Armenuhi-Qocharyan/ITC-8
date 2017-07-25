var process = require('process');
var fs = require('fs');
var findInFile = require('find-in-files');

var fileUsers = "users.txt";

function checkArgs(args, fileUsers) {
    var command = args[0];
    var argLength = args.length;
    console.log(command + '...');
    if (command == "login" && argLength == 3) {
        login(args[1], args[2]);
    } else if (command == "register" && argLength == 5) {
        register(args[1], args[2], args[3], args[4]);
    } else if (command == "changepassword" && argLength == 6) {
        changePassword(args[1], args[2], args[3], args[4], args[5]);
    } else if (command == "getuser" && argLength == 2) {
        getUser(args[1], args[2]);
    } else if (command == "allusers" && argLength == 1) {
        allUsers();
    } else {
        console.log("Invalid Arguments");
    }
}

//-----------Regster------------
function register(username, password, email, age) {
    var data = username + " " + password + " " + email + " " + age + "\n";
    fs.appendFile(fileUsers, data, function(err) {
        if (err) return console.log(err);
        console.log(data + "> fileUsers.txt");
    });
}

//-------------Login--------------
function login(username, password) {
    fs.readFile(fileUsers, function(err, data) {
        if (err) return console.log(err.message);
        var findeString = "\n" + username + " " + password + " ";
        if (data.indexOf(findeString) < 0) {
            console.log("InValid Username Password");
        } else {
            console.log("Success");
        }
    });
}

//--------------------------------Change Password--------------------------
function changePassword(username, password, email, age, newpass) {
    var searchString =  username + " " + password + " " + email + " " + age + "\n";
    var replaceString = username + " " + newpass + " " + email + " " + age + "\n";
    var replace = require('replace-in-file');
    var options = {
        files: fileUsers,
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
            console.log("Password changed");
        } else {
            console.log("User not found");
        }
    });

}

//----------------------------Get User--------------------
function getUser(username) {
    var user= username;

    var lineReader = require('readline').createInterface({
        input: fs.createReadStream(fileUsers)

    });

    lineReader.on('line', function (line) {
        var arr = line.split(" ");  
        if (arr[0] == username) {
            console.log('User Name : ' + arr[0] + ', Password : ' + arr[1] + ', email : ' + arr[2] + ', age : ' + arr[3]);
        }
    });
}

//---------------------------All Users--------------------
function allUsers() {
    var lineReader = require('readline').createInterface({
        input: fs.createReadStream(fileUsers)

    });

    lineReader.on('line', function (line) {
        var arr = line.split(" ");  
        console.log('User Name : ' + arr[0] + ', Password : ' + arr[1] + ', email : ' + arr[2] + ', age : ' + arr[3]);
    }); 
}


function main() {
    var args = process.argv.slice(2);
    checkArgs(args);
}

main();
