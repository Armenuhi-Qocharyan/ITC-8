var model = require('../models/myModel'),
    MongoClient = model.MongoClient,
    url = model.url;

module.exports.addUser = function(req, res) {
    res.send({"Status": "Added user"});
}

module.exports.getUsers = function(req, res) {
    res.send({"Status": "All users"});
}

module.exports.deleteUser = function(req, res) {
    res.send({"Status": "Deleted"});
}

module.exports.deleteAllUsers = function(req, res) {
    res.send({"Status": "all deleted"});
}

