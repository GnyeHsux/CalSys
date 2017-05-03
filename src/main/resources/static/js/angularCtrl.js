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
        //$rootScope.openDropMenu = false;
        var userId = $rootScope.loginUserId;
        //TODO 菜单后台无法获取数组类型子菜单
        /*var promise = mainSer.getMenu(userId);
        promise.then(function (data) {
            //console.log(data);
            $scope.menuList = data;
            console.log($scope.menuList);
        })
        console.log($scope.menuList)*/
        var promise = mainSer.getUserRole(userId);
        promise.then(function (data) {
            if (data.code == "1"){
                $rootScope.loginUserRole = data.roleId;
                if (data.roleId == '1'){
                    $rootScope.$state.go('main.users');
                }

                if (data.roleId == '2' || data.roleId == '3' || data.roleId == '9'){
                    $rootScope.$state.go('main.listBusi');
                }
            }else {
                /*alert("获取用户菜单失败");
                $rootScope.$state.go('signIn');*/
            }
        })


    }])
    .controller('userListCtrl', ['$scope','userListSer', function ($scope,userListSer) {
        $scope.text = 'lalalall';
        $scope.queryUsername = '';
        $scope.queryEmployeeId = '';
        $scope.userList = [];
        var promise = userListSer.getUserList($scope.queryUsername,$scope.queryEmployeeId);
        promise.then(function (data) {
            $scope.userList = data;
        });

        $scope.submitMsg = function () {
            var pro = userListSer.getUserList($scope.queryUsername,$scope.queryEmployeeId);
            pro.then(function (data) {
                $scope.userList = data;
            },function () {
                $scope.userList = [];
            })
        }
        
        $scope.showSubMenuWrap = function ($event) {
            console.log(this)
            console.log($event);
            console.log($event.target);
            console.log($event.target.nextSibling)

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

        var rolePro = userSer.getRoleList();
        rolePro.then(function (data) {
            $scope.rolesList = data.rolesList;
        });

        $rootScope.isNotEmpty = function (str) {
            if (str != null && str != undefined && str != ''){
                return true;
            }
            return false;
        }

        $scope.userId = $location.search().userId;
        if ($rootScope.isNotEmpty($scope.userId)) {
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

        $scope.submitForm = function () {
            var subPromise = userSer.submitUserMsg($scope.userFormData);
            subPromise.then(function (data) {

                if (data.code == "1"){
                    //成功
                    alert(data.msg);
                    $rootScope.$state.go('main.users');
                }else {
                    alert(data.msg);
                }
            })
        }



    }])
    .controller('myBusiCtrl', ['rootScope','$scope', function ($rootScope,$scope) {
        $scope.nihao = "nihao";
    }])
    .controller('listBusiCtrl', ['$scope','busiListSer', function ($scope, busiListSer) {
        $scope.nihao = "nihao";

        var promise = busiListSer.getBusiList('')
        promise.then(function (data) {
            $scope.busiList = data;
        });

        $scope.submitMsg = function () {
            var pro = userListSer.listBusiSer.getBusiList($rootScope.loginUserId);
            pro.then(function (data) {
                console.log(data)
                $scope.busiList = data;
            },function () {
                $scope.busiList = [];
            })
        }
    }])
    .controller('busiDetailCtrl', ['rootScope','$scope', function ($rootScope,$scope) {
        $scope.nihao = "nihao";
    }])
