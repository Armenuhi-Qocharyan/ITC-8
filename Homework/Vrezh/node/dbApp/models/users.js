var DBs = require('./usersDB');

var usersDB = DBs.getDB('users');
var dao = require('postgres-gen-dao');
var users = dao({ db: usersDB, table: 'users' });


var isValid = function(reqBody) {
    if ('user'in reqBody) {
        if (('id' in reqBody.user) && ('username' in reqBody.user)) {
            return true;
        }
    }
    return false;
}

module.exports.addUser = function(req, res) { 
    var newUser;
    if (isValid(req.body)) {
        newUser = req.body
    } else {
        res.send(JSON.stringify({"status": 400, "body": "Bad request"}));
        res.status(400).json({success: true, body: "Bad Request"});
        return;
    }  
    users.upsert(newUser.user).then(function(suc) {
        res.send(JSON.stringify({"status": 200, "body": "User Added"}));
        res.status(200).json({"success": true, "body": "User Added"});
    }).catch(function(err) {
        res.send(JSON.stringify({"status": 400, "body": "Bad request"}));
        res.status(400).json({success: true, body: "Bad Request"});
    });
};


module.exports.deleteUser = function(id, req, res) { 
    usersDB.transaction(function*() {
        yield users.delete('id = $id', {"id": id});
    }).then(function(suc) {
        res.send(JSON.stringify({"status": "200", "body": "User Deleated"}));
        res.status(200).json({success: true, body: "User Deleted"});
    }).catch(function(err) {
        res.send(JSON.stringify({"status": "400", "body": "Bad request"}));
        res.status(400).json({success: true, body: "Bad Request"});
    });
};

module.exports.getUsers = function(req, res) { 
    var allUsers;
    usersDB.transaction(function*() {
        allUsers = (yield users.find());
    }).then(function(suc){
        console.log("Users returned");
        res.send(JSON.stringify(allUsers));
        res.status(200).json({success: true, body: "Request Success"});
    }).catch(function(err) {
        res.send(JSON.stringify({status: "500"}));
        res.status(500).json({success: fale, body: "Request Failure"});
    });
};
