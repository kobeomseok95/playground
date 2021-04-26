var redis = require('redis');
var subscriber = redis.createClient();
var publisher = redis.createClient();
var msg_count = 1;

subscriber.on('subscribe', function(channel, count) {
    publisher.publish('Goorm chanel1', '발행자 첫번째 메세지');
    publisher.publish('Goorm chanel1', '발행자 두번째 메세지');
    publisher.publish('Goorm chanel1', '발행자 세번째 메세지');
});

subscriber.on('message', function(channel, message) {
    console.log('채널명 : ' + channel + ', message : ' + message);
    msg_count += 1;

    if (msg_count == 3) {
        subscriber.unsubscribe();
        subscriber.quit();
        publisher.quit();
    }
});

subscriber.subscribe('Goorm chanel1');