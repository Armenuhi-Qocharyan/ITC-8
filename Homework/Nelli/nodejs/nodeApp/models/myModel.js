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

var userInfo = { 'name': 'John', 'email': 'user@gmail.com','age': 23 };

module.exports.addUser = function() {
    users.upsert(userInfo).then(function() {
    	console.log("User added");
    })
};

module.exports.getAllUsers = function() {
    users.find().then(function(users) {
    	console.log("List of all users");
    	for (index in users) {
	    for (key in users[index]) {	
	    	console.log(key + " : " + users[index][key]);
            }
    	}
    });
};

module.exports.userDelete = function(username) {
    db.transaction(function*() {
	var user = yield users.findOne('name = ?', username);
    	yield users.delete(user);
    	console.log("User deleted");
    });
};

module.exports.allUsersDelete = function() {
    db.transaction(function*() {
        yield users.delete('id > 0');
    	console.log("All Users deleted");
    });
};

