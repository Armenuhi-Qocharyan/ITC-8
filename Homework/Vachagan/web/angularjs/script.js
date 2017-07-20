	var App = angular.module('mainApp', ['ngRoute']);

	App.config(function($routeProvider) {
		$routeProvider

			.when('/', {
				templateUrl : 'pages/home.html',
				controller  : 'mainController'
			})

			.when('/about', {
				templateUrl : 'pages/about.html',
				controller  : 'aboutController'
			})

			.when('/contact', {
				templateUrl : 'pages/contact.html',
				controller  : 'contactController'
			});
	});


    App.directive("myLogin", function() {
        return {
            template : '  <form novalidate>\
        Username:<br>\
    <input type="text" ng-model="user.firstName"><br>\
        Password:<br>\
    <input type="password" ng-model="user.lastName">\
        <br><br>\
        <button ng-click="reset()">LOGIN</button>\
        </form> '
        };
    });

	App.controller('mainController', function($scope) {
        $scope.sortType     = 'name_surname';
        $scope.sortReverse  = false;
        $scope.searchFish   = '';
        $scope.student = [
            { name_surname: 'Smbat Melqonyan', age: 25, score: 5 },
            { name_surname: 'Anna Arakelyan', age: 30, score: 7 },
            { name_surname: 'Aren Markosyan', age: 16, score: 7 },
            { name_surname: 'Arman Aveyan', age: 21, score: 5 },
            { name_surname: 'Mher Eghshatyan', age: 25, score: 9 },
            { name_surname: 'Narek Nalbandyan', age: 40, score: 7 },
            { name_surname: 'Vram Torikyan', age: 10, score: 5 },
            { name_surname: 'Arman Shahverdyan', age: 15, score: 5 },
            { name_surname: 'Artavazd Nalbandyan', age: 28, score: 10 },
        ];
	});

	App.controller('aboutController', function($scope) {
        $scope.myFilter = function( age, score ){
            return function(item){
                return (item.age > age) && (item.score >= score) ;
            }
        }
	});

	App.controller('contactController', function($scope) {
		$scope.message = 'Contact us!';
	});

