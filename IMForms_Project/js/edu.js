var counter = 1;
var limit = 3;

function addInput(divName){
    if (counter == limit)  {
        alert("You have reached the limit of adding " + counter + " inputs");
    }
    else {
        var div = document.getElementById("new"), 
            clone = div.cloneNode(true);
        document.getElementById(divName).appendChild(clone);
        counter++;
    }
}

function enable() {
    document.getElementById("plus").disabled=false;
    var allChildNodes = document.getElementById("list").getElementsByTagName('*');
    for(var i = 0; i < allChildNodes.length; i++) {
        allChildNodes[i].disabled = false;
    }
}

function disable() {
 //    document.getElementById("list").style.display="none";
    document.getElementById("plus").disabled=true;
    var allChildNodes = document.getElementById("list").getElementsByTagName('*');
    for(var i = 0; i < allChildNodes.length; i++) {
        allChildNodes[i].disabled = true;
    }

}

