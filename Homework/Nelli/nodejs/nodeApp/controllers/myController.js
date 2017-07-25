var model = require('../models/myModel');

module.exports.addUsers = function(req, res) {
    model.addUser();
}

module.exports.getUsers = function(req, res) {
    console.log("Ctrl");
    model.getAllUsers();	
}

module.exports.deleteUser = function(req, res) {
    var userName = parseInt(req.params.name);
}

module.exports.deleteAllUsers = function(req, res) {
}
