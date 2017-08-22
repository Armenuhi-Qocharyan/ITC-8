
var app = angular.module("ints-itc8", ['ngTable']);
 app.controller('tableController', function ($scope) {
            $scope.data = [
                        {"id":1,"name":"Khachik","age":"21","score":"7"},
                        {"id":2,"name":"Nelli","age":"19","score":"7"},
                        {"id":3,"name":"Albert","age":"22","score":"8"},
                        {"id":4,"name":"Vrezh","age":"20","score":"7"},
                        {"id":5,"name":"Anjela","age":"24","score":"10"},
                        {"id":6,"name":"Poxos","age":"150","score":"5"},
                        {"id":7,"name":"Petros","age":"17","score":"9"},
                    ];
            $scope.greaterThan = function(val1, val2){
                return function(item){
                    return item.age > val1 && item.score > val2;
                }
            }       
        });


app.directive("topNavbar", function() {
    return {
        template : '<nav class="navbar navbar-inverse">\
                        <div class="container-fluid">\
                            <div class="navbar-header">\
                            <span class="navbar-brand">Homework</span>\
                            </div>\
                            <ul class="nav navbar-nav">\
                            <li><a href="index1.html">Page 1</a></li>\
                            <li><a href="index2.html">Page 2</a></li>\
                            </ul>\
                        </div>\
                    </nav>'
    };
});

app.directive("copyRight", function() {
    return {
        template : '<div class="footer">\
                        <span class="copyright">&copy; 2017 Instigate Training Center</span>\
                    </div>'
    };
});

app.directive("loginForm", function() {
    return {
        template : '<form >\
                        <div class="contain">\
                            <label><b>Username</b></label>\
                            <input type="text" placeholder="Enter Username" name="uname" required>\
                            <label><b>Password</b></label>\
                            <input type="password" placeholder="Enter Password" name="psw" required>\
                            <button type="submit">Login</button>\
                        </div>\
                    </form>'
    };
});

app.directive("studentsTable", function() {
    return {
        template : '<div ng-controller="tableController">\
                        <table ng-table="usersTable"  class="table table-striped">\
                            <tr ng-repeat="user in data">\
                                <td data-title="\'Id\'" >\
                                    {{user.id}}\
                                </td>\
                                <td data-title="\'Name\'" >\
                                    {{user.name}}\
                                </td>\
                                <td data-title="\'Age\'" >\
                                    {{user.age}}\
                                </td>   \
                                <td data-title="\'Score\'" >\
                                    {{user.score}}\
                                </td>    \
                            </tr>\
                            </table>\
                    </div>'
    };
});
app.directive("tableFilter", function() {
    return {
        template : '<div ng-controller="tableController">\
                        <table ng-table="usersTable" class="table table-striped">\
                            <tr ng-repeat="user in data | filter:greaterThan(18,6)">\
                                <td data-title="\'Id\'" >\
                                    {{user.id}}\
                                </td>\
                                <td data-title="\'Name\'" >\
                                    {{user.name}}\
                                </td>\
                                <td data-title="\'Age\'" >\
                                    {{user.age}}\
                                </td>   \
                                <td data-title="\'Score\'" >\
                                    {{user.score}}\
                                </td>    \
                            </tr>\
                            </table>\
                    </div>'
    };
});