/**
 * Created by lynn on 2017/4/21.
 */
var myApp = angular.module('myApp', [
    'ui.router',
    'myApp.ctrl',
    'myApp.serv'
    ]);

myApp.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
    //$urlRouterProvider.otherwise('/');
    $urlRouterProvider.when("", "/signIn");

    $stateProvider
        .state('signIn', {
            url:'/signIn',
            templateUrl: 'sign-in.html',
            controller: 'signInCtrl'
        })
        .state('main', {
            url:'/main',
            templateUrl: 'main.html',
            controller: 'mainCtrl'
        })

}]);

/**
 * 获取参数
 * @param sParam
 * @returns {boolean}
 */
function getUrlParameter(sParam) {
    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : sParameterName[1];
        }
    }
};
