cnt = 0;
function Build() {
    for(var i =0; i < ElementArray.length;)

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