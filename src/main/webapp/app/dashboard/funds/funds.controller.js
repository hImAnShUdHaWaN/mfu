(function() {
    'use strict';

    angular
        .module('mfuApp')
        .controller('FundsController', FundsController);

    FundsController.$inject = ['$filter', 'FundsService', 'ParseLinks'];

    function FundsController ($filter, FundsService, ParseLinks) {
        var vm = this;

        vm.funds = null;
        vm.amc = null;
        vm.totalItems = 0;

        vm.reload = reload;

        vm.reload();

        function reload(){
            FundsService.query({}, function(result, headers){
                            vm.funds = result;
                            vm.totalItems = headers('X-Total-Count');
                        });
        }
    }
})();
