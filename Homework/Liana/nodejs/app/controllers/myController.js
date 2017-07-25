console.log("my controller works");
var mongoose = require ("mongoose"); // The reason for this demo.


//var http = require('http');
//var MongoClient = require('mongodb').MongoClient;
//var url = "mongodb://localhost:27017/nodeDb";

var model = require('../models/model');




module.exports.addUser = function(req, res) {

    console.log(req.body.first);
    console.log(req.body.age);

    var PUser = mongoose.model('PowerUsers', model.userSchema);

    // Creating one user.
    /*var johndoe = new PUser ({
        name: { first: 'John', last: '  Doe   ' },
        age: 25
    });*/
    var johndoe = new PUser (req.body);

    // Saving it to the database.
    johndoe.save(function (err) {if (err) console.log ('Error on save!')});

    /*
    MongoClient.connect(url, function(err, db) {
        if (err) throw err;
        var myobj = req.body;
        db.collection("users").insertOne(myobj, function(err, res) {
            if (err) throw err;
            db.close();
        });
    });*/
     res.send('{"status": "inserted"}');


};


/*
module.exports.getUsers = function(req, res) {
    MongoClient.connect(url, function(err, db) {
        if (err) throw err;
        db.collection("users").find({}).toArray(function(err, result) {
            if (err) throw err;
            console.log(result);
            res.send(JSON.stringify(result));
            db.close();
        });
    });
};

module.exports.deleteUser = function(req, res) {


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

};

module.exports.deleteAllUsers = function(req, res) {


    MongoClient.connect(url, function(err, db) {
        if (err) throw err;
        db.collection("users").remove({}, function(err, obj) {
            if (err) throw err;
            db.close();
        });
        res.send('{"status":"all deleted"}');

    });

};
*/