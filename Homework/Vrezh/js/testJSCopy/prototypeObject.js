/**
 * Created by student on 6/21/17.
 */
function prot() {
    var A = function () {
        this.size = 10;
    }


    var B = function () {
        this.c = 5;
    }

    B.prototype.c = 5;
    B.prototype.foo = function () {
        return this.size;
    }

    A.prototype = Object.create(B.prototype);
    A.prototype.constructor = A;

    A.prototype.dd = "asgsd";

    A.prototype.sum = function () {
        return this.size + this.c;
    }
    var a = new A;

    alert(a.size);
}