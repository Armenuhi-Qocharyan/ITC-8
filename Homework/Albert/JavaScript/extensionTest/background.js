chrome.runtime.onMessage.addListener(
    function(request, sender, sendResponse) {
        switch (request.directive) {
            case "changeBack":
                chrome.tabs.executeScript(null, {
                    file: "contentscript.js",
                    allFrames: true
                });
                sendResponse({});
                break;
            case "changeImg":
                chrome.tabs.executeScript(null, {
                    file: "changeImages.js",
                    allFrames: true
                });
                sendResponse({});
                break;
            case "refresh":
                chrome.tabs.executeScript(null, {
                    file: "refresh.js",
                    allFrames: true
                });
                sendResponse({});
                break;
            default:
                alert("Unmatched request of '" + request + "' from script to background.js from " + sender);
        }
    }
);

