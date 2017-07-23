var userList = require('jsonfile')
var file = 'a.txt'
var users = {
    "users": []
};


//start
main()

function main() {
    action()
    help()
}

function help() {
    console.log("\n----------------------HELP-------------------------\n");
    console.log("Please register to create the file (a.txt)")

    console.log("register\t -> \t r name password email age");
    console.log("login   \t -> \t l  name password");
    console.log("reset password\t ->\t rp   name password new-password");
    console.log("get user info\t -> \t gui username");
    console.log("get users info\t -> \t guis");
    console.log("\n-----------------------------------------------------\n")
}


function createUser(name, password, email, age) {
    this.name = name;
    this.password = password;
    this.email = email;
    this.age = age;
}

function action() {
    switch (process.argv[2]) {
        case "r" : isUser(appendUser, 7);
            break;
        case "l" : isUser(login, 5);
            break;   
        case "rp": isUser(resetPass, 6);
            break;
        case "gui": isUser(getUserInfo, 4);
            break;
        case "gusi": getUsers();
            break;
        default: 
   }
}

function appendUser(index) {
    if (index == -1) {
        var user = new createUser(process.argv[3], process.argv[4], process.argv[5], process.argv[6]);
        users['users'].push(user);
        var json = JSON.stringify(users);
        userList.writeFile(file, json,  {spaces: 2});
        console.log("You are registrate");
    } else {
        console.log("You are not registrate")
    }   
    return ;
}

function login(index) {
    if (index != -1) {
        console.log("You are login");
    } else {
        console.log("You are not login");
    }
}

function resetPass(index) {
    if  (index != -1) {
        users['users'][index].password = process.argv[5];
        var json = JSON.stringify(users);
        userList.writeFile(file, json,  {spaces: 2});
        console.log("Password chenged!!!");
    } else {
        console.log("Password not chenged");
    }
}

function getUserInfo(index) {
    if (index != -1) {
        console.log(users['users'][index]);
    } else {
        console.log("Not this user!!!");
    }
}

function getUsers() {
    userList.readFile(file, function(err, obj) {
        if(obj != undefined) {
            users = JSON.parse(obj);
        } 
        console.log(users); 
    });
}

function isUser(callback, countArgs) {
    var index = -1;

    for (var i = 3; i < countArgs; ++i) {
        if ( !process.argv[i] ) {
            index = -1;
            return ;    
        }
    }

    userList.readFile(file, function(err, obj) {
        if(obj != undefined) {
            users = JSON.parse(obj);
            users['users'].forEach(function(item, ind, items){
                if (item.name == process.argv[3] && (!process.argv[4] || item.password == process.argv[4])) {
                    index = ind;
                    return;
                }
            });
        } else {
            index = -1;
        }
        callback(index);
    });
}






