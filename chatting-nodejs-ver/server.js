var express = require('express');
var app = express();
var http = require('http').Server(app);
var io = require('socket.io')(http);
var path = require('path');

app.set('views', './views');
app.set('view engine', 'pug');
app.use(express.static(path.join(__dirname, 'public')));

app.get('/', (req, res) => {
    // 루트 페이지로 접속시 chat.pug 렌더링
    res.render('chat');
});

var count = 1;
// 채팅방 접속
io.on('connection', function(socket){
    console.log('user connected: ' + socket.id);
    var name = count++ + '번째 손님';
    socket.name = name;
    io.to(socket.id).emit('create name', name);
    io.emit('receive message', name + '님이 입장하셨습니다.');

    // 채팅방 접속이 끊어졌을 때
    socket.on('disconnect', function() {
        console.log('user disconnected" ' + socket.id + ' ' + socket.name);
        io.emit('receive message', socket.name + '님이 퇴장하셨습니다.');
        count--;
    });

    // 메세지 전송
    socket.on('send message', function(name, text){
        var msg = name + ' : ' + text;
        socket.name = name;
        console.log(msg);
        io.emit('receive message', msg);
    });

});

http.listen(3001, function() {
    console.log('server on!');
})
