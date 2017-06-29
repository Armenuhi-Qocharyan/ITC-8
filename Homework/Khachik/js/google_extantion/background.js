chrome.runtime.onMessage.addListener(
        function(request, sender, sendResponse) {
            switch (request.select) {
                case "change": 
                    chrome.tabs.query({
                        active: true,
                    currentWindow: true
                    }, function (tabs) {
                        chrome.tabs.sendMessage(
                            tabs[0].id,
                            {subject: 'change'},

                            );
                    });
                    break;
                case "cancel":
                    chrome.tabs.query({
                        active: true,
                        currentWindow: true
                    }, function (tabs) {
                        chrome.tabs.sendMessage(
                            tabs[0].id,
                            {subject: 'cancel'},

                            );
                    });
                    break;
                case "original":
                    chrome.tabs.query({
                        active: true,
                        currentWindow: true
                    }, function (tabs) {
                        chrome.tabs.sendMessage(
                            tabs[0].id,
                            {subject: 'original'},

                            );
                    });
                    break;



            }

});