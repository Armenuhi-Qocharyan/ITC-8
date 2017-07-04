var app = angular.module("myApp", []);
console.log(app);

app.controller('myCtrl', function ($scope) {
    $scope.fname = "Exish";
    $scope.lname = "Gvidonyan";
    console.log($scope);

});