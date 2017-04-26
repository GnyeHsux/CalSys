/**
 * Created by lynn on 2017/4/23.
 */
angular.module('myApp.ctrl',[])
.controller('signInCtrl',['$rootScope','$scope','$state','signInSer',function ($rootScope,$scope,$state,signInSer) {
    $rootScope.$state = $state;
    $scope.formData = {userAccount:'',userPwd:''};

    $scope.signIn = function () {

        var promise = signInSer.login($scope.formData);
        promise.then(function (data) {
            if (data.code == '1'){
                $rootScope.role = data.menuList[0].menu_code;
                $rootScope.loginMsg = "登录成功";
                console.log($rootScope.role)
                $rootScope.$state.go('main')
            }else {
                $rootScope.loginMsg = "用户不存在或密码错误！";
            }


        },function (data) {
            
        })
    }
}])
.controller('mainCtrl',['$scope',function ($scope) {
    $scope.nihao ="NIHAO";
}])