var app = angular.module('dropdown', [ngRoute]);
app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl: "../html/select.html"

    })
    .when("/new", {
        templateUrl: "../html/create.html"
    })
    .when("/forms", {
        templateUrl: "../html/table.html"
    });
});

app.controller('drop', function($scope) {
    if ($route.current.templateUrl == "../html/select.html") {
        $scope.name = "new";
    } else if ($rout.current.tempateUrl == "../html/create.html") { 
        $scope.name = "forms";
    } 
});
