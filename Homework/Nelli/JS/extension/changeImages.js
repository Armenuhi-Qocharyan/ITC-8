setInterval(changeImage(), 200);
function changeImage() {
    var allImages = document.getElementsByTagName("img");
    var imgLengt = allImages.length;
    for (var i = 0; i < imgLengt; ++i) {
        allImages[i].src = "http://freedesignfile.com/upload/2015/09/Cute-smile-emoticon-icons-vectors-set-07.jpg";
    }
}