var express = require('express');
var router = express.Router();
var model = require('../models/myModel');
var MongoClient = require('mongodb').MongoClient;
var url = "mongodb://localhost:27017/nodeDb";

MongoClient.connect(url, function(err, db) {
  if (err) throw err;
  db.createCollection("users", function(err, res) {
    if (err) throw err;
    console.log("Table created!");
    db.close();
  });
});

router.post('/users', function(req, res) {
	var userDetails = req.body;
	MongoClient.connect(url, function(err, db) {
	  if (err) throw err;
	  db.collection("users").insertOne(userDetails, function(err, res) {
	    if (err) throw err;
	    console.log("1 record inserted");
	    db.close();
	  });
	});
	//collection.insert(userDetails);
	res.send('{"status":"created"}');
});

router.get('/users',  function(req, res) {
	//var url = "mongodb://localhost:27017/mydb";
	MongoClient.connect(url, function(err, db) {
	  if (err) throw err;
	  db.collection("users").find({}).toArray(function(err, result) {
		if (err) throw err;
			console.log(result);
			res.send(JSON.stringify(result));
			db.close();
		}); 
	});
});

router.delete('/user', function(req, res) {
	MongoClient.connect(url, function(err, db) {
	  if (err) throw err;
	  db.collection("users").drop(function(err, delOK) {
	    if (err) throw err;
	    if (delOK) console.log("Table deleted");
	    db.close();
	  });
	});
});

router.delete('/user/:username', function(req, res) {
    	var  username = req.params.username;
	MongoClient.connect(url, function(err, db) {
	  if (err) throw err;
	  var myquery = { name: username };
		console.log(myquery);
	  db.collection("users").deleteOne(myquery, function(err, obj) {
	    if (err) throw err;
	    console.log("1 document deleted");
	    db.close();
	  });
	});
  	res.send('{"status":"deleted"}');
});

module.exports = router;
