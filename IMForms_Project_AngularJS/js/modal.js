// Get the modal
var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("save");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
btn.onclick = function() {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

$("#copy-link").click(function(){
    var copyArea = document.getElementById("modal-id");
    copyArea.select();
    document.execCommand('copy');
});

$("#open-new-tab").click(function(){
    var copyArea = document.getElementById("modal-id");
    var url = copyArea.value;
    var win = window.open(url, "Form");
    win.focus();
});
var title=localStorage.getItem("title");
document.getElementById('titleForm').innerHTML = title;
