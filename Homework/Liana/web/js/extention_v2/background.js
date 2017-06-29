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
                case "background":
                    chrome.tabs.query({
                        active: true,
                        currentWindow: true
                    }, function (tabs) {
                        chrome.tabs.sendMessage(
                            tabs[0].id,
                            {subject: 'background'},

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
