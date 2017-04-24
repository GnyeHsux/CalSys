/**
 * Created by lynn on 2017/4/23.
 */

angular.module('app.siCtrl',[]).controller('signInCtrl',['$scope','signInSer',function ($scope,signInSer) {
    $scope.formData = {userAccount:'',userPwd:''};
    $scope.signIn = function () {
        console.log($scope.formData)
        signInSer.login($scope.formData);
    }
}])