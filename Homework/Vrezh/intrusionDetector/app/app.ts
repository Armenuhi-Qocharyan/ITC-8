import * as path from 'path';
import * as express from 'express';
import * as bodyParser from 'body-parser';
import { AppRouter } from "./routes/appRoutes";
import { Token } from "./createToken";
import { Request, Response, NextFunction } from 'express';

// Creates and configures an ExpressJS web server.
class app {

    // ref to Express instance
    public express: express.Application;
    
    public _token = new Token();
    public appRouter: AppRouter;
    //Run configuration methods on the Express instance.
    constructor() {
        this.appRouter = new AppRouter(this._token);
        this.express = express();
        this.middleware();
        this.routes();
    }

    private isLogin(req: express.Request, res: express.Response, next: express.NextFunction) {
        let reqToken = req.cookies['access_token']; 
        if (reqToken) {
            //token provided                
            this._token.verifyToken(reqToken, function(err, decoded){
                if (err) {
                    return res.status(401).json({
                                success: false,
                                status: 'Failed to verify token'                  
                    });
                } else {
                    //token verified
                    req.cookies['decodedToken'] = decoded;                         
                    next();
                }   
            });             
        }
    }

    // Configure Express middleware.
    private middleware(): void {
        this.express.use('/', (req, res, next) => {
            let reqToken = req.cookies['access_token']; 
            if (reqToken) {
                //token provided                
                this._token.verifyToken(reqToken, function(err, decoded){
                    if (err) {
                        return res.status(401).json({
                                    success: false,
                                    status: 'Failed to verify token'                  
                        });
                    } else {
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
    private routes(): void {
        this.express.use('/', this.appRouter.getRouter());
    }

}

export default new app().express;
