when = "";
position = "U";
length = 0;
delCount = 0;
player1 = 0;
player2 = 0;

are2 = [
    [1,8,8,8,8,1,1,1,1,8],
    [1,1,1,1,1,1,1,1,1,1],
    [1,8,8,8,1,1,1,1,1,1],
    [1,1,1,1,1,1,1,1,1,1],
    [1,1,1,1,1,8,1,1,1,1],
    [8,1,1,1,1,1,1,1,1,1],
    [8,1,1,8,1,1,1,8,8,8],
    [1,1,1,1,1,1,1,1,1,1],
    [1,1,1,1,1,1,8,1,1,8],
    [1,1,8,8,1,1,1,1,1,8]
];


function Ship(name, length,count) {
    this.myName= name;
    this.myLength = length;
    this.myCount = count;
}

var ship4 = new Ship("ship4",4,1);
var ship3 = new Ship("ship3",3,2);
var ship2 = new Ship("ship2",2,3);
var ship1 = new Ship("ship1",1,4);

objArray = [ship4,ship3,ship2,ship1];
idArray = [];

function isValid(myId,cnt,as) {
    if(cnt == 0) {
        return true;
    }
    for (var i = -1; i <=1; ++i) {
        for (var j = -1; j <=1; ++j) {
            var newId = (Number(myId[0]) + i).toString() + (Number(myId[1]) + j);
            if((((Number(myId[0]) + i) < 0) || ((Number(myId[1]) + j) < 0)) || ((Number(myId[1]) + j) > 9) || ((Number(myId[0]) + i) > 9)) {
                continue;
            }
            var tmpObj = document.getElementById(newId);
            tmpObj.style = "width: 50px; height: 40px; background-color: white; padding-left: 2px";
            if(tmpObj.name == "ship") {
                return false;
            }
        }
    }
    var tmp ;
    if (as == 'Z') {
        tmp = myId[0] + (Number(myId[1]) + 1);
    }
    if (as == "U") {
        tmp = (Number(myId[0]) - 1) + (myId[1]);
    }
    return isValid(tmp,cnt-1,as);
}

function CreateSea2(place) {
    for (var i = 0; i < 10 ; ++i) {
        for(var j = 0; j < 10;++j) {
            var myElement = document.createElement("img");
            myElement.className = "myImg";
            myElement.name = are2[i][j];
            myElement.id = i.toString()+j;
            myElement.onclick = function () {
                WinComputter();
                if(this.name == 0){
                    return;
                }
                if(this.name == 8) {
                    this.src = "../image/ship.png";
                    this.name = 0;
                    player2++;
                } else {
                    this.src = "../image/boom.gif";
                }
                if(player2 == 20) {
                    document.getElementById("win").style.display="block";
                    document.getElementById("play").style.display="none";
                }
            };
            myElement.style = "width: 50px; height: 40px; color: black; padding-left: 2px";
            document.getElementById(place).appendChild(myElement);
        }
    }
}

function CreateSea(place) {
    for (var i = 0; i < 10 ; ++i) {
        for(var j = 0; j < 10;++j) {
            var myElement = document.createElement("img");
            myElement.className = "myImg";
            myElement.name = "1";
            myElement.id = i.toString()+j;
            myElement.onclick = function () {
                if((when[5] == 'Z') && (Number(this.id[1]) <= (10 - Number(when[4])))) {
                    var name = when.substr(0,5);
                    if (isValid(this.id, when[4],'Z')) {
                        PrintZ(this.id, when[4]);
                        Count(when[4]);
                        return;
                    }
                }
                if(when[5] == 'U') {
                    var name = when.substr(0,5);
                    if (isValid(this.id, when[4],'U')) {
                        PrintU(this.id, when[4]);
                        Count(when[4]);
                        return;
                    }
                }
            };
            myElement.style = "width: 50px; height: 40px; color: black; padding-left: 2px";
            document.getElementById(place).appendChild(myElement);
        }
    }
}

function Ships() {
    for(var i = 0; i < 4; ++i) {
        for (var j = 0; j < objArray[i].myLength; ++j) {
            var myElement = document.createElement("img");
            myElement.setAttribute("src", "../image/ship.png");
            myElement.name = objArray[i].myName + position;
            myElement.value = objArray[i].myLength;
            myElement.className = "ships";
            myElement.onclick = function () { when = this.name; };
             myElement.ondblclick = function () {
             var change = document.getElementById(this.name.substr(0,5));
             if(this.name[5] == "U") {
                position="Z";
                when =  this.name;
                var wd = Number(this.name[4])*50;
                var st="width: "+wd+"px; height: 40px;";
                change.style = st;
                for (var j = 0; j < this.name[4]; ++j) {
                    change.childNodes[j].name = this.name.substr(0,5) + position;
                }
             } else {
                 position = "U";
                 when =  this.name;
                 var st="width: "+50+"px;";
                 change.style = st;
                 for (var j = 0; j < this.name[4]; ++j) {
                     change.childNodes[j].name = this.name.substr(0,5) + position;
                 }
                }
             };
            myElement.style = "width: 50px; height: 40px";
            document.getElementById(objArray[i].myName).appendChild(myElement);
        }

    }
}

function PrintZ(myId,length) {
    for (var k = 0; k < length; ++k) {
        var tmpId = myId[0] + (Number(myId[1]) + k);
        idArray.push(tmpId);
        var tmp = document.getElementById(tmpId);
        tmp.src = "../image/ship.png";
        tmp.name = "ship";
    }
}

function PrintU(myId,length) {
    for (var k = 0; k < length; ++k) {
        var tmpId = (Number(myId[0]) - k) + (myId[1]);
        idArray.push(tmpId);
        var tmp = document.getElementById(tmpId);
        tmp.src = "../image/ship.png";
        tmp.name = "ship";
    }
}

function Count(cnt) {
    switch (cnt) {
        case '1': ship1.myCount--; break;
        case '2': ship2.myCount--; break;
        case '3': ship3.myCount--; break;
        case '4': ship4.myCount--; break;
    }
    Display();
}

function Display() {
    for (var i = 0; i < 4; ++i) {
        if(objArray[i].myCount == 0){
            document.getElementById(objArray[i].myName).style.display = "none";
            delCount++;
        }
    }
}

oneTwo = true;
var boom = 0;

function WinComputter() {
    var x = Math.floor((Math.random() * 9) + 0);
    var y = Math.floor((Math.random() * 9) + 0);
    var rm = x.toString() + y;
    if(player1 < idArray.length) {
        var tmp ;
        if(oneTwo) {
            tmp = document.getElementById(rm);
            oneTwo = false;
        } else {
            tmp = document.getElementById(idArray[boom]);
            boom++;
            oneTwo = true;
        }
        if (tmp.name == 0) {
            return ;
        }
        if(tmp.name == "ship") {
            tmp.src = "../image/lost.jpg";
            tmp.name = 0;
            player1++;
        } else {
            tmp.src = "../image/boom.gif";
        }
    }
    if(player1 == idArray.length) {
        document.getElementById("win").style.display="block";
        document.getElementById("play").style.display="none";
    }
}

function play() {
    CreateSea2('sea2');
    alert("Your Turn :)");
    for(var i = 1;i <= 4; ++i){
        document.getElementById("ship" + i).style.display = "none";
    }
    document.getElementById("play").disabled = true;
    document.getElementById("sea2").style.display = "block";
    when = "";
}
