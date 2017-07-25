var promise = require('bluebird');

var options = {
    promiseLib: promise
};

var pgp = require('pg-promise')(options);
var connectionString = 'postgres://root:root:@localhost:5432/itc';
module.exports.db = pgp(connectionString);