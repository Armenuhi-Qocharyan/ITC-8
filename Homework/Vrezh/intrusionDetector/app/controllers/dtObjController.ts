//import detected module

import {Request, Response, NextFunction} from 'express';
//import { Object } from './../models/object';

export class ObjectController {
   
    //object = new Object();
    constructor() {
    }
    
    public getObjects(req: Request, res: Response, next: NextFunction) {
 /*       try { 
            this.object.getObjects()
            
        } catch (err) {
            res.send(err);
        }
        
        /*    .then(function(data) {
                res.send("Get all Objects");
            })
            .catch(function(err) {
                res.send(err);
            });*/
        
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

//const objectController = new ObjectController();
//export default objectController;
