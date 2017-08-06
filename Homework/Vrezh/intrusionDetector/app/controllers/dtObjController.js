//import detected module
"use strict";
class ObjectController {
    constructor() {
    }
    getObjects(req, res, next) {
        res.send("Get all Objects");
    }
    getObjectById(req, res, next) {
        res.send("Get Object by id");
    }
    mergeObjects(req, res, next) {
        res.send("Merge objects");
    }
    deleteObjectById(req, res, next) {
        res.send("Delete Object by id");
    }
}
exports.ObjectController = ObjectController;
const objectController = new ObjectController();
Object.defineProperty(exports, "__esModule", { value: true });
exports.default = objectController;
