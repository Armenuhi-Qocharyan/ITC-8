//import detected module

import {Request, Response, NextFunction} from 'express';

export class ObjectController {
   
    constructor() {
    }
    
    public getObjects(req: Request, res: Response, next: NextFunction) {
        res.send("Get all Objects");
    }

    public getObjectById(req: Request, res: Response, next: NextFunction) {
        res.send("Get Object by id");
    }
    
    public mergeObjects(req: Request, res: Response, next: NextFunction) {    
        res.send("Merge objects");
    }

    public deleteObjectById(req: Request, res: Response, next: NextFunction) {
        res.send("Delete Object by id");
    }
    

}

const objectController = new ObjectController();
export default objectController;
