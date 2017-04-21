/**
 * Created by lynn on 2017/4/21.
 */
var signInapp = angular.module('app.signIn',[])

signInapp.controller('signInCtrl',['$scope','signInSer',function ($scope,signInSer) {
    console.log("nihao")
    $scope.userAccount = "";
    $scope.userPwd = "";
    $scope.signIn = function () {
        console.log($scope.userAccount)
        console.log($scope.userPwd)
        signInSer.login($scope.userAccount, $scope.userPwd);
        console.log($scope.login)
    }
}])


signInapp.factory('signInSer',['$http',function ($http) {
    return{
        login:function (useraccount,userpwd) {
            $http({
                method: 'POST',
                url: 'localhost:8080/signIn',
                data:{"useraccount":useraccount,"userpwd":userpwd}
            }).then(function successCallback(response) {
                return response;
            }, function errorCallback(response) {
                // 请求失败执行代码
            });
        }
    }
}])