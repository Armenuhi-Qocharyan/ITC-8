var mongoose = require("mongoose"),
    userSchema = require('../models/model'),
    User = mongoose.model('users', userSchema);
module.exports.addUser = function(req, res) {

    var newUser = new User(req.body);
    newUser.save(function(err) {
        if (err) {
            console.log('Error on save!');
        }
    })
    res.send('{"status": "inserted"}');
};

module.exports.getUsers = function(req, res) {

    User.find({}, function(err, users) {

        if (err) {
            return handleError(err);
        }

        res.send(users);

    })

};

module.exports.deleteUser = function(req, res) {

    User.remove({
        'age': 2
    }, function(err) {
        if (err) {
            return handleError(err);
        }
    });

    res.send('{"status":"deleted"}');

};

module.exports.deleteAllUsers = function(req, res) {
    User.remove({}, function(err) {
        if (err) {
            return handleError(err);
        }
    });
    res.send('{"status":"Alldeleted"}');

};
