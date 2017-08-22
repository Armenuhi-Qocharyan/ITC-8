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

module.exports.addUser = function(req, res) {
    console.log(req.body);
    users_table.upsert(req.body).then(function() {
        console.log("Successfully added");
        res.send(JSON.stringify({"status": 200, "body":"Successfully added."}));
//        res.status(200).json({"added":true, "body":"Successfully added."});
    }) .catch(function () {
        res.send(JSON.stringify({"status": 400, "body":"bad request"}));
//        res.status(400).json({"added":false, "body":"Bad request"});
 
    });
};


module.exports.getUsers = function(req, res) {
    users_table.find().then(function(us) {
        console.log(us);
        res.send(JSON.stringify(us));
    }).catch(function () {
         res.send(JSON.stringify({"status": 404, "body":"Not found"}));
    });
};




module.exports.deleteUser = function(req, res) {
    db.transaction(function*() {
        var userName = req.params.username;
        var b = yield users_table.findOne('name = ?', userName);
        yield users_table.delete('id = $id', {"id" : b.id});
    }).then(function(suc) {
          res.send(JSON.stringify({"delete": true, "body":"Successfully deleted"}));
          console.log("Successfully deleted\n");
    }).catch(function () {
         res.send(JSON.stringify({"status": 400, "body":"Bad request"}));
    });
 
}

module.exports.deleteAllUsers = function(req, res) {
    db.transaction(function*() {
        yield dao.delete();
    });
}


