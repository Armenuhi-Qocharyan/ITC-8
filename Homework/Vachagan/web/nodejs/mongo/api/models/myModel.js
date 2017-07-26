console.log("model works");
var mongoose = require ("mongoose"); // The reason for this demo.


var userSchema = new mongoose.Schema({
    name: {
        first: String,
        last: { type: String, trim: true }
    },
    age: { type: Number, min: 0 }
});

var MyModel = mongoose.model('Users', userSchema);

module.exports = MyModel;
