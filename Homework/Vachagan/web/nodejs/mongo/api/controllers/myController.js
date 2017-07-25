var model = require('../models/myModel');
var mongoose = require ("mongoose");

module.exports.addUser = function(req, res) {
    var PUser = mongoose.model('Users', model.userSchema);
    var johndoe = new PUser (req.body);
    johndoe.save(function (err) {if (err) console.log ('Error on save!')});
    res.send('{"status": "inserted"}');
};

module.exports.getUsers = function(req, res) {
    var MyModel = mongoose.model('Users', model.userSchema);
    MyModel.find({}, function (err, docs) {
        if(err) console.log(err);
        res.send(docs);
    });
};

module.exports.deleteUser =  function(req, res) {
    var  username = req.params.username;
    var MyModel = mongoose.model('Users',model.userSchema);
    MyModel.find({}, function (err, docs) {
        if(err) console.log(err);
        for (i in docs) {
            if (docs[i].name.first === username)
            {
                docs[i].remove({},function (err) {
                    if(err) console.log(err);
                });
            }
        }
        res.send('{"status":"deletedUser"}');
    });
};

module.exports.deleteAllUsers =function(req, res) {
    var MyModel = mongoose.model('Users',model.userSchema);
    MyModel.remove({},function (err) {
        res.send('{"status":"deleted"}');
    });
};