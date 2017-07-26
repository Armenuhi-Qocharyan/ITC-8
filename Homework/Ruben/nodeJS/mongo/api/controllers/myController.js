var model = require('../models/myModel');

module.exports.getUsers = function(req, res) {
    var User = model.User;
    var chris = new User({
        name: 'Chris',
        username: 'sevilayhaffff',
        password: 'password' 
    });
    chris.save(function(err) {
        if (err) throw err;

        console.log('User saved successfully!');
    });
}
