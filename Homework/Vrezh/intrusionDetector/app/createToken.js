"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const uuid = require("node-uuid");
const jToken = require("jsonwebtoken");
class Token {
    constructor() {
        this._secretKey = uuid.v4();
    }
    createToken(user, password) {
        let claims = {
            sub: user,
            iss: 'https://i_issued_this.com',
            password: password
        };
        return jToken.sign(claims, this._secretKey);
    }
    verifyToken(token, callback) {
        return jToken.verify(token, this._secretKey, callback);
    }
}
exports.Token = Token;
let token = new Token();
exports.default = token;
//# sourceMappingURL=createToken.js.map