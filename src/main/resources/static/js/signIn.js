/**
 * Created by lynn on 2017/4/21.
 */
var signInapp = angular.module('app.signIn',[])

signInapp.controller('signInCtrl',['$scope','signInSer',function ($scope,signInSer) {
    console.log("nihao")
    $scope.formData = {userAccount:'',userPwd:''};
    $scope.signIn = function () {
        console.log($scope.formData)
        signInSer.login($scope.formData);
    }
}])


signInapp.factory('signInSer',['$http',function ($http) {
    return{
        login:function (form) {
            $http({
                method: 'POST',
                url: 'http://localhost:8080/signIn',
                params:form,
                headers : {'Content-Type':'application/x-www-form-urlencoded'}
            }).then(function successCallback(response) {
                return response;
            }, function errorCallback(response) {
                // 请求失败执行代码
            });
        }
    }
}])