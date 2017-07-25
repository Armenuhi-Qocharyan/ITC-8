var express = require('express');
var router = express.Router();
var myController = require('../controllers/myController');

router.post('/users',myController.addUser);
router.get('/users', myController.getUsers);
router.delete('/user', myController.deleteAllUsers);
router.delete('/user/:username', myController.deleteUser);


module.exports = router;
