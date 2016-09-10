ticketAdvisorApp.controller('MainController', ['$scope', 'services', function ($scope, services) {

    $scope.ticketToAdd = {
        link: "",
        ticket: "",
        email: ""
    };

    $scope.ticketRequests = [];

    $scope.addTicket = function () {
        services.addTicket($scope.ticketToAdd).then(function (dataResponse) {
            if (dataResponse == null) {
                alert("error!");
            } else {
                $scope.getTickets();
            }

        });
    };

    $scope.getTickets = function () {
        services.getTickets().then(function (dataResponse) {
            $scope.ticketRequests = dataResponse.data;
        });
    }

    var init = function () {
        $scope.getTickets();
    };

    init();

}]);