var model = require('../models/myModel');

module.exports.addUser = function(req, res) {
    var userDetails = req.body;
    model.user = userDetails;
    var http = require('http');
    var MongoClient = require('mongodb').MongoClient;
    var url = "mongodb://localhost:27017/itc";

    MongoClient.connect(url, function(err, db) {
        if (err) {
            console.log("Error: ", err.message);
        }
        db.collection("Users").insertOne(user, function(err, res) {
            if (err) {
                console.log("Error: ", err.message);
            }
            console.log("1 record inserted");
            db.close();
        });
    });
    res.send('{"status":"created"}');
}

module.exports.getUsers = function(req, res) {
    var http = require('http');
    var MongoClient = require('mongodb').MongoClient;
    var url = "mongodb://localhost:27017/itc";

    MongoClient.connect(url, function(err, db) {
            if (err) {
                console.log("Error: ", err.message);
            }
        db.collection("Users").find({}).toArray(function(err, result) {
            if (err) {
                console.log("Error: ", err.message);
            }
            console.log(result);
            db.close();
        });
    });
    res.send(JSON.stringify(model.users));
}

module.exports.deleteUser = function(req, res) {
    var username = req.params.username;
    var http = require('http');
    var MongoClient = require('mongodb').MongoClient;
    var url = "mongodb://localhost:27017/itc";

    MongoClient.connect(url, function(err, db) {
        if (err) {
            console.log("Error: ", err.message);
        }
        var query = { name : username };
        db.collection("Users").deleteOne(query, function(err, obj) {
            if (err) {
                console.log("Error: ", err.message);
            }
            console.log("1 document deleted");
            db.close();
        });
    });
    res.send('{"status":"deleted"}');
}

module.exports.deleteAllUsers = function(req, res) {
    var http = require('http');
    var MongoClient = require('mongodb').MongoClient;
    var url = "mongodb://localhost:27017/itc";

    MongoClient.connect(url, function(err, db) {
        if (err) {
            console.log("Error: ", err.message);
        }
        var query = { name : "/*/" };
        db.collection("Users").deleteMany(query, function(err, obj) {
            if (err) {
                console.log("Error: ", err.message);
            }
            console.log("1 document deleted");
            db.close();
        });
    });
    res.send('{"status":"all_deleted"}');
}
