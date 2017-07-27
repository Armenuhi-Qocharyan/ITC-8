var express = require('express'),
    path = require('path'),
    favicon = require('serve-favicon'),
    logger = require('morgan'),
    cookieParser = require('cookie-parser'),
    bodyParser = require('body-parser'),
    http = require ('http'),         // For serving a basic web page.
    mongoose = require ("mongoose"), // The reason for this demo.
    users = require('./routes/users'),
    app = express(),
    uristring =
        process.env.MONGOLAB_URI ||
        process.env.MONGOHQ_URL ||
        'mongodb://localhost/nodeDb';

/*
mongoose.connect(uristring, function (err, res) {
    if (err) {
        console.log ('ERROR connecting to: ' + uristring + '. ' + err);

    } else {
        console.log ('Succeeded connected to: ' + uristring);
    }
});
*/
mongoose.connect(uristring, { auto_reconnect: true }); 

/*
mongoose.connection.on('connected', function () {  
  console.log('Mongoose default connection open to ' + uristring);
}); 

// If the connection throws an error
mongoose.connection.on('error',function (err) {  
  console.log('Mongoose default connection error: ' + err);
}); 

// When the connection is disconnected
mongoose.connection.on('disconnected', function () {  
  console.log('Mongoose default connection disconnected'); 
});
*/


var db = mongoose.connection;

  db.on('connecting', function() {
    console.log('connecting to MongoDB...');
  });

  db.on('error', function(error) {
    console.error('Error in MongoDb connection: ' + error);
    mongoose.disconnect();
  });
  db.on('connected', function() {
    console.log('MongoDB connected!');
  });
  db.once('open', function() {
    console.log('MongoDB connection opened!');
  });
  db.on('reconnected', function () {
    console.log('MongoDB reconnected!');
  });
  db.on('disconnected', function() {
    console.log('MongoDB disconnected!');
    mongoose.connect(uristring, {server:{auto_reconnect:true}});
  });
  mongoose.connect(uristring, {server:{auto_reconnect:true}});



app.use(logger('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
    extended: false
}));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));
app.use('/', users);

// catch 404 and forward to error handler
app.use(function(req, res, next) {
    res.status(404);
    res.send({ error: 'Not found' });
    return;
});

// error handler
app.use(function(err, req, res, next) {
    // render the error page
    res.status(err.status || 500);
    next(err)
*/

  if (req.xhr) {
    res.status(500).send({ error: 'Something failed!' })
  } else {
    next(err)
  }


});


module.exports = app;


