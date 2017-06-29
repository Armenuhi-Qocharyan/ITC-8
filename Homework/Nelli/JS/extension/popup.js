function click(e) {
    var myMessage = e.target.id;
    chrome.runtime.sendMessage({directive: myMessage}, function(response) {
        this.close();
    });
}

document.addEventListener('DOMContentLoaded', function () {
    var buttons = document.querySelectorAll('button');
    for(var i = 0; i < buttons.length; ++i) {
        buttons[i].addEventListener('click', click);
    }
});



