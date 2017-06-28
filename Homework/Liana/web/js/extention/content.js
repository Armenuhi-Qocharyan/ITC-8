function change () {
	var images = document.getElementsByTagName("img");

	for (var i = 0; i < images.length; ++i) {
		images[i].src = "http://i.imgur.com/WHZz9D0.png";
	}
	
}

function changeBackground () {
	document.body.style.backgroundImage = "url('http://www.wallhd4.com/wp-content/uploads/2015/03/cute-cartoon-wallpaper-1920x1200-12.jpeg')"
}

function original () {
	window.location.href = "";
}

chrome.runtime.onMessage.addListener(function (msg, sender, response) {
  if ((msg.from === 'popup') && (msg.subject === 'change')) {
		setInterval(function(){change();}, 500);
  } 
  if ((msg.from === 'popup') && (msg.subject === 'background')) {
	changeBackground();
  } 
  if ((msg.from === 'popup') && (msg.subject === 'original')) {
	original();
  } 
});