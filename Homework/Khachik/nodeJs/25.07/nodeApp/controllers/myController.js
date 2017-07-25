var model = require('../models/myModel');


module.exports.addUser = function(req, res) {
    model.addUser();
}


module.exports.getUsers = function(req, res) {
    model.getUsers();
} 

module.exports.deleteUser = function(req, res) {
    model.deleteUser(req);
}
module.exports.deleteAllUsers = function(req, res) {
    model.deleteAllUsers();
}

