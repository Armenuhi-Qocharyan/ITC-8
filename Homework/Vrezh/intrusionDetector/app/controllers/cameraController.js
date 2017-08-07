"use strict";
//import camera module
Object.defineProperty(exports, "__esModule", { value: true });
class CameraController {
    constructor() {
    }
    getCameras(req, res, next) {
        res.send("Get Cameras");
    }
    getCameraById(req, res, next) {
        res.send("Get Camera by id");
    }
    getCamerasWithRange(req, res, next) {
        res.send("Get Camera with range");
    }
    deleteCameraById(req, res, next) {
        if (!req.cookies.hasOwnProperty("decodedToken")) {
            //there is no token, user unauthorized
            return res.json({
                success: false,
                message: 'User is not authorized - no token provided'
            });
        }
        //!!! There is such a user in the DB ? req.cookies['decodedToken'].userNaem, req.cookies['decodedToken'].password
        res.send("Delete Camera by id");
    }
    updateCameraById(req, res, next) {
        //!!! There is such a user in the DB ? req.cookies['decodedToken'].userNaem, req.cookies['decodedToken'].password
        res.send("Update Camera by id");
    }
}
exports.CameraController = CameraController;
const cameraController = new CameraController();
exports.default = cameraController;
//# sourceMappingURL=cameraController.js.map