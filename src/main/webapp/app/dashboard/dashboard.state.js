(function() {
    'use strict';

    angular
        .module('mfuApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('dashboard', {
            parent: 'app'
        });
    }
})();
