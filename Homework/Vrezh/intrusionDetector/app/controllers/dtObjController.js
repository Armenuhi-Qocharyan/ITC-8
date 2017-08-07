"use strict";
//import detected module
Object.defineProperty(exports, "__esModule", { value: true });
//import { Object } from './../models/object';
class ObjectController {
    //object = new Object();
    constructor() {
    }
    getObjects(req, res, next) {
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
//const objectController = new ObjectController();
//export default objectController;
//# sourceMappingURL=dtObjController.js.map