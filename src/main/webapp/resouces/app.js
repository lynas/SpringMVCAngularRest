var app = angular.module('myApp', []);
app.controller('myCtrl', function ($scope, $http) {
    $http.get("/appUser")
        .success(function (data) {
            console.log(data);
            $scope.appUserList = data;
        });

    $scope.postUser = function () {
        $http({
            method: 'POST',
            url: "/appUser",
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            data: 'userName='+$scope.userName+'&password='+$scope.password
        }).success(function (data) {
            alert(data.id);
        });
    }
});