var users = require("./../models/users");

module.exports.getUsers = function(req, res) {
    users.getUsers(req, res);
}

module.exports.deleteUser = function(req, res) {
    users.deleteUser(req.params.userId, req, res);
}

module.exports.addUser = function(req, res) {
    users.addUser(req, res);
}

