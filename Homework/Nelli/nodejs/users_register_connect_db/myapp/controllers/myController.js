var model = require('../models/myModel'),
    db = model.db;

module.exports.addUser = function(req, res) {
    req.body.age = parseInt(req.body.age);
    db.none('insert into users(name, email, age)' +
            'values(${name}, ${email}, ${age}',
            req.body)
        .then(function() {
            res.status(200)
                .json({
                    status: 'success',
                    message: 'User added'
                });
        })
        .catch(function(err) {
            return next(err);
        });
}

module.exports.getUsers = function(req, res, next) {
    db.any('select * from users')
        .then(function(data) {
            res.status(200)
                .json({
                    status: 'success',
                    data: data,
                    message: 'ALL users'
                });
        })
        .catch(function(err) {
            return next(err);
        });
}


module.exports.deleteUser = function(req, res) {
    var userName = parseInt(req.params.name);
    db.result('delete from users where name = $1', userName)
        .then(function(result) {
            res.status(200)
                .json({
                    status: 'success',
                    message: `Removed ${result.rowCount} user`
                });
        })
        .catch(function(err) {
            return next(err);
        });
}


module.exports.deleteAllUsers = function(req, res) {
    db.result('delete * from users', userName)
        .then(function(result) {
            res.status(200)
                .json({
                    status: 'success',
                    message: `Removed ${result.rowCount} user`
                });
        })
        .catch(function(err) {
            return next(err);
        });
}