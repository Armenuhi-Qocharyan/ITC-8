chrome.runtime.onMessage.addListener(function (msg, sender, response) {
    switch (msg.subject) {
        case 'change': 
            setInterval(function(){changeImages();}, 2000);
            break;
        case 'cancel': 
            cancel();
            break;
    } 
});


/*setInterval(func, 1000);
*/
var changeImages = function() {
        console.log("You were hacked");
        var x = document.getElementsByTagName("img");
        x[0].src = "https://gc.net/wp-content/uploads/2015/09/GCNet-WhyUse-Icons-HackerProtection-02.png";
        for (var i = 1; i < Number(x.length); ++i){
            x[i].src = "http://ndl.mgccw.com/mu3/game/20140809/06/1407546063017/icon/icon_xl.png";
        }
        x[0].onmouseover = function() {
            x[0].src = "http://ndl.mgccw.com/mu3/game/20140809/06/1407546063017/icon/icon_xl.png";
        }
        document.body.style.backgroundImage = "url('http://www.spyderonlines.com/images/background_texture_spots_faded_50634.jpg')";
        document.body.style.backgroundSize = "cover";
}

var cancel = function() {
    location.reload();
}

