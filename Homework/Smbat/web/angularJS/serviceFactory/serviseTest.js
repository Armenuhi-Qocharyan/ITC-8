var app = angular.module('myApp', []);

app.service ("area", function () {
    this.circuleArea = function (r) {
        return r * r * 3.14;
    };
    this.test = "jgjhjg"
});

app.factory ("area1", function () {
    return {
        circuleArea: function () {
            return "Hiii";
        },
        test : "hello"
    }
});

app.controller ('myCtrl', function ($scope, area, area1) {
    $scope.radius = 5;
    $scope.result = area.circuleArea(+$scope.radius);
    $scope.changeInput = function () {
        $scope.result = area.circuleArea(+$scope.radius);
    };
    console.log(area1.circuleArea());
    console.log(area1.test);

});



