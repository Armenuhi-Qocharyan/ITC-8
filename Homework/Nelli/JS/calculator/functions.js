function  MyFunction(first , second) {
    var length = arguments.length;
    for (var i = 0;  i < length ; ++i) {
        console.log(arguments[i] + " type : " + typeof arguments[i]);
    }
}

/*function  MyFunction(first , second, a ,b , c) {
    var length = arguments.length;
    for (var i = 0;  i < length ; ++i) {
        console.log(arguments[i] + " type ++++ " + typeof arguments[i]);
    }
} */


MyFunction("dddd", "5", 1 , 2 , 3);


