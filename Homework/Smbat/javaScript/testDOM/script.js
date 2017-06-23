
var click = function () {
    mytxt.innerHTML = "Click";
}
var over = function () {
    mytxt.innerHTML = "Over";
    mytxt.childNodes[0].nodeValue= "Over print with method child";
}



var btn = document.createElement("button");
document.body.appendChild(btn);

var mytxt = document.createElement("h1");
document.body.appendChild(mytxt);

var windowSize = document.createElement("h1");
document.body.appendChild(windowSize);

btn.innerHTML = "Click Me";
btn.style.color = "black";
btn.style.backgroundColor = "green";
btn.style.fontSize = "200px"
btn.style.padding = "30px"

btn.addEventListener("click", click);
btn.addEventListener("mouseover", over);

