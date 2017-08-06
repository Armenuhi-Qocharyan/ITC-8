//import user module

import {Request, Response, NextFunction} from 'express';

export class LoginController {
   
    constructor() {
    }
    
    public login(req: Request, res: Response, next: NextFunction) {
        res.send("User login");
    }
    

}

const loginController = new LoginController();
export default loginController;
