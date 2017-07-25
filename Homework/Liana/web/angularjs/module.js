var app = angular.module("instItc", ["ngRoute"]);

app.config(function($routeProvider) {
  $routeProvider
  .when("/", {
    templateUrl : "login.html"

  })
  .when("/sort", {
    templateUrl : "sort.html",
    controller: "itcCtrl"
  })
  .when("/hello", {
    templateUrl : "hello.html"
  });
});


app.directive("login", function() {
    return {
        template: "<form><label>User name</label><br><input type='text' ng-model='username'><br><label>Password</label><br><input type='password' ng-model='password'><br><button>Submit</button></form> "
    };
});

app.controller('itcCtrl', function($scope) {
  $scope.sortType     = 'name';
  $scope.sortReverse  = false; 
  
  $scope.itc = [
    { name: 'Khachik', age: 21, score: 98 },
    { name: 'Nelli', age: 19, score: 99 },
    { name: 'Smbat', age: 30, score: 99 },
    { name: 'Vachagan', age: 20, score: 98 },
    { name: 'Mary', age: 19, score: 99 },
    { name: 'Ruben', age: 21, score: 98 },
    { name: 'Liana', age: 23, score: 97 },
    { name: 'Albert', age: 23, score: 99 },
    { name: 'Baby', age: 1, score: 100 },
    { name: 'Vrej', age: 20, score: 99 }
  ];
  
});
