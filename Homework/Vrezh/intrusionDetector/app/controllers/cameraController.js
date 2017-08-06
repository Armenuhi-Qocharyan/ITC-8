//import camera module
"use strict";
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
        res.send("Delete Camera by id");
    }
    updateCameraById(req, res, next) {
        res.send("Update Camera by id");
    }
}
exports.CameraController = CameraController;
const cameraController = new CameraController();
Object.defineProperty(exports, "__esModule", { value: true });
exports.default = cameraController;
