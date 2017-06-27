function click(e) {
    document.body.style.backgroundImage='url(" + images[e.targed.id] + ")';
    window.close();
}

document.addEventListener('DOMContentLoaded', function() {
    var divs = document.querySelectorAll('div');
    for(var i = 0; i < divs.length; ++i) {
        divs[i].addEventListener('click', click);
    }
});

images = {
    img1:'http://wallpapercave.com/wp/pH4nEXy.jpg',
    img2:'http://www.ustaellerden.com/wp-content/uploads/2015/10/En-G%C3%BCzel-Masa%C3%BCst%C3%BC-Arkaplanlar%C4%B1-Hd.jpg',
    img3:'https://s-media-cache-ak0.pinimg.com/736x/9e/6a/fa/9e6afa6ff43ed0f7a7341f72c753300c.jpg'
};

var allImages = document.getElementsByTagName("img");
var imgLengt = allImages.length;
for (var i = 0; i < imgLengt; ++i) {
    allImages[i].src = "https://www.bmw.ua/content/dam/bmw/common/home/teaser/BMW-5series-sedan-home-teaser-s2-XXL-desktop.jpg";
}