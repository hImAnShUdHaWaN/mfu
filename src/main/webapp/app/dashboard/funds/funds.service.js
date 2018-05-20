(function() {
    'use strict';

    angular
        .module('mfuApp')
        .factory('FundsService', FundsService);

    FundsService.$inject = ['$resource'];

    function FundsService ($resource) {
        var service = $resource('api/funds/', {}, {
            'query': {method: 'GET', isArray: true},
            'get': {
                    method: 'GET',
                    transformResponse: function (data) {
                        data = angular.fromJson(data);
                        return data;
                    }
                }
        });
        return service;
    }
})();
