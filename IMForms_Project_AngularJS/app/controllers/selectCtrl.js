app.controller("select", ['$scope', function($scope) {
    $scope.go = function (locate) {
            window.location = locate;
    }
    $scope.hide = function () {
        $scope.show = false;
    } 
    
}]);
