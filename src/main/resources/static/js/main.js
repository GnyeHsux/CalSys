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
            cache:'false',
            templateUrl: 'sign-in.html',
            controller: 'signInCtrl'
        })
        .state('main', {
            url:'/main',
            cache:'false',
            templateUrl: 'main.html',
            controller: 'mainCtrl'
        })
        .state('main.users',{
            url:'/users',
            cache:'false',
            views:{
                'content':{
                    templateUrl:'user/users.html',
                    controller:'userListCtrl'
                }
            }
        })
        .state('main.addUser',{
            url:'/addUser',
            cache:'false',
            views:{
                'content':{
                    templateUrl:'user/user-add.html',
                    controller:'userCtrl'
                }
            }
        })
        .state('main.editUser',{
            url:'/editUser?userId',
            cache:'false',
            views:{
                'content':{
                    templateUrl:'user/user-add.html',
                    controller:'userCtrl'
                }
            }
        })
        .state('main.myBusi',{
            url:"/myBusi",
            cache:'false',
            views:{
                'content':{
                    templateUrl:'bussiness/myBussiness.html',
                    controller:'myBusiCtrl'
                }
            }
        })
        .state('main.listBusi',{
            url:"/listBusi",
            cache:'false',
            views:{
                'content':{
                    templateUrl:'bussiness/listbusi.html',
                    controller:'listBusiCtrl'
                }
            }
        })
        .state('main.editBusi',{
            url:"/editBusi?busiId",
            cache:"false",
            views:{
                'content':{
                    template:"bussiness/busiDetail.html",
                    controller:'busiDetailCtrl'
                }
            }
        })
        .state('main.busiDetail',{
            url:"/busiDetail?busiId",
            cache:"false",
            views:{
                'content':{
                    template:"bussiness/busiDetail.html",
                    controller:'busiDetailCtrl'
                }
            }
        })
}]);

