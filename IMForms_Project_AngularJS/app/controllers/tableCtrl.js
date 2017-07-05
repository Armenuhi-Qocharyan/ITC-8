app.controller("table", ['$scope', function($scope, $forms) {
    $scope.forms = ['ITC 8','ITC 9','ITC 10','ITC 11'];

    $scope.openNav = function () {
        nav.openNav();
    }
    $scope.closeNav = function () {
        nav.closeNav();
    }

}]);

