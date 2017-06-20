
var click = function () {
    btn.innerHTML = "Click";
}
var over = function () {
    btn.innerHTML = "Over";
}

var btn = document.createElement("button");
document.body.appendChild(btn);
btn.innerHTML = "Click Me";
btn.style.color = "black";
btn.style.backgroundColor = "green";
btn.style.fontSize = "200px"
btn.style.padding = "30px"

btn.addEventListener("click", click);
btn.addEventListener("mouseover", over);

