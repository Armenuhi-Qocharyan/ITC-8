function clickHandler(e) {

    chrome.runtime.sendMessage({select: "change"}, function(response) {
        this.close(); // close the popup when the background finishes processing request
    });
}

function cancel(e) {
    chrome.runtime.sendMessage({select: "cancel"}, function(response) {
        this.close(); // close the popup when the background finishes processing request
    });
}

document.addEventListener('DOMContentLoaded', function () {

    document.getElementById('click-me').addEventListener('click', clickHandler);
    document.getElementById('back').addEventListener('click', cancel);
})