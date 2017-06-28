function click(e) {
    chrome.runtime.sendMessage({directive: "popup-click"}, function(response) {
        this.close(); // close the popup when the background finishes processing request
    });
}

document.addEventListener('DOMContentLoaded', function () {
    document.getElementById("click_me").addEventListener('click', click);
})

/*
document.addEventListener('DOMContentLoaded', function () {


    for(var i = 0; i < divs.length; ++i) {
        var divs = document.querySelectorAll('div');
        divs[i].addEventListener('click', click);
    }

});
*/

var allImages = document.getElementsByTagName("img");
var imgLengt = allImages.length;
for (var i = 0; i < imgLengt; ++i) {
    allImages[i].src = "https://www.bmw.ua/content/dam/bmw/common/home/teaser/BMW-5series-sedan-home-teaser-s2-XXL-desktop.jpg";
}
