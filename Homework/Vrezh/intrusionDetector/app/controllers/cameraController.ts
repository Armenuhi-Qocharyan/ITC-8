//import camera module

import {Request, Response, NextFunction} from 'express';

export class CameraController {
   
    constructor() {
    }
    
    public getCameras(req: Request, res: Response, next: NextFunction) {
        res.send("Get Cameras");
    }

    public getCameraById(req: Request, res: Response, next: NextFunction) {
        res.send("Get Camera by id");
    }
    
    public getCamerasWithRange(req: Request, res: Response, next: NextFunction) {    
        res.send("Get Camera with range");
    }

    public deleteCameraById(req: Request, res: Response, next: NextFunction) {
        res.send("Delete Camera by id");
    }

    public updateCameraById(req: Request, res: Response, next: NextFunction) {
        res.send("Update Camera by id");
    }
    

}

const cameraController = new CameraController();
export default cameraController;
