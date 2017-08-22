var value = 0;
var act = "";

var action = function(a) {
	val = Number(document.getElementById("val1").value);
	if (isNaN(val)){
		alert("Please input correct values");
		document.getElementById("val1").value = "";
	} else {
		value = val;
		act = a;
		document.getElementById("val1").value = "";
	}
	document.getElementById("answer").innerHTML = ans;
}

var equal = function() {
	switch (act) {
		case '+': document.getElementById("val1").value = Number(document.getElementById("val1").value) + value;break;
		case '-': document.getElementById("val1").value = value - Number(document.getElementById("val1").value);break;
		case '*': document.getElementById("val1").value = Number(document.getElementById("val1").value) * value;break;
		case '/': document.getElementById("val1").value = value / Number(document.getElementById("val1").value);break;
		case '^': document.getElementById("val1").value = Math.pow(value , Number(document.getElementById("val1").value)); break;

	}
}

var action1 = function(act) {
	switch (act) {
		case 'sqrt': document.getElementById("val1").value = Math.sqrt(Number(document.getElementById("val1").value));break;
		case '||': document.getElementById("val1").value = Math.abs(Number(document.getElementById("val1").value));break;
		case 'log': document.getElementById("val1").value = Math.log(Number(document.getElementById("val1").value));break;
	}
}

var num = function(number) {
	document.getElementById("val1").value += number;
}

var minus = function() {
	if (document.getElementById("val1").value === "") {
		document.getElementById("val1").value = "-";
	} else if (document.getElementById("val1").value === "-"){
		document.getElementById("val1").value = "";
	} else {
		document.getElementById("val1").value = Number(document.getElementById("val1").value) * (-1);
	}
}

var del = function() {
	document.getElementById("val1").value = "";
	value = 0;
	act = "";
}