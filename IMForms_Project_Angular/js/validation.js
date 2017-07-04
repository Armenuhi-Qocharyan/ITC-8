(function(angular) {

var app = angular.module('form-example-modify-validators', []);

app.directive('overwriteEmail', function() {
  var EMAIL_REGEXP1 = /^[a-z0-9!#$%&'*+/=?^_`{|}~.-]+@gmail\.com$/;
  var EMAIL_REGEXP2 = /^[a-z0-9!#$%&'*+/=?^_`{|}~.-]+@mail\.ru$/;

  return {
    require: '?ngModel',
    link: function(scope, elm, attrs, ctrl) {
      // only apply the validator if ngModel is present and AngularJS has added the email validator
      if (ctrl && ctrl.$validators.email) {

        // this will overwrite the default AngularJS email validator
        ctrl.$validators.email = function(modelValue) {
          return ctrl.$isEmpty(modelValue) || EMAIL_REGEXP1.test(modelValue) || EMAIL_REGEXP2.test(modelValue);
        };
      }
    }
  };
});
app.directive('overwrite-password', function() {
var Password_REGEXP = /^(?=.*[0-9])(?=.*[a-z])[a-zA-Z0-9!@#$%^&*]{6,20}$/;
alert("a");
  return {
    require: '?ngModel',
    link: function(scope, elm, attrs, ctrl) {
      // only apply the validator if ngModel is present and AngularJS has added the email validator
      if (ctrl && ctrl.$validators.password) {

        // this will overwrite the default AngularJS email validator
        ctrl.$validators.password = function(modelValue) {
          return ctrl.$isEmpty(modelValue) || Password_REGEXP.test(modelValue);
        };
      }
    }
  };
});
})(window.angular);
