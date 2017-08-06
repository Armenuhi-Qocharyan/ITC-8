"use strict";
const express = require('express');
const bodyParser = require('body-parser');
const appRoutes_1 = require("./routes/appRoutes");
// Creates and configures an ExpressJS web server.
class app {
    //Run configuration methods on the Express instance.
    constructor() {
        this.express = express();
        this.middleware();
        this.routes();
    }
    // Configure Express middleware.
    middleware() {
        this.express.use(bodyParser.json());
        this.express.use(bodyParser.urlencoded({ extended: false }));
    }
    // Configure API endpoints.
    routes() {
        this.express.use('/', appRoutes_1.default);
    }
}
Object.defineProperty(exports, "__esModule", { value: true });
module.exports = new app().express;
