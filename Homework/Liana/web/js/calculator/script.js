var first = "free";
var second ="free";
var sign = "free";

function sendId(ID) {
    switch (ID) {
        case "but1":
            if ("free" == first) {
                first = 0;
            }
            first = 1 + first * 10;
            document.getElementById("input").value = first;
            break;
        case "but2":
            if ("free" == first) {
                first = 0;
            }
            first = 2 + first * 10;
            document.getElementById("input").value = first;
            break;
        case "but3":
            if ("free" == first) {
                first = 0;
            }
            first = 3 + first * 10;
            document.getElementById("input").value = first;
            break;
        case "but4":
            if ("free" == first) {
                first = 0;
            }
            first = 4 + first * 10;
            document.getElementById("input").value = first;
            break;
        case "but5":
            if ("free" == first) {
                first = 0;
            }
            first = 5 + first * 10;
            document.getElementById("input").value = first;
            break;
        case "but6":
            if ("free" == first) {
                first = 0;
            }
            first = 6 + first * 10;
            document.getElementById("input").value = first;
            break;
        case "but7":
            if ("free" == first) {
                first = 0;
            }
            first = 7 + first * 10;
            document.getElementById("input").value = first;
            break;
        case "but8":
            if ("free" == first) {
                first = 0;
            }
            first = 8 + first * 10;
            document.getElementById("input").value = first;
            break;
        case "but9":
            if ("free" == first) {
                first = 0;
            }
            first = 9 + first * 10;
            document.getElementById("input").value = first;
            break;
        case "but0":
            if ("free" == first) {
                first = 0;
            }
            first = first * 10;
            document.getElementById("input").value = first;
            break;
        case "butC":
            first = "free";
            second = "free";
            document.getElementById("input").value = "input number";
            break;

        case "but+":
            result();
            if ("free" != second) {
                document.getElementById("input").value = second + "+";
            } else {
                document.getElementById("input").value = "";
            }

            if (second == "free") {
                second = 0;
            }
            if ("free" == first) {
                first = 0;
            }
            second += first;
            first = "free";
            sign = "+";
            break;

        case "but-":
            result();
            if ("free" != second) {
                document.getElementById("input").value = second + "-";
            } else {
                document.getElementById("input").value = "";
            }

            if (first == "free") {
                first = 0;
            }
            if (second == "free") {
                second = first;
            } else {
                second -= first;
            }
            first = "free";
            sign = "-";
            break;

        case "but/":
            result();
            if ("free" != second) {
                document.getElementById("input").value = second + "/";
            } else {
                document.getElementById("input").value = "";
            }

            if (first == "free") {
                first = 1;
            }
            if (second == "free") {
                second = first;
            } else {
                second /= first;
            }
            first = "free";
            sign = "/";
            break;

        case "but*":
            result();
            if ("free" != second) {
                document.getElementById("input").value = second + "*";
            } else {
                document.getElementById("input").value = "";
            }
            if (first == "free") {
                first = 1;
            }
            if ("free" == second) {
                second = first;
            } else {
                second *= first;
            }
            first = "free";
            sign = "*";
            break;

        case "butSqrt": 
            result();
            if ("free" != second) {
                document.getElementById("input").value = second + "sqrt";
            } else {
                document.getElementById("input").value = "";
            }

            if ("free" == first) {
                first = 0;
            }
            second = Math.sqrt(second);
            sign = "sqrt";
            first = "free";
            break;
        case "butPow": 
            result();
            if ("free" != second) {
                document.getElementById("input").value = second + "^";
            } else {
                document.getElementById("input").value = "";
            }

            sign = "pow";
            first = "free";
            break;
        case "butAbs": 
            result();
            if ("free" != second) {
                document.getElementById("input").value = second + "abs";
            } else {
                document.getElementById("input").value = "";
            }

            sign = "abs";
            first = "free";
            break;

        case "butLog": 
            result();
            if ("free" != second) {
                document.getElementById("input").value = "log" + second;
            } else {
                document.getElementById("input").value = "";
            }

            sign = "log";
            first = "free";
            break;

        case "but=":
            result();
            sign = "free";
            break;
    }
}

function result () { 
    switch (sign) {
        case "+":
            if ("free" != first) {
                second += first;
            }
            document.getElementById("input").value = second;
            first = "free";
            sign = "";
            break;
        case "-":
            if ("free" != first) {
                second -= first;
            }

            document.getElementById("input").value = second;
            first = "free";
            first = "free";
            sign = "";
            break;
        case "*":
            if ("free" != first) {
                second *= first;
            }
            document.getElementById("input").value = second;
            first = "free";
            sign = "";
            break;

        case "/":
            if ("free" != first) {
                second /= first;
            }
            document.getElementById("input").value = second;
            first = "free";
            sign = "";
            break;

        case "sqrt": 
            document.getElementById("input").value = second;
            sign = "";
            first = "free";
            break;

        case "pow":
            second = Math.pow(second, first);
            document.getElementById("input").value = second;
            sign = "";
            first = "free";
            break;
        case "abs":
            second = Math.abs(second);
            document.getElementById("input").value = second;
            sign = "";
            first = "free";
            break;

        case "log":
            second = Math.log(second);
            document.getElementById("input").value = second;
            sign = "";
            first = "free";
            break;

        case "free":
            second = first;
            first = "free";
            break;
    }
}
