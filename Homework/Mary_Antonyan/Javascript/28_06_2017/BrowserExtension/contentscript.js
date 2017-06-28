// Listener method
function ListeningMethod(request, sender, callback) {
    console.log("ListeningMethod");
    if (request.action == "popup-click1") {
        console.log("click_1");
        replaceImages("http://cs.pikabu.ru/images/big_size_comm/2013-11_3/1384289628805.jpg"));
    } else if (request.action == "popup-click2") {
        console.log("click_2");
        replaceImages("http://vignette2.wikia.nocookie.net/theamazingworldofgumball/images/7/77/Lol_face.png/revision/latest?cb=20120806023616"));
    }
}

// Add eventListener to button clicks
chrome.extension.onRequest.addListener(ListeningMethod);

// Function to replace all images on page
function replaceImages(url) {    
    console.log("replaceImages");
    document.body.style.backgroundImage = url("http://www.planwallpaper.com/static/images/i-should-buy-a-boat.jpg");
    var images = document.getElementsByTagName('img');

    for (var i = 0, l = images.length; i < l; i++) {
        console.log("Then: ", images[i].src);
        images[i].src = url;
        console.log("Now: ", images[i].src);
    }
}
