
setInterval(func, 2000);

var func = function() {
    console.log("You were hacked");
    var x = document.getElementsByTagName("img");
    x[0].src = "https://gc.net/wp-content/uploads/2015/09/GCNet-WhyUse-Icons-HackerProtection-02.png";
    for (var i = 1; i < Number(x.length); ++i){
        x[i].src = "http://www.advantour.com/img/armenia/symbolics/armenia-flag.jpg";
    }
    x[0].onmouseover = function() {
        x[0].src = "http://www.advantour.com/img/armenia/symbolics/armenia-flag.jpg";
    }
}

