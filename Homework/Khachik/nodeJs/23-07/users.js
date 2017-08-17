#!/usr/bin/env node

var fs = require('fs'),
    ArgumentParser = require('argparse').ArgumentParser,
    LineByLineReader = require('line-by-line'),
    glob = require("glob"),
    replace = require("replace");
lr = new LineByLineReader('file.txt');

parser = new ArgumentParser({
    version: '0.0.1',
       addHelp:true,
       description: 'Argparser for app',
}),
subparsers = parser.addSubparsers({
    title:'subcommands',
    dest:"command"
});

var bar = subparsers.addParser('register', {addHelp:true});
bar.addArgument(
    [ '-u', '--username' ],
    {
        action: 'store',
        help: 'Enter username',
        dest: 'username',
        required: true
    }
);

bar.addArgument(
    [ '-p', '--password' ],
    {
        action: 'store',
        help: 'Enter password',
        dest: 'pass',
        required: true
    }
);

bar.addArgument(
    [ '-a', '--age' ],
    {
        action: 'store',
        dest: 'age',
        type: 'int',
        help: 'Enter your age',
        required: true
    }
);

bar.addArgument(
    [ '-e', '--email' ],
    {
        action: 'store',
        dest: 'email',
        help: 'Enter your email',
        required: true
    }
);

var bar = subparsers.addParser('login', {addHelp:true});
bar.addArgument(
    [ '-u', '--username' ],
    {
        action: 'store',
        help: 'Enter username',
        dest: 'username',
        required: true
    }
);

bar.addArgument(
    [ '-p', '--password' ],
    {
        action: 'store',
        help: 'Enter password',
        dest: 'pass',
        required: true
    }
);

var bar = subparsers.addParser('getUserInfo', {addHelp:true});
bar.addArgument(
    [ '-u', '--username' ],
    {
        action: 'store',
        help: 'Enter username',
        dest: 'username',
        required: true
    }
);

var bar = subparsers.addParser('getUsers', {addHelp:true});

var bar = subparsers.addParser('resetPass', {addHelp:true});
bar.addArgument(
    [ '-u', '--username' ],
    {
        action: 'store',
        help: 'Enter username',
        dest: 'username',
        required: true
    }
);

bar.addArgument(
    [ '-a', '--age' ],
    {
        action: 'store',
        dest: 'age',
        type: 'int',
        help: 'Enter your age',
        required: true
    }
);

bar.addArgument(
    [ '-e', '--email' ],
    {
        action: 'store',
        dest: 'email',
        help: 'Enter your email',
        required: true
    }
);

bar.addArgument(
    [ '-op', '--oldpassword' ],
    {
        action: 'store',
        help: 'Enter password',
        dest: 'oldpass',
        required: true
    }
);

bar.addArgument(
    [ '-np', '--newpassword' ],
    {
        action: 'store',
        help: 'Enter password',
        dest: 'newpass',
        required: true
    }
);

function main() {
    var args = parser.parseArgs();
    if (args.command === "register") {
        reg(args.username, args.pass, args.age, args.email);
    } else if (args.command === "login") {
        login(args.username, args.pass);
    } else if (args.command === "getUserInfo") {
        getUserInfo(args.username);
    } else if (args.command === "getUsers") {
        getUsers();
    } else if (args.command === "resetPass") {
        resetPass(args.username,args.age, args.email,args.oldpass ,args.newpass);
    }
}

function reg(username, pass, age, email) {
    var check = true;
    var line1 = [];
    lr.on('error', function (err) {
        console.log("File not found");
    });
    lr.on('line', function (line) {
        line1 = line.split(" ");
        if (line1[0] === username) {
            check = false;
        }
    });
    lr.on('end', function () {
        if (check) {
            fs.appendFile("file.txt", username + " " + pass + " " + age + " " + email + "\n" , function(err) {
                if(err) {
                    return console.log(err);
                }
                console.log("The user was saved!");
            });
        } else {
            console.log("A user with this username already exists");
        }
    });

}

function login(username, pass) {
    var check = false;
    var line1 = [];
    lr.on('error', function (err) {
        console.log("File not found");
    });
    lr.on('line', function (line) {
        line1 = line.split(" ");
        if (line1[0] === username && line1[1] === pass) {
            check = true;
        }
    });
    lr.on('end', function () {
        if (check === true){
            console.log("Wellcome " + username + "\n" );
        } else {
            console.log("Wrong username or password");
        }
    }); 
}

function getUserInfo(username) {
    var check = false;
    var line1 = [];
    lr.on('error', function (err) {
        console.log("File not found");
    });
    lr.on('line', function (line) {
        line1 = line.split(" ");
        if (line1[0] === username) {
            check = true;
            console.log(line);
        }
    });
    lr.on('end', function () {
        if (check === false){
            console.log("The user with this name was not found");
        }
    }); 
   
}

function getUsers() {
    var check = false;
    var line1 = [];
    lr.on('error', function (err) {
        console.log("File not found");
    });
    lr.on('line', function (line) {
        check = true;
        console.log(line);
    });
    lr.on('end', function () {
        if (check === false){
            console.log("No registered users");
        }
    }); 
}

function resetPass(username, age, email, oldPass, newPass) {
    glob("file.txt",function (err,files) {
        if (err) {
            console.log("file not found\n");
        };
        files.forEach(function (item,index,array){
            replace({
                regex: username + " " + oldPass + " " + age + " " + email,
                replacement: username + " " + newPass + " " + age + " " + email,
                paths: [item],
                recursive: true,
                silent: true,
            });
            console.log("Replacement complete");
        });
    });
}

main();
