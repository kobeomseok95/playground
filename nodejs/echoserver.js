var Server = require('socket.io');
var io = Server();

io.on('connect', function (socket) {
    console.log('socket connected');
    socket.on('message', function (data) {
        console.log('receive : ', data);
        socket.send('echo : ' + data);
    });
    socket.on('disconnect', function () {
        console.log('socket disconnected');
    })
});

io.listen(3000);
