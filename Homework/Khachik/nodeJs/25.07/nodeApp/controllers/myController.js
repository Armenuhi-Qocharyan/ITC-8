var model = require('../models/myModel');


module.exports.addUser = function(req, res) {
    model.addUser(req,res);
}


module.exports.getUsers = function(req, res) {
    model.getUsers(req,res);
} 

module.exports.deleteUser = function(req, res) {
    model.deleteUser(req,res);
}
module.exports.deleteAllUsers = function(req, res) {
//    model.deleteAllUsers();
}

