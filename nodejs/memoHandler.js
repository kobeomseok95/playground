exports.create = function(req, res, body){
    res.writeHead(200, {"Content-Type": "text/plain"});
    res.write('create memo');
    res.end();
};

exports.read = function(req, res){
    res.writeHead(200, {"Content-Type": "text/plain"});
    res.write('read memo');
    res.end();
};

exports.update = function(req, res, body){
    res.writeHead(200, {"Content-Type": "text/plain"});
    res.write('update memo');
    res.end();
};

exports.remove = function(req, res, body){
    res.writeHead(200, {"Content-Type": "text/plain"});
    res.write('remove memo');
    res.end();
};
