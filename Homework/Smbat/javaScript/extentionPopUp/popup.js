function btnClick(e) {
    chrome.runtime.sendMessage({directive: this.id}, function(response) {
        this.close(); // close the popup when the background finishes processing request
    });
}


document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('btn1').addEventListener('click', btnClick);
    document.getElementById('btn2').addEventListener('click', btnClick);

});