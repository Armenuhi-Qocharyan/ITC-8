var Finder = require('fs-finder');
var process = require('process');
var colors = require('colors/safe');

console.log(colors.green("Process ID: ", process.pid));
args = process.argv.slice(2);
if (args.length != 2) {
    console.log(colors.red("Invalid Arguments"));
} else {
var files = Finder.from(args[0]).findFiles(args[1]);
    for (var i in files) {
        console.log(colors.blue(files[i]));
    }
    console.log(colors.green("Script runtime: ", process.uptime()));
    console.log(colors.green("Process memory usage", process.memoryUsage().heapUsed));
}
