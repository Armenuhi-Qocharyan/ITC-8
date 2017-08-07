import * as uuid from 'node-uuid';
import * as jToken from 'jsonwebtoken';

export class Token {

    private _secretKey: string;

    constructor(){

        this._secretKey=uuid.v4();

    }   

    public createToken(user: string, password: string): string{
        
        let claims={
            sub: user,
            iss: 'https://i_issued_this.com',
            password: password
        };

        return jToken.sign(claims, this._secretKey);
    } 

    public verifyToken(token: string, callback:any): any{
        return jToken.verify(token, this._secretKey, callback);
    }   
}

let token = new Token();
export default token;
