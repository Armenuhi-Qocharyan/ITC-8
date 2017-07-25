var express = require('express'),
    router = express.Router(),
    myController = require('../controllers/myController');

router.get('/users', myController.getUsers);
router.post('/users', myController.addUser);
router.delete('/user/:username', myController.deleteUser);
router.delete('/user', myController.deleteAllUsers);


module.exports = router;


