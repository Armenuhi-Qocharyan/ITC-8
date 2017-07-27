module.exports.getUsersDB = function() {
    var options = {
       user: 'postgres',
       host: '127.0.0.1',
       db: 'users',
       password: 'root',
       port: 5432,
    };
    var db = require('postgres-gen')(options);
    return db;
}
