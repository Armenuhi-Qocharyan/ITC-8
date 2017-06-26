
var cl = function() {
    var a = {key1: 10};
    var b = Object.assign({}, a);

    alert(a.key1);
    alert(b.key1);

    a.key1 = 20;

    alert(b.key1);
    b.key1 = 30;
    alert(a.key1);
}
