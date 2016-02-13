var app = angular.module('acApp', ['ngClient']);
app.config(function () {

});
app.run(function ($rootScope, $client) {
    $client.addOnConnected(function () {
        alert('Connected');
    });
    $client.addOnDisconnected(function () {
        alert('Disconnected');
    });

    $(document).foundation();
});
app.filter('timeFromMillisFilter', function () {
    return function (value) {
        var seconds = Math.floor(value / 1000) % 60;
        var minutes = Math.floor(value / 1000 / 60);
        return minutes + ':' + pad(seconds);
    };
});
app.filter('timeFromSecondsFilter', function () {
    return function (value) {
        var seconds = Math.floor(value) % 60;
        var minutes = Math.floor(value / 60);
        return minutes + ':' + pad(seconds);
    };
});

function pad(num) {
    if (num < 10) {
        return '0' + num;
    }
    return num;
}