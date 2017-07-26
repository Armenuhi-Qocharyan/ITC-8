var model = require('../models/myModel');

module.exports.addUsers = function(req, res) {
    var userInfo = req.body;
    model.addUser(userInfo);
    res.send('{"status":"created"}');
};

module.exports.getUsers = function(req, res) {
    model.getAllUsers(res);
};

module.exports.deleteUser = function(req, res) {
    var username = req.params.username;
    model.userDelete(username, res);
};



module.exports.deleteAllUsers = function(req, res) {
    model.allUsersDelete(res);
};
