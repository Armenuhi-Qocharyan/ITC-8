"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
class LoginController {
    constructor(token) {
        this.token = token;
        this._token = token;
    }
    login(req, res, next) {
        //let authData = this._users.authUser(req.body.userName, req.body.password);
        //if user exist
        let a = true;
        if (a) {
            let createdToken = this._token.createToken(req.body.userName, req.body.userName);
            console.log(createdToken);
            //!!! save on DB for current user
            res.cookie('access_token', createdToken).status(200).json({
                success: true,
                status: "User authenticated...",
                token: 'bivsi_token'
            });
        }
        else {
            res.status(401).json({
                success: false,
                status: "User NOT authenticated..."
            });
        }
    }
}
exports.LoginController = LoginController;
//const loginController = new LoginController();
//export default loginController;
//# sourceMappingURL=login.js.map