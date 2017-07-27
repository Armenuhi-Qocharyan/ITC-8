var mongoose = require ("mongoose"); // The reason for this demo.


var userSchema = new mongoose.Schema({
    name: {
        first: String,
        last: { type: String, trim: true, required: [true, 'name is required'] }
    },
    age: { type: Number, min: [0, 'Incorrect age value'], required: [true, 'age is required']}
});

User = mongoose.model('users', userSchema);

module.exports = User;
