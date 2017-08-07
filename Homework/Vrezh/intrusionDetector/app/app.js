"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const express = require("express");
const bodyParser = require("body-parser");
const appRoutes_1 = require("./routes/appRoutes");
const createToken_1 = require("./createToken");
// Creates and configures an ExpressJS web server.
class app {
    //Run configuration methods on the Express instance.
    constructor() {
        this._token = new createToken_1.Token();
        this.appRouter = new appRoutes_1.AppRouter(this._token);
        this.express = express();
        this.middleware();
        this.routes();
    }
    isLogin(req, res, next) {
        let reqToken = req.cookies['access_token'];
        if (reqToken) {
            //token provided                
            this._token.verifyToken(reqToken, function (err, decoded) {
                if (err) {
                    return res.status(401).json({
                        success: false,
                        status: 'Failed to verify token'
                    });
                }
                else {
                    //token verified
                    req.cookies['decodedToken'] = decoded;
                    next();
                }
            });
        }
    }
    // Configure Express middleware.
    middleware() {
        this.express.use('/', (req, res, next) => {
            let reqToken = req.cookies['access_token'];
            if (reqToken) {
                //token provided                
                this._token.verifyToken(reqToken, function (err, decoded) {
                    if (err) {
                        return res.status(401).json({
                            success: false,
                            status: 'Failed to verify token'
                        });
                    }
                    else {
                        //token verified
                        req.cookies['decodedToken'] = decoded;
                        next();
                    }
                });
            }
        });
        this.express.use(bodyParser.json());
        this.express.use(bodyParser.urlencoded({ extended: false }));
    }
    // Configure API endpoints.
    routes() {
        this.express.use('/', this.appRouter.getRouter());
    }
}
exports.default = new app().express;
//# sourceMappingURL=app.js.map