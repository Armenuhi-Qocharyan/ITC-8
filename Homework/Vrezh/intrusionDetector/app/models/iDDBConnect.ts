
var db = require('postgres-gen');
module.exports.getDB = function(nameDB) {
    const client = {
        user: 'vrezh',
        host: '127.0.0.1',
        db: nameDB, 
        password: '',  
        port: 5432
    };
    return db(client);
}
~ 
