var cnt = 0;

function saveCv() {
    var title = localStorage.getItem("title");
    localStorage.clear();
    localStorage.setItem("cvTitle",title);
    var drop = document.getElementById("dropArea");
    for(var i = 0;i <= drop.childElementCount ;++i) {
        localStorage.setItem("id"+i,"cv" + drop.childNodes[i].name);
    }
}

function Build() {
    document.getElementById("cvTitle").innerHTML = localStorage.getItem("cvTitle");
    for(var i = 1;i < localStorage.length;++i) {
        var name = localStorage.getItem("id"+i);
        var myDiv = document.getElementById(name);
        var newDiv = document.createElement( 'div' );
        newDiv.innerHTML = myDiv.innerHTML;
        newDiv.setAttribute("id","cvid"+ cnt);
        newDiv.setAttribute("class","cvDiv");
        newDiv.name = name;
        document.getElementById("cvArea").appendChild(newDiv);
        cnt++;
    }
    localStorage.clear();
}

