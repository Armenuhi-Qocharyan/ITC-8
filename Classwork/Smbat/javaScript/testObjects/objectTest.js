
var a = {key1:"value1",key2:"value2",key3:"value3"};
b = a;
b = {key1:"other"}
console.log(b.key1)


var obj1 = { k1: 1 };
var obj2 = { k2: 2 };
var obj3 = { k3: 3 };

var obj = Object.assign({},obj1,obj2,obj3);

console.log(obj);
console.log(obj1);

vegeteable.prototype.age = "7year";
vegeteable.prototype.size = "vegSize";

function vegeteable() {
    this.color = "green";
    this.whatre = "50%"
}

orange.prototype = new vegeteable();
orange.prototype.color = "orangeProtot"
 
function orange () {
    this.size = 20;
}

var or = new orange();

console.log(or.size, or.color, or.age, or.whatre);


