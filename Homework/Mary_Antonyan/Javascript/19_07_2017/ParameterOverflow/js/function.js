function myFunction(arg1, arg2, arg3, arg4) {
    var args = arguments;
    console.log("All arguments passed to function:");
    for (i = 0, len = args.length; i < len; ++i) {
        console.log(args[i]);
    }

    console.log("\nArguments available in function:");
    console.log(arg1);
    console.log(arg2);
    console.log(arg3);
    console.log(arg4);
}
