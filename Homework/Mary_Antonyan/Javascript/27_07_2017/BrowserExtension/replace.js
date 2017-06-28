var images = document.getElementsByTagName('img');

for (var i = 0, l = images.length; i < l; i++) {
    console.log("Then: ", images[i].src);
    images[i].src = "http://cs6.pikabu.ru/images/previews_comm/2014-06_4/140292794266.png";
    console.log("Now: ", images[i].src);
}
