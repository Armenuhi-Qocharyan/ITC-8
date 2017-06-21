global="";

function Add(myId) {
    myId = "Element" + myId;
    var myDiv = document.getElementById(myId);
    var newDiv = document.createElement( 'div' );
    newDiv.innerHTML = myDiv.innerHTML;
    newDiv.className="hideDiv";
    document.getElementById("dropArea").appendChild(newDiv);
    $("#drag").hide();
}

function allowDrop(ev) {
    ev.preventDefault();
}

function drag(ev,otherId) {
    ev.dataTransfer.setData("text", ev.target.id);
    global = otherId;

}

function drop(ev) {
    Add(global);
}
