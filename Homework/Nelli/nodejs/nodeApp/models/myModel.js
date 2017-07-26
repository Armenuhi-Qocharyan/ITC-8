var options = {
   user: 'postgres',
   host: '127.0.0.1',
   db: 'users',
   password: 'root',
   port: 5432,
};
var db = require('postgres-gen')(options);

var dao = require('postgres-gen-dao');
var users = dao({ db: db, table: 'users' });


module.exports.addUser = function(userInfo) {
    users.upsert(userInfo).then(function() {
    	console.log("User added");
    })
};

module.exports.getAllUsers = function(res) {
    users.find().then(function(users) {
        res.send(JSON.stringify(users));
        res.status(200).json({success: true, "body": "All Users Info"});
    }).catch(function(err) {
        res.send(JSON.stringify({"status": "400", "body": "Bad request"}));
        res.status(400).json({success: true, "body": "Bad Request"});
    });
};

module.exports.userDelete = function(username,res) {
    db.transaction(function*() {
	var user = yield users.findOne('name = ?', username);
    	yield users.delete(user);
    }).then(function(suc) {
        res.send(JSON.stringify({"status": "200", "body": "User Deleated"}));
        res.status(200).json({success: true, "body": "User Deleted"});
    }).catch(function(err) {
        res.send(JSON.stringify({"status": "400", "body": "Bad request"}));
        res.status(400).json({success: true, "body": "Bad Request"});
    });
};


module.exports.allUsersDelete = function(res) {
    db.transaction(function*() {
        yield users.delete('id > 0');
    }).then(function(suc) {
        res.send(JSON.stringify({"status": "200", "body": "All Users Deleated"}));
        res.status(200).json({success: true, "body": "All Users Deleted"});
    }).catch(function(err) {
        res.send(JSON.stringify({"status": "400", "body": "Bad request"}));
        res.status(400).json({success: true, "body": "Bad Request"});
    });
};

