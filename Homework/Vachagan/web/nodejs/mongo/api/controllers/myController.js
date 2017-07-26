var model = require('../models/myModel');
//var mongoose = require ("mongoose");

module.exports.addUser = function(req, res) {
    var johndoe = new model (req.body);
    johndoe.save(function (err) {if (err) console.log ('Error on save!')});
    res.send('{"status": "inserted"}');
};

module.exports.getUsers = function(req, res) {
    model.find({}, function (err, docs) {
        if(err) console.log(err);
        res.send(docs);
    });
};

module.exports.deleteUser =  function(req, res) {
    var  username = req.params.username;
    model.find({}, function (err, docs) {
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
    model.remove({},function (err) {
        res.send('{"status":"deleted"}');
    });
};