'use strict';

var SpringData = {};

var App = angular.module('SpringData', ['ngGrid','ngTable','ngDragDrop', 'ui.bootstrap','angularFileUpload']);

// Declare app level module which depends on filters, and services
App.config(function ($routeProvider,$provide,$httpProvider) {
	
	$routeProvider.when('/', {
        templateUrl: 'layoutservice/playerslayout',
        controller: HomeController
    });
	
	$routeProvider.otherwise({redirectTo: '/'});
	
	//RESPONSE INTERCEPTOR FOR ALL THE ANGULAR CALLS
	$provide.factory('responseHttpInterceptor', function($q) {
		return function(promise) {
			return promise.then(function(response) {
				// do something on success
				return response;
			}, function(response) {
				// do something on error
				if(response.status === 401){
					window.location.href = "/springdata/#/home";
				}
				return $q.reject(response);
			});
		};
	});

	$httpProvider.responseInterceptors.push('responseHttpInterceptor');
	
	//RESPONSE INTERCEPTOR FOR ALL THE JQUERY CALLS: EX:THE JQGRID
	$.ajaxSetup({
	    beforeSend: function() {
	    },
	    complete: function(response) {
	    	if(response.status === 401){
				window.location.href = "/springdata/#/home";
			}
	    }
	});
	
});