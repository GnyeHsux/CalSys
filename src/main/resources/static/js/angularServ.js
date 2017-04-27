/**
 * Created by lynn on 2017/4/23.
 */

angular.module('myApp.serv',[])
    .factory('signInSer',['$http','$httpParamSerializer','$q',function ($http,$httpParamSerializer,$q) {
    return{
        login:function (form) {
            var defer = $q.defer()
            var data = $httpParamSerializer(form);
            $http.post('http://localhost:8080/signIn',data,{
                headers:{"Content-Type":"application/x-www-form-urlencoded"}
            }).success(function (data) {
                defer.resolve(data);
            }).error(function (data) {
                defer.reject();
            })

            return defer.promise;
        }
    }

}])
.factory('mainSer',['$http','$httpParamSerializer','$q',function ($http,$httpParamSerializer,$q) {
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
.factory('userSer',['$http','$httpParamSerializer','$q','$log',function ($http,$httpParamSerializer,$q,$log) {
    return {
        getManUser: function (userId) {
            console.log(userId)
            var defer = $q.defer();
            //var data = $httpParamSerializer(userId);
           /* $http.get('http://localhost:8080/queryUser', {userId:userId}, {
                headers: {"Content-Type": "application/x-www-form-urlencoded"}
            }).success(function (data) {
                defer.resolve(data);
            }).error(function (data) {
                defer.reject();
            })

            return defer.promise;*/
            $http.get('http://localhost:8080/queryUser',{params:{"userId": userId}}).success(function(data){
                console.log(data)
            });
        }
    }
}])