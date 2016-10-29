angular.module('app', [])
    .controller('StudentController', function ($scope, $http) {
        $http.get('http://localhost:8000').then(function (response) {
            alert(response);
    });
});