setInterval(changeImage(), 200);
function changeImage() {
    var allImages = document.getElementsByTagName("img");
    var imgLengt = allImages.length;
    for (var i = 0; i < imgLengt; ++i) {
        allImages[i].src = "https://www.bmw.ua/content/dam/bmw/common/home/teaser/BMW-5series-sedan-home-teaser-s2-XXL-desktop.jpg";
    }
}