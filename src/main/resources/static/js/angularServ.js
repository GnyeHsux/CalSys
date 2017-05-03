/**
 * Created by lynn on 2017/4/23.
 */

angular.module('myApp.serv', [])
    .factory('signInSer', ['$http', '$httpParamSerializer', '$q', function ($http, $httpParamSerializer, $q) {
        return {
            login: function (form) {
                var defer = $q.defer();
                var data = $httpParamSerializer(form);
                $http.post('/signIn', data, {
                    headers: {"Content-Type": "application/x-www-form-urlencoded"}
                }).success(function (data) {
                    defer.resolve(data);
                }).error(function (data) {
                    defer.reject();
                })

                return defer.promise;
            }
        }

    }])
    .factory('mainSer', ['$http', '$httpParamSerializer', '$q', function ($http, $httpParamSerializer, $q) {
        return {
            /*getMenu: function (userId) {
                var defer = $q.defer()
                $http.get('/users/getUserMenu',{params:{"userId":userId}}).success(function (data) {
                    defer.resolve(data);
                }).error(function (data) {
                    defer.reject();
                })

                return defer.promise;
            },*/
            getUserRole:function (userId) {
                var defer = $q.defer()
                $http.get('/role/getUserRole',{params:{"userId":userId}}).success(function (data) {
                    defer.resolve(data);
                }).error(function (data) {
                    defer.reject();
                })

                return defer.promise;
            }
        }
    }])
    .factory('userListSer',['$http','$httpParamSerializer','$q',function ($http, $httpParamSerializer,$q) {
        return{
            getUserList:function (username,employeeId) {
                var defer = $q.defer();
                $http.get('/users/userList',{params: {"username": username,"employeeId":employeeId},cache:false}).success(function (data) {
                    defer.resolve(data);
                }).error(function () {
                    defer.reject();
                })
                return defer.promise;
            }
        }

    }])
    .factory('userSer', ['$http', '$httpParamSerializer', '$q', function ($http, $httpParamSerializer, $q) {
        return {
            getRoleList:function () {
                var defer = $q.defer();
                $http.get('/users/getRoleList').success(function (data) {
                    defer.resolve(data);
                }).error(function (data) {
                    defer.reject();
                });
                return defer.promise;
            },
            getManUser: function (userId) {
                var defer = $q.defer();
                $http.get('/users/queryUser', {params: {"userId": userId}}).success(function (data) {
                    defer.resolve(data);
                }).error(function (data) {
                    defer.reject();
                });
                return defer.promise;
            },
            submitUserMsg:function (form) {
                console.log(form);
                var defer = $q.defer();
                //var data = $httpParamSerializer(form);
                $http.post('/users/userAdd',form).success(function (data) {
                    defer.resolve(data);
                }).error(function (data) {
                    defer.reject();
                });
                return defer.promise;
            }
        }
    }])
    .factory('busiListSer',['$http','$q',function ($http,$q) {
        return{
            getBusiList:function (userId) {
                var defer = $q.defer();
                $http.get('/busi/listBusi',{params: {"userId": userId}}).success(function (data) {
                    defer.resolve(data);
                }).error(function () {
                    defer.reject();
                })
                return defer.promise;
            }
        }
    }])
    .factory('editBussiness',['$http','$q',function ($http,$q) {
        return{
            getBusiList:function (userId) {
                var defer = $q.defer();
                $http.get('/busi/listBusi',{params: {"userId": userId}}).success(function (data) {
                    defer.resolve(data);
                }).error(function () {
                    defer.reject();
                })
                return defer.promise;
            }
        }
    }])