var nav = (function () {
    return {
        openNav: function () {
            document.getElementById("mySidenav").style.width = "250px";
        },
        closeNav: function () {
            document.getElementById("mySidenav").style.width = "0";
        }
    }
}());
