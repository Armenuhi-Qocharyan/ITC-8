var express = require('express');
var router = express.Router();

/* GET users listing. */
router.get('/', function(req, res, next) {
  res.send('respond with a resource');
});

module.exports = router;

module.exports = function(app) {
    var myController = require('../controllers/myController');
    app.get('/users', myController.getUsers);
    app.post('/users', myController.addUsers);
    //app.delete('/user/:username', myController.deleteUser);
    //app.delete('/user', myController.deleteAllUsers);
}
