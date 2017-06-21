/**
 * Created by student on 6/21/17.
 */
var me = function () {
    var a = {key: 10};
    var b = {key1: 20};
    var c = Object.assign(a,b);
    alert(c.key);
    alert(c.key1);
}