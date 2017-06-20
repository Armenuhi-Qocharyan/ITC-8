/**
 * Created by student on 6/20/17.
 */
count = 0;
var generate = function () {
    text.innerHTML = Math.floor(Math.random() * 100);
    count++;
    if (count > 5) {
        btn.removeEventListener("click", generate);
    }
}

var btn = document.getElementById("btn");
var text = document.getElementById("text");

btn.addEventListener("click", generate);
