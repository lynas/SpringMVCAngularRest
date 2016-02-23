var app = angular.module('myApp', []);
app.controller('myCtrl', function ($scope, $http) {
    $http.get("http://localhost:8080/appUser")
        .success(function (data) {
            console.log(data);
            $scope.appUserList = data;
        });

    $scope.postUser = function () {
        $http({
            method: 'POST',
            url: "/appUser",
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            data: 'userName="asadasd"&password="123"'
        }).success(function () {
        });
    }
});