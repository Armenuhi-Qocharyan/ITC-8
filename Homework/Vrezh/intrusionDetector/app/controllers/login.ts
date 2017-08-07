//import user module
import { Request, Response, NextFunction } from 'express';
import { Token } from './../createToken';

export class LoginController {
    private _token: Token;
    constructor(private token: Token) {
        this._token = token;
    }
    
    public login(req: Request, res: Response, next: NextFunction) {
        //let authData = this._users.authUser(req.body.userName, req.body.password);
        //if user exist
        let a = true;
        if ( a ) {      
            let createdToken=this._token.createToken(req.body.userName, req.body.userName);
            console.log(createdToken);
            //!!! save on DB for current user
            res.cookie('access_token', createdToken).status(200).json({
                success: true,
                status: "User authenticated...",
                token: 'bivsi_token'
            });                          
        } else {
            res.status(401).json({
                success: false,
                status: "User NOT authenticated..."           
            });  
        }   
    }   
}

//const loginController = new LoginController();
//export default loginController;
