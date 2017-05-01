/**
 * Created by lynn on 2017/4/23.
 */
angular.module('myApp.ctrl', [])
    .controller('signInCtrl', ['$rootScope', '$scope', '$state','signInSer', function ($rootScope, $scope, $state, signInSer) {
        $rootScope.$state = $state;
        $scope.formData = {userAccount: '', userPwd: ''};

        $scope.signIn = function () {

            var promise = signInSer.login($scope.formData);
            promise.then(function (data) {
                if (data.code == '1') {
                    //用户名
                    $rootScope.loginName = data.user.userName;

                    //用户id
                    $rootScope.loginUserId = data.user.userId;
                    alert("登录成功！");
                    $rootScope.$state.go('main')
                } else {
                    alert("用户不存在或者密码不正确！");
                }

            }, function (data) {

            })
        }
    }])
    .controller('mainCtrl', ['$scope','$rootScope','mainSer', function ($scope,$rootScope,mainSer) {
        $scope.nihao = "NIHAO";
        var userId = $rootScope.loginUserId;
        var promise = mainSer.getMenu(userId);
        promise.then(function (data) {
            //console.log(data);
            $scope.menuList = data;
            console.log($scope.menuList);
        })

        $rootScope.$state.go('main.users');

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
            var pro = userListSer.getUserList($scope.queryUsername,$scope.queryEmployeeId);
            pro.then(function (data) {
                $scope.userList = data;
            },function () {
                $scope.userList = $scope.userList;
            })
        }

    }])
    .controller('userCtrl', ['$scope', '$location','$rootScope', 'userSer', function ($scope, $location,$rootScope, userSer) {
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


                $scope.rolesList = data.rolesList;
            })
        }

        $scope.submitForm = function () {
            var subPromise = userSer.submitUserMsg($scope.userFormData);
            subPromise.then(function (data) {

                if (data.code == "0"){
                    //成功
                    alert("操作成功");
                    $rootScope.$state.go('main.users');
                }else {
                    alert("操作失败");
                }
            })
        }



    }])
    .controller('contentCtrl', ['$scope', function ($scope) {
        $scope.contentList = {};
    }])