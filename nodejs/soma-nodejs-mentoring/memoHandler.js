var Datastore = require('nedb');
var db = new Datastore({ filename: './data/memo', autoload: true });
var querystring = require('querystring');
var url = require('url');

exports.create = function(req, res, body){
    _insertMemo( body, function(error, result) {
        res.writeHead(200, {"Content-Type": "application/json"});
        res.write('{ "result" : "createMemo" }');
        res.end();
    });
};

exports.read = function(req, res){
    _findMemo( {}, function(error, results) {
        res.writeHead(200, {"Content-Type": "application/json"});
        res.write(JSON.stringify(results));
        res.end();
    });
};

exports.update = function(req, res, body){
    var query = url.parse(req.url).query;
    var where = querystring.parse(query);

    _updateMemo( where, body, function(error, result) {
        res.writeHead(200, {"Content-Type": "application/json"});
        res.write('update memo');
        res.end();
    });
};

exports.remove = function(req, res, body){
    var query = url.parse(req.url).query;
    var where = querystring.parse(query);

    _removeMemo(where, function(error, results) {
        res.writeHead(200, {"Content-Type": "application/json"});
        res.write('{"result": "removemomo"}');
        res.end();
    });
};

function _insertMemo(body, callback) {
    body = typeof body === 'string' ? JSON.parse(body) : body;

    var memo = {
        author: body.author,
        memo: body.memo,
        date: new Date()
    };
    db.insert(memo, callback);
}

function _findMemo(where, callback) {
    where = where || {};
    db.find(where, callback);
}

function _updateMemo(where, body, callback) {
    body = typeof body === 'string' ? JSON.parse(body) : body;
    db.update(where, {$set: body}, {multi: true}, callback);
}

function _removeMemo(where, callback) {
    db.remove(where, {multi: true}, callback);
}
