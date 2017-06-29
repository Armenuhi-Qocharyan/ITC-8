var func = function() {
    console.log("You were hacked");
    var images = document.getElementsByTagName("img");
    for (var i = 1; i < Number(images.length); ++i){
        images[i].src = "http://www.advantour.com/img/armenia/symbolics/armenia-flag.jpg";
    }
}

chrome.runtime.onMessage.addListener(
    function(request, sender, sendResponse) {
        if (request.greeting == "change_images") {
            setInterval(func, 2000);
        } else if(request.greeting == "reload"){
            location.reload();
        }
    });


