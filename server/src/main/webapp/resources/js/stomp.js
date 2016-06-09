angular.module('ngStomp', []).service('$stomp', function ($rootScope, $q) {
    this.connected = false;
    this.sock = null;
    this.stomp = null;
    this.debug = null;
    this.connectedListener = null;
    this.disconnectedListener = null;

    this.setDebug = function (callback) {
        this.debug = callback;
    };

    this.setConnected = function (callback) {
        this.connectedListener = callback;
    };

    this.setDisconnected = function (callback) {
        this.disconnectedListener = callback;
    };

    this.connect = function (endpoint, headers) {
        headers = headers || {};

        var self = this;

        this.sock = new SockJS(endpoint);
        this.stomp = Stomp.over(this.sock);
        this.stomp.debug = this.debug;
        this.stomp.connect(headers, function (frame) {
            self.connected = true;
            if (angular.isDefined(self.connectedListener)) {
                self.connectedListener.call(this, frame);
            }
        }, function (err) {
            if (self.connected) {
                self.connected = false;
                if (angular.isDefined(self.disconnectedListener)) {
                    self.disconnectedListener.call(this, err);
                }
            }
            setTimeout(function () {
                self.connect(endpoint, headers);
            }, 1000);
        });
    };

    this.disconnect = function () {
        this.stomp.disconnect();
    };

    this.subscribe = this.on = function (destination, callback, headers) {
        headers = headers || {};
        return this.stomp.subscribe(destination, function (res) {
            var payload = null;
            try {
                payload = JSON.parse(res.body);
            } finally {
                if (callback) {
                    callback(payload, res.headers, res);
                }
            }
        }, headers);
    };

    this.unsubscribe = this.off = function (subscription) {
        subscription.unsubscribe();
    };

    this.send = function (destination, body, headers) {
        var dfd = $q.defer();
        try {
            var payloadJson = JSON.stringify(body);
            headers = headers || {};
            this.stomp.send(destination, headers, payloadJson);
            dfd.resolve();
        } catch (e) {
            dfd.reject(e);
        }
        return dfd.promise;
    };

    this.isConnected = function() {
        return this.connected;
    };
});