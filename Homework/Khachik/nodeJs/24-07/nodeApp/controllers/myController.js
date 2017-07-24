var model = require('../models/myModel');

var promise = require('bluebird');

var options = {
   promiseLib: promise
};

var pgp = require('pg-promise')(options);
var connectionString = 'postgres://root:root:@localhost:5432/users';
var db = pgp(connectionString);

module.exports.addUser = function(req, res) {
    req.body.age = parseInt(req.body.age);
    db.none('insert into user_table(name, email, age)' +
            'values(${name}, ${email}, ${age}',
            req.body)
        .then(function () {
            res.status(200)
            .json({
                status: 'success',
            message: 'Inserted one user'
            });
        })
    .catch(function (err) {
        return next(err);
    });
}

module.exports.getUsers = function(req, res, next) {
    //res.send(JSON.stringify(model.users));
    db.any('select * from user_table')
        .then(function (data) {
            res.status(200)
            .json({
                status: 'success',
                data: data,
                message: 'Retrieved ALL users'
            });
        })
    .catch(function (err) {
        return next(err);
    });
}

module.exports.deleteUser = function(req, res) {
    var userName = parseInt(req.params.name);
    db.result('delete from user_table where name = $1', userName)
        .then(function (result) {
            res.status(200)
            .json({
                status: 'success',
                message: `Removed ${result.rowCount} user`
            });
        })
    .catch(function (err) {
        return next(err);
    });
}

module.exports.deleteAllUsers = function(req, res) {
    db.result('delete * from user_table1', userName)
        .then(function (result) {
            res.status(200)
            .json({
                status: 'success',
                message: `Removed ${result.rowCount} user`
            });
        })
    .catch(function (err) {
        return next(err);
    });
}



