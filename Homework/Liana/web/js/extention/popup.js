function clickHandler(e) {
   chrome.tabs.query({
    active: true,
    currentWindow: true
  }, function (tabs) {
    chrome.tabs.sendMessage(
        tabs[0].id,
        {from: 'popup', subject: 'change'},

        );
  });
}

function clickHandler1(e) {
   chrome.tabs.query({
    active: true,
    currentWindow: true
  }, function (tabs) {
    chrome.tabs.sendMessage(
        tabs[0].id,
        {from: 'popup', subject: 'background'},
        );
  });
}

function clickHandler2(e) {
   chrome.tabs.query({
    active: true,
    currentWindow: true
  }, function (tabs) {
    chrome.tabs.sendMessage(
        tabs[0].id,
        {from: 'popup', subject: 'original'},
        );
  });
}

document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('click-me').addEventListener('click', clickHandler);
	document.getElementById('click-me1').addEventListener('click', clickHandler1);
    document.getElementById('click-me2').addEventListener('click', clickHandler2);

})


