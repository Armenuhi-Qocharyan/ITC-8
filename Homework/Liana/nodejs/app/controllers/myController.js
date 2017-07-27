var User = require('../models/model');

module.exports.addUser = function(req, res, next) {

    var newUser = new User(req.body);

    newUser.save(function(err) {
        if (err) {
            if (err.errors.age) {
                res.status(400).send(err.errors.age.message);
            } else if (err.errors['name.last']) {
                res.status(400).send(err.errors['name.last'].message);
            } else if (err.errors['name.first']) {
                res.status(400).send(err.errors['name.first'].message);
            } else {
                return next(err);
            }

        } else {
            res.send('{"status": "inserted"}');
        }

    })
};

module.exports.getUsers = function(req, res) {

    User.find({}, function(err, users) {

        if (err) {
            return res.status(400).send("Error: Can't find data");
        }
        res.send(users);
    })
};

module.exports.deleteUser = function(req, res, next) {
    User.remove({
        'age': 2
    }, function(err) {
        if (err) {
            return next(err);
        }
    });

    res.send('{"status":"deleted"}');

};

module.exports.deleteAllUsers = function(req, res, next) {
    User.remove({}, function(err) {
        if (err) {
            return next(err);
        }
    });
    res.send('{"status":"Alldeleted"}');

};