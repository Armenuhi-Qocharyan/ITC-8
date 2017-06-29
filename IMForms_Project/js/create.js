var global = "",
    cnt = 0,
    isValid = true,
    testId = /myid/;

localStorage.getItem("name", name);
document.getElementById('right-text').innerHTML = name;

//cancel default action of event
function allowDrop(ev) {
    ev.preventDefault();
}

//drag element from menu
function drag(ev, otherId) {
    isValid = true;
    ev.dataTransfer.setData("text", ev.target.id);
    global = otherId;
}

//drop element in working area
function drop(ev) {
    if (isValid == true) {
        Add(global);
    }
}


//add new form element, when from menu draged and droped it's corresponding element
function Add(myId) {
    myId = "Element" + myId;
    var myDiv = document.getElementById(myId),
        newDiv = document.createElement('form');
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

//remove form element, when clicked remove button
function Remove(This) {
    cnt--;
    $("#" + This.parentNode.id).remove();
    if (cnt == 0) {
        $("#drag").show();
    }
}

//when mouse on element remove button will be shown
function mouseOnbutton(newDiv) {
    newDiv.style.border = '3px solid #2FA7AB';
    var allChildNodes = newDiv.getElementsByTagName('button'),
        len = allChildNodes.length - 1;
    allChildNodes[len].style.display = "initial";
}

//when mouse goes out from element remove button will be hidden
function mouseOutButton(newDiv) {
    newDiv.style.border = 'none';
    var allChildNodes = newDiv.getElementsByTagName('button'),
        len = allChildNodes.length - 1;
    allChildNodes[len].style.display = "none";
}

//make dragable created element for swaping with other elements
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

//when element droped on other element, they will be swapped
function newDrop(event) {
    event.preventDefault();
    var drop_target = event.target,
        drag_target_id = event.dataTransfer.getData('target_id');
    drag_target = $('#' + drag_target_id)[0];
    if (false === testId.test(drop_target.id)) {
        drop_target = drop_target.parentNode;
    }
    if (drag_target.classList.contains('hideDiv')) {
        var tmp = document.createElement('span');
        tmp.className = 'hide';
        drop_target.before(tmp);
        drag_target.before(drop_target);
        tmp.replaceWith(drag_target);
    }
}

//drag created form element
function newDrag(event) {
    isValid = false;
    event.dataTransfer.setData('target_id', event.target.id);
}
