var getDb = require('./getUserDb');
var db = getDb.getUsersDB();

var dao = require('postgres-gen-dao');
var users = dao({ db: db, table: 'users' });

var error = function(res) {
    res.send(JSON.stringify({"status": "400", "body": "Bad request"}));
    res.status(400).json({success: true, "body": "Bad Request"});
}
var success = function(res,msg){
    res.send(JSON.stringify({"status": "200", "body": msg}));
    res.status(200).json({success: true, "body": msg});
}

module.exports.m_addUser = function(req, res) {
    users.upsert(req.body).then(function(suc) {
        success(res, 'Added new user');
    }).catch(function(err){
        error(res);
    })
};

module.exports.m_getUsers = function(res) {
    users.find().then(function(users) {
        res.send(JSON.stringify(users));
        res.status(200).json({success: true, "body": "Users List"});
    }).catch(function(err) {
        error(res);
    });
};

module.exports.m_deleteUser = function(name, res) {
    db.transaction(function*() {
	    var deletedUser = yield users.findOne('name = ?',name);
    	yield users.delete(deletedUser);
    }).then(function(suc) {
        success(res,'User deleted');
    }).catch(function(err) {
        error(res);
    });
};


