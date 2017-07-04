var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope) {
    $scope.names = {
        person01 : {fname : "Exish", lname: "Vardanyan", age : "29"},
        person02 : {fname : "Vardush", lname: "Mnacakanyan", age : "19"},
        person03 : {fname : "Tamara", lname: "Paravyan", age : "17"},
    }
});