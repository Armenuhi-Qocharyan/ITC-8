function clickHandler(e) {
    chrome.runtime.sendMessage({
        select: "change"});
}

function clickHandler1(e) {
    chrome.runtime.sendMessage({
        select: "background"});

}

function clickHandler2(e) {
    chrome.runtime.sendMessage({
        select: "original"});


}

document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('click-me').addEventListener('click', clickHandler);
    document.getElementById('click-me1').addEventListener('click', clickHandler1);
    document.getElementById('click-me2').addEventListener('click', clickHandler2);

})


