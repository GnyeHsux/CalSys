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