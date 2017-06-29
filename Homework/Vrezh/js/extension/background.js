chrome.runtime.onMessage.addListener(
    function(request, sender, sendResponse) {
        switch (request.directive) {
            case "popup-click":
                chrome.tabs.query({active: true, currentWindow: true}, function(tabs) {
                    chrome.tabs.sendMessage(tabs[0].id, {greeting: "change_images"});
                });
                break;

            case "reload":
                chrome.tabs.query({active: true, currentWindow: true}, function(tabs) {
                    chrome.tabs.sendMessage(tabs[0].id, {greeting: "reload"});
                });
                break;

            default:
                alert("Unmatched request of '" + request + "' from script to background.js from " + sender);
        }
    }
);