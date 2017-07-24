var controller = require("./../controller/appController");

module.exports = function(app) {
    app.get("/users", controller.getUsers);
    app.delete("/users/:username", controller.deleteUser);
};




