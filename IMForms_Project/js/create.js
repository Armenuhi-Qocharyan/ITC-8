global = "";
cnt = 0;
var isValid = true,
    testId = /myid/;

localStorage.getItem("name", name);
document.getElementById('right-text').innerHTML = name;

function newDrop(event) {
    event.preventDefault();
    var drop_target = event.target;
    var drag_target_id = event.dataTransfer.getData('target_id');
    if (false === testId.test(drop_target.id)) {
        drop_target = drop_target.parentNode;
    }
    var drag_target = $('#' + drag_target_id)[0];
    if (drag_target.classList.contains('hideDiv')) {
        var tmp = document.createElement('span');
        tmp.className = 'hide';
        drop_target.before(tmp);
        drag_target.before(drop_target);
        tmp.replaceWith(drag_target);
    }
}

function drag(ev, otherId) {
    isValid = true;
    ev.dataTransfer.setData("text", ev.target.id);
    global = otherId;
}


function newDrag(event) {
    isValid = false;
    event.dataTransfer.setData('target_id', event.target.id);
}

function createDragable(newDiv) {
    newDiv.ondragstart = function(event) {
        newDrag(event);
    };
    newDiv.ondragover = function(event) {
        allowDrop(event);
    };
    newDiv.ondrop = function(event) {
        newDrop(event);
    };
}

function Add(myId) {
    myId = "Element" + myId;
    var myDiv = document.getElementById(myId);
    var newDiv = document.createElement('form');
    newDiv.innerHTML = myDiv.innerHTML;
    newDiv.setAttribute("id", "myid" + cnt);
    newDiv.setAttribute("class", "hideDiv");
    newDiv.name = myId;
    document.getElementById("dropArea").appendChild(newDiv);
    $("#drag").hide();
    cnt++;

    newDiv.onmouseover = function() {
        mouseOnbutton(newDiv);
    };
    newDiv.onmouseleave = function() {

        mouseOutButton(newDiv);
    };
    newDiv.draggable = true;
    createDragable(newDiv);
}

function mouseOnbutton(newDiv) {
    var allChildNodes = newDiv.getElementsByTagName('button');
    var len = allChildNodes.length - 1;
    allChildNodes[len].style.display = "initial";
}


function mouseOutButton(newDiv) {
    var allChildNodes = newDiv.getElementsByTagName('button');
    var len = allChildNodes.length - 1;
    allChildNodes[len].style.display = "none";
}


function Remove(This) {
    cnt--;
    $("#" + This.parentNode.id).remove();
    if (cnt == 0) {
        $("#drag").show();
    }
}

function allowDrop(ev) {
    ev.preventDefault();
}

function drop(ev) {
    if (isValid == true) {
        Add(global);
    }
}