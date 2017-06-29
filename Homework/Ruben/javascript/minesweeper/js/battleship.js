function fire(element){
	if(element.id == "zx"){
		element.removeAttribute('id');
	}
	if (element.className=="s1"){
		element.setAttribute("class","dmg");
		alert("game over");
	}else if(element.className=='w') {
		element.setAttribute("class","z0");
		idname = parseInt(element.id);
		change_classname(idname+1,idname-1,idname-11,idname-12,idname-13,idname+11,idname+12,idname+13);
	}else if(element.className=='z1'){
		element.setAttribute("class","z11");
	}else if(element.className=='z2'){
		element.setAttribute("class","z22");
	}else if(element.className=='z3'){
		element.setAttribute("class","z33");
	}else if(element.className=='z4'){
		element.setAttribute("class","z44");
	}else if(element.className=='z5'){
		element.setAttribute("class","z55");
	}else if(element.className=='z6'){
		element.setAttribute("class","z66");
	}else if(element.className=='z7'){
		element.setAttribute("class","z7");
	}else if(element.className=='z8'){
		element.setAttribute("class","z88");
	}else if (element.className=='dmg' ){
		alert('You were already there')
	}
}
function change_classname(){
    for(var i = 0, len = arguments.length; i < len; ++i ){
	var element = document.getElementById(arguments[i])
	if(element.className == 'w'){
	    fire(element);
	}
	if(element.className == 'z1'){
	    element.className = 'z11';
	}
	if(element.className == 'z2'){
	    element.className = 'z22';
	}
	if(element.className == 'z3'){
	    element.className = 'z33';
	}
	if(element.className == 'z4'){
	    element.className = 'z44';
	}
	if(element.className == 'z5'){
	    element.className = 'z55';
	}
	if(element.className == 'z6'){
	    element.className = 'z66';
	}
	if(element.className == 'z7'){
	    element.className = 'z77';
	}
	if(element.className == 'z8'){
	    element.className = 'z88';
	}
    }
}
function check(){
	for(var i = 0,  len = arguments.length; i<len; ++i){
	    var k = arguments[i];
	    var j = arguments[i+1];
	    if(playerMap[k][j]=="s1"){
	    }else if(playerMap[k][j]=="w"){
		playerMap[k][j] = "z1";
	    }else if (playerMap[k][j] == "z1"){
		playerMap[k][j] = "z2";
	    } else if (playerMap[k][j] == "z2"){
		playerMap[k][j] = "z3";
	    }else if (playerMap[k][j] == "z3"){
		playerMap[k][j] = "z4";
	    } else if (playerMap[k][j] == "z4"){
                playerMap[k][j] = "z5";
            } else if (playerMap[k][j] == "z5"){
                playerMap[k][j] = "z6";
            }else if (playerMap[k][j] == "z6"){
                playerMap[k][j] = "z7";
            } else if (playerMap[k][j] == "z7"){
                playerMap[k][j] = "z8";
            }
	    ++i;
	}

}
var setShip = function(i,j){
			playerMap[i][j]="s1";
			check(i,j+1,i,j-1,i+1,j-1,i+1,j,i+1,j+1,i-1,j-1,i-1,j,i-1,j+1);

}

var genShipsArrangement = function(ts,playr){
	var set = false;
	var p = playr;
	var typeShip = 1;
	while (!set){
		var i = parseInt(Math.random() * 10);
		var j = parseInt(Math.random() * 10);
		
		if (i<11 & i>0 & j>0 & j<11 & (playerMap[i][j] !== 's1') ){
				set = true;
				setShip(i,j) 
		}
	}
}
function right(element){
    if(event.button === 2){
        element.setAttribute("style", "background-image: url('imgs/zx.PNG')");
    } else if(event.button === 0){
	fire(element);
    }
}
function randomInteger(min, max) {
    var rand = min - 0.5 + Math.random() * (max - min + 1)
    rand = Math.round(rand);
    return rand;
}
function start(){
    var bool = true;
    while(bool){
        var id = randomInteger(0,143);
	if(document.getElementById(id).className == 'w'){
	    fire(document.getElementById(id));
	    bool = false;
	}
    }
}
function init(){
	var width = 12, height = 12;
	enemy = document.querySelector('.js-enemy')
 	
 	playerMap = new Array();

	for (var i=0;i<width;i++){
		playerMap[i] = new Array();
		for (var j=0;j<height;j++){
			if(i == 0 || i == 11 || j==0 || j == 11){
			playerMap[i][j] = 'z';
			} else {
			playerMap[i][j] = 'w';
			}
		}
	}
	genShipsArrangement(1,1);
	genShipsArrangement(1,1);
	genShipsArrangement(1,1);
	genShipsArrangement(1,1);
	genShipsArrangement(1,1);
	genShipsArrangement(1,1);
	genShipsArrangement(1,1);
	genShipsArrangement(1,1);
	genShipsArrangement(1,1);
	genShipsArrangement(1,1);
	genShipsArrangement(1,1);
	genShipsArrangement(1,1);
	genShipsArrangement(1,1);
	genShipsArrangement(1,1);
	genShipsArrangement(1,1);
	var k = 0;
	for (var i=0;i<width;i++){
		for (var j=0;j<height;j++){
			z=document.createElement('div');
			z.className = playerMap[i][j];
			z.setAttribute("onmousedown","right(this)")
			z.setAttribute("oncontextmenu","return false")
			z.setAttribute("id",k++);
			enemy.appendChild(z);
		}
	}
			start();
};
window.addEventListener("DOMContentLoaded", init);
