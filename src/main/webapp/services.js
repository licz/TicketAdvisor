var ticketAdvisorApp = angular.module('TicketAdvisor',[]);

ticketAdvisorApp.service('services', function($http) {

    this.getTickets = function () {
        return $http({
            method: 'GET',
            url: '/tickets/tickets',
            headers: {
                'Content-Type': 'application/json'
            }
        });
    }

    this.addTicket = function (ticket) {
        return $http({
            method: 'PUT',
            url: '/tickets/ticket',
            data: ticket
        });
    }
});