var appModule = angular.module("app-module", ["ngTable"]);
var data = [ {name:"Arman", surname: "Xaratyan", age: "20", avgScope: 4},
    {name:"Narek", surname: "Bekchyan", age: "21", avgScope: 9},
    {name:"Aren", surname: "Xaratyan", age: "19", avgScope: 10},
    {name:"Aram", surname: "Mkrtumyan", age: "19", avgScope: 6} ];

appModule.controller("app-controller", function($scope)   {
    $scope.data = data;
    $scope.isFiltred = false;
});

appModule.controller("std-controller", function($scope)   {
    $scope.data = data;
    $scope.isFiltred = true;
});

appModule.directive("ngLoginForm", function () {
    return {
        templateUrl: "resources/login-form.html"
    };
});

appModule.directive("ngHeader", function () {
    return {
        templateUrl: "resources/header.html"
    };
});

appModule.directive("ngFooter", function () {
    return {
        templateUrl: "resources/footer.html"
    };
});

appModule.directive("ngStudent", function () {
    return {
        templateUrl: "resources/student-table.html"
    };
});

appModule.filter("filterByAge", function() {
   return function (students, isFiltred) {
       if (!isFiltred) {
           return students;
       }
       var filtredStd = [];
       angular.forEach(students, function (student) {
           if (student.age >= 20 && student.avgScope >= 6) {

               filtredStd.push(student);
           }
       });
       return filtredStd;
   };
});
