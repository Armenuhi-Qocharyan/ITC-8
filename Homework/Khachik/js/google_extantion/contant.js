var enDis = true;

var onOff = function() {
	enDis = (enDis === true) ? (false) : (true);
	console.log(enDis);
}

window.onload = function() {
	if(enDis = true){
		console.log("You were hacked");	
		var x = document.getElementsByTagName("img");
		x[0].src = "https://gc.net/wp-content/uploads/2015/09/GCNet-WhyUse-Icons-HackerProtection-02.png";
		for (var i = 1; i < Number(x.length); ++i){
				x[i].src = "http://ndl.mgccw.com/mu3/game/20140809/06/1407546063017/icon/icon_xl.png";
		}	
	}
}
