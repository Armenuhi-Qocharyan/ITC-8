//npm install find-in-files
//npm install file-system
//npm install prompt

const fs = require('fs');
var findInFiles = require('find-in-files');
var prompt = require('prompt');

console.log("Available commands register,login,change,info.");
main();

function main() {
    createFile("users.txt");
    prompt.start();
    prompt.get(['command'], function (err, result) {
        switch (result.command){
            case 'register':registr(); break;
            case 'login':login();break;
            case 'info': getInfo(); break;
            case 'change':changeUser(); break;
            default:console.log("Command must be only register,login,change,info.");main();
        }
    });
}

function createFile(filename) {
    fs.open(filename,'r',function(err, fd){
        if (err) {
            fs.writeFile(filename, '', function(err) {
                if(err) {
                    console.log(err);
                }
              //  console.log("The file was created!");
            });
        } else {
          //  console.log("The file exists!");
        }
    });
}

cnt = 0;

//registr();
//getInfo();
//login();
//change("vachagan--artur@mail.ru--vachagan","armen--armen@other.ru--password");

function registr() {
   // createFile("users.txt");
    var schema = {
        properties: {
            name: {
                description: 'Enter your name',
                pattern: /^[a-zA-Z\s\-]+$/,
                message: 'Name must be only letters, spaces, or dashes',
                required: true
            },
            email: {
                pattern: /^[0-9a-zA-Z\s\-]+[@]+[0-9a-zA-Z\s\-]+[.]+[a-zA-Z\s\-]+$/,
                message: 'Wrong email format',
                required: true
            },
            password: {
                hidden: true,
                replace: '*'
            }
        }
    };
    prompt.start();
    prompt.get(schema, function (err, result) {
        var str = result.name + "--" + result.email;
        check(str,result.password);
    });
}

function login() {
    var schema = {
        properties: {
            name: {
                description: 'Enter your name or email',
                required: true
            },
            password: {
                hidden: true,
                replace: '*'
            }
        }
    };
    prompt.start();
    prompt.get(schema, function (err, result) {
        check(result.name,result.password,true);
    });
}

function check(info,pass,login) {
     findInFiles.find(info, '.', 'users.txt$')
        .then(function(results) {
            if(login){
                if(results["users.txt"] == undefined){
                    console.log("You are input wrong name or email.")
                }
                for (var result in results) {
                    var res = results[result];
                    var user = res.line[0].split('--');
                    if (pass == user[2]) {
                        console.log("You are login in ...")
                    } else {
                        console.log("You are input wrong password")
                    }
                }
                return;
            }
            if(results["users.txt"] == undefined) {
                var logger = fs.createWriteStream('users.txt', {
                    flags: 'a'
                });
                logger.write(info + "--" + pass + '\n');
                logger.end();
                console.log("Registred !!");
            } else {
                console.log("Thats user already exists");
            }
        });
}

function getInfo() {
    var data = fs.readFileSync("users.txt").toString().split('\n');
    for (var index in data) {
        users = data[index].split("--");
        if(users[1] != undefined) {
            console.log("name: " + users[0] + " email: " + users[1])
        }
    }
}

function changeUser() {
    var schema = {
        properties: {
            fname: {
                description: 'Enter first name',
                pattern: /^[a-zA-Z\s\-]+$/,
                message: 'Name must be only letters, spaces, or dashes',
                required: true
            },
            sname: {
                description: 'Enter second name',
                pattern: /^[a-zA-Z\s\-]+$/,
                message: 'Name must be only letters, spaces, or dashes',
                required: true
            },
            femail: {
                description: 'Enter first email',
                pattern: /^[0-9a-zA-Z\s\-]+[@]+[0-9a-zA-Z\s\-]+[.]+[a-zA-Z\s\-]+$/,
                message: 'Wrong email format',
                required: true
            },
            semail: {
                description: 'Enter second email',
                pattern: /^[0-9a-zA-Z\s\-]+[@]+[0-9a-zA-Z\s\-]+[.]+[a-zA-Z\s\-]+$/,
                message: 'Wrong email format',
                required: true
            },
            fpassword: {
                description: 'Enter first password',
                hidden: true,
                replace: '*'
            },
            spassword: {
                description: 'Enter second password',
                hidden: true,
                replace: '*'
            }
        }
    };
    prompt.start();
    prompt.get(schema, function (err, result) {
        var old = result.fname + "--" + result.femail + "--" + result.fpassword;
        var newinfo = result.sname + "--" + result.semail + "--" + result.spassword;
        change(old,newinfo);
    });
}



function change(old,newinfo) {
    fs.readFile('users.txt', 'utf8', function (err,data) {
        if (err) {
            return console.log(err);
        }
        var result = data.replace(old, newinfo);

        fs.writeFile('users.txt', result, 'utf8', function (err) {
            if (err) return console.log(err);
        });
        console.log("Change.")
    });
}