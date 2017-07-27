var userModel = require('../models/usersModel');

module.exports.addUsers = function(req, res) {
    userModel.m_addUser(req, res);
};

module.exports.getUsers = function(req, res) {
    userModel.m_getUsers(res);
};

module.exports.deleteUser = function(req, res) {
    userModel.m_deleteUser( req.params.username, res);
};
