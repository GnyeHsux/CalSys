/**
 * Created by lynn on 2017/4/23.
 */

angular.module('myApp.serv', [])
    .factory('signInSer', ['$http', '$httpParamSerializer', '$q', function ($http, $httpParamSerializer, $q) {
        return {
            login: function (form) {
                var defer = $q.defer()
                var data = $httpParamSerializer(form);
                $http.post('http://localhost:8080/signIn', data, {
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
            login: function (form) {
                var defer = $q.defer()
                var data = $httpParamSerializer(form);
                $http.post('http://localhost:8080/signIn', data, {
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
    .factory('userListSer',['$http','$httpParamSerializer','$q',function ($http, $httpParamSerializer,$q) {
        return{
            getUserList:function () {
                var defer = $q.defer();
                $http.get('http//localhost:8080/users/userList').success(function (data) {
                    defer.resolve(data);
                }).error(function () {
                    defer.reject();
                })
                return defer.promise;
            }
        }

    }])
    .factory('userSer', ['$http', '$httpParamSerializer', '$q', '$log', function ($http, $httpParamSerializer, $q, $log) {
        return {
            getManUser: function (userId) {
                var defer = $q.defer();
                $http.get('http://localhost:8080/users/queryUser', {params: {"userId": userId}}).success(function (data) {
                    defer.resolve(data);
                }).error(function (data) {
                    defer.reject();
                });
                return defer.promise;
            }
        }
    }])