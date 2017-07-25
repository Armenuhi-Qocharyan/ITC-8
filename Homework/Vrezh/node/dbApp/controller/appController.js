var model = require("./../models/appModel.js");

const pg = require('pg');
const client = new pg.Client({
  user: 'vrezh',
  host: '127.0.0.1',
  database: 'users', 
  password: 'abc',  
  port: 5432,
});

client.connect();

module.exports.getUsers = function(req, res) {
    var results = [];
    const query = client.query('SELECT username FROM users', (err, status) => {
        if (err) {
            res.send(JSON.stringify(err));
            console.log("Invalid query !!!");
        } else {
            res.send(JSON.stringify(status));
            console.log("Valid query");
        } 
    });
    query.on('row', (row) => {
        results.push(row); 
        console.log(results);
    });
    query.on('end', () => { 
        res.send(JSON.stringify(results));
    });
}

module.exports.deleteUser = function(req, res) {
    const query = client.query('DELETE FROM users WHERE username = $1', [req.params.userName], (err, status) => {
        if (err) {
            console.log("Invalid query !!!");
            res.send({"status":"Not Deleted"});
        } else {
            res.send(JSON.stringify(status));
        }
    });
    query.on('row', (row) => {
        res.send({"status" : "deleated"}); 
    });

}
