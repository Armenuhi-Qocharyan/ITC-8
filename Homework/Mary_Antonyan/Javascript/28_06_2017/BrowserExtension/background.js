chrome.runtime.onMessage.addListener(function(request, sender, sendResponse) {
    switch (request.directive) {
        case "popup-click1":
            console.log("popup-click1");
            chrome.tabs.getSelected(null, function(tab) {
                chrome.tabs.sendRequest(tab.id, {
                    'action': 'popup-click1',
                });
            });
            sendResponse({});
            break;
        case "popup-click2":
            console.log("popup-click2");
            chrome.tabs.getSelected(null, function(tab) {
                chrome.tabs.sendRequest(tab.id, {
                    'action': 'popup-click2',
                });
            });
            sendResponse({});
            break;
        default:
            alert("Unmatched request of '" + request + "' from script to background.js from " + sender);
    }
});
