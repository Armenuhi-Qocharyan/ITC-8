var model = require('../models/myModel');


module.exports.addUser = function(req, res) {
    //req.body.age = parseInt(req.body age);
    var r = model.addUser(req);
    res.send(r);
//    console.log(req);
}


module.exports.getUsers = function(req, res) {
    var r = model.getUsers();
    res.send(JSON.stringify(r));
} 

module.exports.deleteUser = function(req, res) {
//    console.log(req.params.username);
    var r = model.deleteUser(req);
    res.send(r);
}
module.exports.deleteAllUsers = function(req, res) {
//    model.deleteAllUsers();
}

