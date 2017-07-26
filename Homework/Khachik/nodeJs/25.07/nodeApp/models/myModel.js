var options = {
   user: 'postgres',
   host: '127.0.0.1',
   db: 'users',
   password: 'root',
   port: 5432,
};

var db = require('postgres-gen')(options);

var dao = require('postgres-gen-dao');
var users_table = dao({ db: db, table: 'users_table' });



var b = { name: 'John Public', email : 'user@gmail.com',age: 23 };

module.exports.addUser = function(r) {
    console.log(r.body);
    users_table.upsert(r.body).then(function() {
        console.log("Successfully added");
        return 'Successfully added.';
    }) .catch(function () {
        console.log("Uncorrect request");
    });
};


module.exports.getUsers = function() {
    users_table.find().then(function(us) {
        console.log(us);
        return us;
    }).catch(function () {
        console.log("Promise Rejected");
    });
};




module.exports.deleteUser = function(r) {
    db.transaction(function*() {
        var userName = r.params.username;
        var b = yield users_table.findOne('name = ?', userName);
        console.log(b.id);
        yield users_table.delete('id = $id', {"id" : b.id});
    }).then(function(suc) {
        return '{"status":200, "body":"User successfully deleted"}'
    }).catch
}

module.exports.deleteAllUsers = function() {
    db.transaction(function*() {
        yield dao.delete();
    });
}


