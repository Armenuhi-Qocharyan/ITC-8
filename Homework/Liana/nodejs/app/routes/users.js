var express = require('express');
var router = express.Router();
var myController = require('../controllers/myController');

router.get('/users', myController.getUsers);
router.post('/users', myController.addUser);
router.delete('/user/:username', myController.deleteUser);
router.delete('/user', myController.deleteAllUsers);


module.exports = router;


