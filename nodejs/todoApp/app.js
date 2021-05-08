var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');
var routes = require('./routes');
var todo = require('./routes/todo');
var http = require('http');

var app = express();
var port = 3000;

// configure
app.configure(function() {
    app.set('port', port);
    app.set('views', __dirname + '/views');
    app.set('view engine', 'ejs');
    app.use(express.favicon());
    app.use(express.logger('dev'));         // 로그 기록
    app.use(express.bodyParser());          // request body 파싱
    app.use(express.methodOverride());      // 구식 브라우저 메서드 지원
    app.use(app.router);                    // 라우팅

    // 정적 리소스 처리
    app.use(require('stylus').middleware(__dirname + '/public'));
    app.use(express.static(path.join(__dirname + 'public')));
});

app.configure('development', function() {
    app.use(express.errorHandler());
});

app.get('/', routes.index);
app.get('/list', todo.list);
app.post('/add', todo.add);
app.post('/complete', todo.complete);
app.post('/del', todo.del);

http.createServer(app).listen(app.get('port'), function() {
    console.log("서버 실행, 포트 번호 : " + app.get('port'));
});
