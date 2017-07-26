var controller = require("./../controller/appController");

module.exports = function(app) {
    app.get("/users", controller.getUsers);
    app.delete("/users/:userId", controller.deleteUser);
    app.post("/user", controller.addUser);
};




