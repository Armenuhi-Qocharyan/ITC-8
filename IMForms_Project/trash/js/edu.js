var counter = 1;
var limit = 3;
/*
function addInput(childId){
    if (counter == limit)  {
        alert("You have reached the limit of adding " + counter + " inputs");
    }
    else {
        var child = document.getElementById(childId), 
            clone = child.cloneNode(false);
		var Parent = child.parentNode.id; 
        document.getElementById(Parent).appendChild(clone);
        counter++;
    }
}
*/
function enable(Id) {
    document.getElementById("plus").disabled = false;
    var allChildNodes = document.getElementById(Id).getElementsByTagName('*');
    for (var i = 0; i < allChildNodes.length; i++) {
        allChildNodes[i].disabled = false;
    }
}

function disable(Id) {
    var allChildNodes = document.getElementById(Id).getElementsByTagName('*');
    for (var i = 0; i < allChildNodes.length; i++) {
        if (allChildNodes[i].id != "radiobtn1" && allChildNodes[i].id != "remove") {
            allChildNodes[i].disabled = true;
        }
    }
}