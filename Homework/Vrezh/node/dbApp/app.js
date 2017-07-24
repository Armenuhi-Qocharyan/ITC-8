var express = require('express');
var routes = require('./routes/appRoutes')

var bodyParser = require('body-parser');

var app = express();

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));

routes(app);

app.listen(3000);
module.exports = app;

