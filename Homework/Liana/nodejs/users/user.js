#!/usr/bin/env node

'use strict';
var fs = require('fs'),
    replace = require("replace"),
    LineByLineReader = require('line-by-line'),
    prompt = require('prompt'),
    ArgumentParser = require('argparse').ArgumentParser,


    parser = new ArgumentParser({
        version: '0.0.1',
        addHelp: true,
        description: 'Login and Registration app',
    }),

    subparsers = parser.addSubparsers({
        title: 'subcommands',
        dest: "command"
    });

var reg = subparsers.addParser('register', {
    addHelp: true
});
reg.addArgument(
    ['-u', '--username'], {
        action: 'store',
        help: 'Enter username',
        dest: 'username',
        required: true

    },

);

reg.addArgument(
    ['-p', '--password'], {
        action: 'store',
        help: 'Enter password',
        dest: 'pass',
        required: true
    },

);

reg.addArgument(
    ['-a', '--age'], {
        action: 'store',
        dest: 'age',
        type: 'int',
        help: 'Enter your age',
        required: true
    },

);



var log = subparsers.addParser(
    'login', {
        addHelp: true
    }
);
log.addArgument(
    ['-u', '--username'], {
        action: 'store',
        help: 'Enter your name',
        dest: 'uname',
        required: true
    }
);

log.addArgument(
    ['-p', '--password'], {
        action: 'store',
        help: 'Enter your password',
        dest: 'password',
        required: true
    }
);




var res = subparsers.addParser(
    'reset', {
        addHelp: true
    }
);
res.addArgument(
    ['-u', '--username'], {
        action: 'store',
        help: 'Enter your name',
        dest: 'rname',
        required: true

    }
);

res.addArgument(
    ['-a', '--age'], {
        action: 'store',
        help: 'Enter your age',
        dest: 'rage',
        required: true
    }
);

var inf = subparsers.addParser(
    'info', {
        addHelp: true
    }
);
inf.addArgument(
    ['-u', '--username'], {
        action: 'store',
        help: 'Enter your name',
        dest: 'iname',
        required: true

    }
);


var args = parser.parseArgs();
define();

function define() {
    switch (args.command) {
        case 'login':
            login();
            break;
        case 'register':
            register();
            break;
        case 'reset':
            reset();
            break;
        case 'info':
            info();
            break;
        default:
            break;
    }
}

function login() {
    var isUser = false,
        check = 'username: ' + args.uname + ', password: ' + args.password + ", age: ",
        lr = new LineByLineReader('file.txt');
    lr.on('line', function(line) {
        if (line.search(check) == 0) {
            isUser = true;
            return;
        }

    });

    lr.on('end', function() {
        if (true == isUser) {
            console.log("Hello " + args.uname + "!!!")
        } else {

            console.log("Authentication failed..")
        }

    });
}


function register() {

    var isValid = true;
    var check = 'username: ' + args.username + ', password: ' + args.pass + ", age: ",
        lr = new LineByLineReader('file.txt');

    lr.on('line', function(line) {

        if (line.search(check) != -1) {
            isValid = false;
        }

    });

    lr.on('end', function() {
        if (true == isValid) {
            check = check + args.age + '\n';
            fs.appendFile('file.txt', check, function(err) {
                console.log('Registrated!');
            });

        } else {
            console.log("User already exist..");
        }
    });
}

function reset() {
    var username = "username: " + args.rname + ", ",
        age = "age: " + args.rage,
        old = false,
        lr = new LineByLineReader('file.txt');
    lr.on('line', function(line) {
        if (line.search(username) != -1 && line.search(age) != -1) {
            old = line;
        }

    });

    lr.on('end', function() {
        if (false != old) {
            prompt.start();
            prompt.get(['password'], function(err, result) {
                if (result.password == '') {
                    console.log('Password is required');

                } else {

                    var password = 'password: ' + result.password + ', ',
                        user = username + password + age;
                    replace({
                        regex: old,
                        replacement: user,
                        paths: ['file.txt'],
                        silent: true,
                    });
                    console.log("Password changed.");
                }
            });


        } else {
            console.log("Incorrect user data..");
        }
    });

}

function info() {
    var check = "username: " + args.iname + ", ",
        user = false,
        lr = new LineByLineReader('file.txt');

    lr.on('line', function(line) {

        if (line.search(check) != -1) {
            user = line;
        }

    });

    lr.on('end', function() {
        if (false != user) {
            var index = user.search("age: "),
                result = user.slice(index);
            console.log(result);

        } else {
            console.log("Unknown user..");
        }
    });
}
