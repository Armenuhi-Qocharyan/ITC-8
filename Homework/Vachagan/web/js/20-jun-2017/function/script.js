

    function  Func(p1,p2,p3,p4){
      var str = "";
      for (var i=0; i < arguments.length; ++i) {
          str = str +" "+ arguments[i];
          console.log(arguments[i])
      }
      document.getElementById("demo").innerHTML = str;
    }



