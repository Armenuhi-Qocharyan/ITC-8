var options = {
   user: 'postgres',
   host: '127.0.0.1',
   db: 'users',
   password: 'root',
   port: 5432,
};

var db = require('postgres-gen')(options);

var dao = require('postgres-gen-dao');
var user_table = dao({ db: db, table: 'user_table' });



var b = { 'name': 'John Public', 'email': 'user@gmail.com','age': 23 };

module.exports.addUser = function() {
    user_table.upsert(b).then(function() {
        console.log("successfully added")
    })
};


module.exports.getUsers = function() {
    user_table.find().then(function(users) {
        console.log(users);
    });
}


module.exports.deleteUser = function(req) {
    db.transaction(function*() {
        var userName = parseInt(req.params.name);
        var b = yield user_table.findOne('name = ?', userName);
        yield dao.delete(b);
    });
}

module.exports.deleteAllUsers = function() {
    db.transaction(function*() {
        yield dao.delete();
    });
}


