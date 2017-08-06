//import user module
"use strict";
class LoginController {
    constructor() {
    }
    login(req, res, next) {
        res.send("User login");
    }
}
exports.LoginController = LoginController;
const loginController = new LoginController();
Object.defineProperty(exports, "__esModule", { value: true });
exports.default = loginController;
