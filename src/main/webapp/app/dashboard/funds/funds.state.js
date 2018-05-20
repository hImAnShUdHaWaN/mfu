(function() {
    'use strict';

    angular
        .module('mfuApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('funds', {
            parent: 'dashboard',
            url: '/funds',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'funds.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/dashboard/funds/funds.html',
                    controller: 'FundsController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('funds');
                    return $translate.refresh();
                }]
            }
        });
    }
})();
