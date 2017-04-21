/**
 * Created by lynn on 2017/4/21.
 */
var app = angular.module('myApp',['ngRoute','app.signIn']);

app.config(function ($routeProvider) {

    $routeProvider.when("/signIn/a/:a/b/:b/c/:c/d/:d",{
        templateUrl:"templates/sign-in.html",
        controller:"signInCtrl"
    })
})