/**
 * Created by lynn on 2017/4/23.
 */
angular.module('myApp.ctrl', [])
    .controller('signInCtrl', ['$rootScope', '$scope', '$state', 'signInSer', function ($rootScope, $scope, $state, signInSer) {
        $rootScope.$state = $state;
        $scope.formData = {userAccount: '', userPwd: ''};

        $scope.signIn = function () {

            var promise = signInSer.login($scope.formData);
            promise.then(function (data) {
                if (data.code == '1') {
                    $rootScope.role = data.menuList[0].menu_code;
                    /*$rootScope.menuList = data.menuList;*/
                    $rootScope.loginMsg = "登录成功";
                    $rootScope.$state.go('main')
                } else {
                    $rootScope.loginMsg = "用户不存在或密码错误！";
                }

            }, function (data) {

            })
        }
    }])
    .controller('mainCtrl', ['$scope', function ($scope) {
        $scope.nihao = "NIHAO";

    }])
    .controller('userListCtrl', ['$scope','userListSer', function ($scope,userListSer) {
        $scope.text = 'lalalall';
        $scope.queryUsername = '';
        $scope.queryEmployeeId = '';
        $scope.userList = [];
        var promise = userListSer.getUserList($scope.queryUsername,$scope.queryEmployeeId);
        promise.then(function (data) {
            $scope.userList = data;
        })

        $scope.submitMsg = function () {
            promise.then(function (data) {
                console.log(data)
            })
        }


        $scope.del = function () {
            ngDialog.open({
                template: '/del.html',
                className: 'ngdialog-theme-default',
                scope: $scope,
                controller: function ($scope) {

                    $scope.confirm = function () {
                        console.log('ok');
                        $scope.closeThisDialog();
                    };
                    $scope.cancel = function () {
                        $scope.closeThisDialog();
                    };
                }
            });
        };

    }])
    .controller('userCtrl', ['$scope', '$location', 'userSer', function ($scope, $location, userSer) {
        $scope.userFormData = {
            userId: '',
            userName: '',
            employeeId: '',
            userAccount: '',
            userPwd: '',
            phone: '',
            userRole: ''
        };


        $scope.userId = $location.search().userId;
        if ($scope.userId != null && $scope.userId != undefined && $scope.userId != '') {
            var promise = userSer.getManUser($scope.userId);
            promise.then(function (data) {
                $scope.userFormData.userId = data.manUser.user_id;
                $scope.userFormData.userName = data.manUser.user_name;
                $scope.userFormData.employeeId = data.manUser.employee_id;
                $scope.userFormData.userAccount = data.manUser.user_account;
                $scope.userFormData.userPwd = data.manUser.user_pwd;
                $scope.userFormData.phone = data.manUser.phone;
                $scope.userFormData.userRole = data.manUser.userrole;
            })

        }
    }])
    .controller('contentCtrl', ['$scope', function ($scope) {
        $scope.contentList = {};
    }])
    .controller('demoCtrl',['$scope',function ($scope) {
       $scope.demo = "demo";


    }])
