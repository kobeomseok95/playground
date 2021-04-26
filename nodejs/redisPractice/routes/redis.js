var express = require('express');
var router = express.Router();

var redis = require('redis');
var client = redis.createClient();

// key value
router.post('/post-set', function(req, res, next) {
    client.set(req.body["key"], req.body["value"]);

    client.get(req.body["key"], function(err, value) {
        if (err) throw err;

        res.send(value)
    });
});

// hmset => key : maps [, maps...] 구조
// hset => key : maps 구조 

// list
router.post('/post-list', function(req, res, next) {
    var body = req.body;
    client.lpush(body["array_name"], body["value"], redis.print);

    client.lrange(body["array_name"], 0, -1, function(err, items) {
        if (err) throw err;

        res.send(items);
    }); 
});

router.post('/post-sadd', function(req, res, next) {
    var body = req.body;
    client.sadd(body["key"], body["value"], redis.print);

    client.smembers(body["key"], function(err, data) {
        if (err) throw err;

        res.send(data);
    });
});

module.exports = router;
