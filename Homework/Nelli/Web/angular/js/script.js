var app = angular.module("Students", ["ngRoute"]);
app.directive("students", function() {
    return {
        restrict: "E",
        templateUrl: "../includes/students.html"
    };
});
app.controller('StudentsCtrl', function($scope) {
    $scope.condition = "";
    $scope.students = [{
            "name": "Nelli",
            "age": 19,
            "score": 7
        },
        {
            "name": "Liana",
            "age": 21,
            "score": 9
        }
    ]
    $scope.filter = function() {
        $scope.condition;
    }
});

app.config(function($routeProvider) {
    $routeProvider
        .when("/", {
            templateUrl: "../includes/students.html"
        })
        .when("/filtered", {
            templateUrl: "../includes/filter.html"
        });
});