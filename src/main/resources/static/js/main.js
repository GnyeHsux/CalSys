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
        .state('main.users',{
            url:'/users',
            views:{
                'content':{
                    templateUrl:'user/users.html',
                    controller:'userCtrl'
                }
            }
        })
        .state('main.addUser',{
            url:'/addUser',
            views:{
                'content':{
                    templateUrl:'user/user-add.html',
                    controller:'userCtrl'
                }
            }
        })
        .state('main.editUser',{
            url:'/editUser?userId',
            views:{
                'content':{
                    templateUrl:'user/user-add.html',
                    controller:'userCtrl'
                }
            }
        })

}]);

