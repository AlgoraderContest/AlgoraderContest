app.controller('GameListCtrl', function ($scope, $client, $filter) {
    $client.subscribe('/setGameList', function (response) {
        $scope.$applyAsync(function () {
            if (response.successful) {
                $scope.gameList = response.games;
            } else {
                console.log(response.message);
            }
        });
        setTimeout(function () {
            $scope.$apply(function () {
                $('#open-game-list').find('.has-tip').each(function () {
                    new Foundation.Tooltip($(this).foundation());
                })
            });
        }, 1000);
    });
    $client.send('/getGameList');
    var orderBy = $filter('orderBy');
    $scope.order = function (predicate) {
        $scope.predicate = predicate;
        $scope.reverse = ($scope.predicate === predicate) ? !$scope.reverse : false;
        if (predicate == 'players') {
            predicate = function (game) {
                return game.maxPlayers - game.players;
            };
        }
        $scope.gameList = orderBy($scope.gameList, predicate, $scope.reverse);
    };
});
app.filter('gameListFilter', function () {
    return function (dataArray, searchTerm) {
        if (!dataArray) {
            return;
        }
        if (!searchTerm) {
            return dataArray;
        }
        var term = searchTerm.toLowerCase();
        return dataArray.filter(function (item) {
            var termInName = item.name.toLowerCase().indexOf(term) > -1;
            var termInType = item.type.toLowerCase().indexOf(term) > -1;
            return termInName || termInType;
        });
    }
});