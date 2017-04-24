/**
 * Created by lynn on 2017/4/23.
 */

angular.module('app.siServ',[]).factory('signInSer',['$http','$httpParamSerializer',function ($http,$httpParamSerializer) {
    return{
        login:function (form) {
            var data = $httpParamSerializer(form);
            $http.post('http://localhost:8080/signIn',data,{
                headers:{"Content-Type":"application/x-www-form-urlencoded"}
            }).success(function (data) {
                console.log(data);
            })
        }
    }

}])