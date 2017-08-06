import { CameraController } from './../controllers/cameraController';
import { Router } from 'express';
import { ObjectController } from './../controllers/dtObjController'
import { LoginController } from './../controllers/login'
 
export class AppRouter {
    router: Router;
    cameraController = new CameraController();
    objectController = new ObjectController;
    loginController = new LoginController;
    
    constructor() {
        this.router = Router();
        this.init();
    }

    
    init() {
        this.router.get('/camera', this.cameraController.getCameras);
        this.router.get('/camera', this.cameraController.getCamerasWithRange);
        this.router.get('/camera/:id', this.cameraController.getCameraById);   
        this.router.delete('/camera/:id', this.cameraController.deleteCameraById);   
        this.router.put('/camera/:id', this.cameraController.updateCameraById);   

        this.router.get('/object', this.objectController.getObjects);
        this.router.get('/object/:id', this.objectController.getObjectById);   
        this.router.delete('/object/:id', this.objectController.deleteObjectById);   
        this.router.put('/object', this.objectController.mergeObjects);  
        
        this.router.post('/login', this.loginController.login);
    }

}

const routes = new AppRouter();

export default routes.router;

