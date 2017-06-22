global="";
cnt = 0;

function Add(myId) {
    myId = "Element" + myId;
    var myDiv = document.getElementById(myId);
    var newDiv = document.createElement( 'div' );
    newDiv.innerHTML = myDiv.innerHTML;
 //   newDiv.className="hideDiv";
    newDiv.setAttribute("id","myid"+ cnt);
    newDiv.setAttribute("class","hideDiv");
    newDiv.name = myId;
    document.getElementById("dropArea").appendChild(newDiv);
    $("#drag").hide();
    cnt++;
}

function Remove(This) {
    $( "#"+ This.parentNode.id ).remove();
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

