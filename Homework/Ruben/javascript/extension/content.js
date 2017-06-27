alert("Hello from your Chrome extension!")
var imgs = document.getElementsByTagName("img");
for(var i=0, l=imgs.length;i<l;i++) {
    imgs[i].src = "http://ichef-1.bbci.co.uk/news/976/media/images/83351000/jpg/_83351965_explorer273lincolnshirewoldssouthpicturebynicholassilkstone.jpg";
}

