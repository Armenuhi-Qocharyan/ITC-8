var express = require('express');
var router = express.Router();
var myCtrl = require('../api/controllers/myController');
/* GET users listing. */
router.get('/', myCtrl.getUsers);

module.exports = router;
