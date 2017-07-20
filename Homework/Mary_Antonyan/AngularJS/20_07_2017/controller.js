app.controller('myCtrl', ['$scope', 'NgTableParams', function ($scope, NgTableParams) {
    var data = [{name: "Moroni", age: 50} /*,*/];
    this.tableParams = new NgTableParams({ dataset: data});
}]);

app.directive("login", function() {
    return {
        template : "<form style='font-family: arial'>\
            <fieldset style='float: left'>\
            <legend>Login</legend>\
            <h4 style='margin-bottom: 7px'>Username</h4>\
            <input type='text' placeholder='Enter username...'>\
            <h4 style='margin-bottom: 7px'>Password</h4>\
            <input type='password' placeholder='Enter password...'>\
            <button style='display: block; margin-top: 20px'>Submit</button>\
            </fieldset>\
            </form>"
    };
});

app.directive("students", function() {
    return {
        template : '<table ng-table="vm.tableParams" class="table" show-filter="true">\
            <tr ng-repeat="user in $data">\
            <td title="Name" filter="{ name: text}" sortable="name">{{user.name}}</td>\
            <td title="Age" filter="{ age: number}" sortable="age">{{user.age}}</td>\
            </tr>\
            </table>'
    };
});
