function clickHandler1(e) {
    console.log("clickHandler1");
    chrome.runtime.sendMessage({directive: "popup-click1"}, function(response) {
        this.close();
    });
}

function clickHandler2(e) {
    console.log("clickHandler2");
    chrome.runtime.sendMessage({directive: "popup-click2"}, function(response) {
        this.close();
    });
}

document.addEventListener('DOMContentLoaded', function () {
    console.log("eventListener");
    document.getElementById("click-me1").addEventListener('click', clickHandler1);
    document.getElementById("click-me2").addEventListener('click', clickHandler2);
})
