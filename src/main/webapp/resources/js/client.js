angular.module('ngClient', ['ngStomp']).service('$client', function ($stomp, $http) {
    this.connectListeners = [];
    this.disconnectListeners = [];
    this.subscriptions = {};
    this.initSubscriptions = [];
    this.initSends = [];

    $stomp.setDebug(function (args) {
        console.log(args);
    });

    var self = this;
    $stomp.setDisconnected(function () {
        self.initSubscriptions = [];
        for (var destination in self.subscriptions) {
            if (self.subscriptions.hasOwnProperty(destination)) {
                self.initSubscriptions.push({
                    destination: destination,
                    callback: self.subscriptions[destination]
                });
            }
        }
        self.disconnectListeners.forEach(function (callback) {
            callback.call(this);
        });
    });

    $stomp.setConnected(function (frame) {
        self.initSubscriptions.forEach(function (s) {
            self.subscribeBroadcast(s.destination, s.callback, s.headers);
        });
        self.initSends.forEach(function (s) {
            self.send(s.destination, s.body);
        });
        self.connectListeners.forEach(function (callback) {
            callback.call(this);
        });
    });

    this.addOnDisconnected = function (callback) {
        this.disconnectListeners.push(callback);
    };

    this.addOnConnected = function (callback) {
        this.connectListeners.push(callback);
    };

    this.init = function (csrf) {
        var header = {};
        header[csrf.headerName] = csrf.token;
        $stomp.connect('/connect', header);
    };
    $http.get('/csrf').then(function (csrf) {
        self.init(csrf.data);
    });

    this.subscribe = function (destination, callback) {
        this.subscribeBroadcast('/user' + destination, callback);
    };

    this.subscribeBroadcast = function (destination, callback) {
        if ($stomp.isConnected()) {
            if (this.subscriptions[destination] === undefined) {
                this.subscriptions[destination] = [];
            }
            this.subscriptions[destination].push($stomp.subscribe(destination, callback));
        } else {
            this.initSubscriptions.push({
                destination: destination,
                callback: callback
            });
        }
    };

    this.unsubscribe = this.off = function (destination, callback) {
        var subscription = this.subscriptions[destination];
        if (angular.isDefined(subscription)) {
            subscription.forEach(function (subscription) {
                if (!angular.isDefined(callback) || subscription == callback) {
                    $stomp.unsubscribe(subscription);
                }
            });
            this.subscriptions[destination] = undefined;
        }
    };

    this.send = function (destination, body, headers) {
        if ($stomp.isConnected()) {
            $stomp.send(destination, body, headers);
        } else {
            this.initSends.push({
                destination: destination,
                body: body,
                headers: headers
            });
        }
    };
});