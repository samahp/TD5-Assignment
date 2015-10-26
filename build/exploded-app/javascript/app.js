(function (angular) {

    'use strict';

    var app = angular.module('my-app', [
        'ngResource',
        'ui.router'
    ]);

    app.factory('User', ['$resource', function ($resource) {
        return $resource('/api/users/:id', {id: '@id'}, {
            'update': { method : 'PUT'}
        });
    }]);

    app.config([
        '$stateProvider',
        '$urlRouterProvider',
        function ($stateProvider, $urlRouterProvider) {

            $urlRouterProvider.otherwise('/users');

            $stateProvider.state('users', {
                url: '/users',
                templateUrl: 'all-lists.html',
                controller: 'AllListsController'
            });

            $stateProvider.state('user', {
                url: '/users/:id',
                templateUrl: 'user.html',
                controller: 'UserController'
            });
        }
    ]);

    app.controller('AllListsController', [
        'User',
        '$scope',
        function (User, $scope) {

            $scope.lists = User.query();

            $scope.createList = function () {
                User.save({
                    items: []
                }).$promise.then(function () {
                    $scope.lists = User.query();
                });
            };
        }
    ]);

    app.controller('UserController', [
        'User',
        '$scope',
        '$stateParams',
        function (User, $scope, $stateParams) {
            $scope.list = User.get({id: $stateParams.id});

            $scope.doneStatus = {
                done: false
            };

            $scope.addItem = function () {
                if (!$scope.list.items) {
                    $scope.list.items = [];
                }
                $scope.list.items.push({done: false, message: ''});
            };

            $scope.removeItem = function (item) {
                $scope.list.items.splice($scope.list.items.indexOf(item), 1);
                $scope.update();
            };

            $scope.update = function () {
                User.update($scope.list);
            };
        }
    ]);

}(window.angular));
