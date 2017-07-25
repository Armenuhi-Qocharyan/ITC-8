module.exports.addUser = function(req, res) {
    var http = require('http');
    var MongoClient = require('mongodb').MongoClient,
        url = "mongodb://localhost:27017/firstapi";

    MongoClient.connect(url, function(err, db) {
        if (err) throw err;
        var myobj = req.body;
        db.collection("users").insertOne(myobj, function(err, res) {
            if (err) throw err;
            db.close();
        });
        res.send('{"status": "inserted"}');
    });

}

module.exports.getUsers = function(req, res) {
    var http = require('http');
    var MongoClient = require('mongodb').MongoClient;
    var url = "mongodb://localhost:27017/firstapi";

    MongoClient.connect(url, function(err, db) {
        if (err) throw err;
        db.collection("users").findOne({}, function(err, result) {
            if (err) throw err;
            res.send(result.name);
            db.close();
        });
    });


}

module.exports.deleteUser = function(req, res) {
    var http = require('http');
    var MongoClient = require('mongodb').MongoClient;
    var url = "mongodb://localhost:27017/firstapi";

    MongoClient.connect(url, function(err, db) {
        if (err) throw err;
        var myquery = req.body;
        db.collection("users").deleteOne(myquery, function(err, obj) {
            if (err) throw err;
            console.log("1 document deleted");
            db.close();
        });
        res.send('{"status":"deleted"}');
    });

}

module.exports.deleteAllUsers = function(req, res) {

    var http = require('http');
    var MongoClient = require('mongodb').MongoClient;
    var url = "mongodb://localhost:27017/firstapi";

    MongoClient.connect(url, function(err, db) {
        if (err) throw err;
        db.collection("users").remove({}, function(err, obj) {
            if (err) throw err;
            db.close();
        });
        res.send('{"status":"all deleted"}');

    });

}
