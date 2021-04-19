var EventEmitter = require('events').EventEmitter;
var evt = new EventEmitter();

evt.on('helloNode', function(str){
    console.log('Hello ! ' + str);
});

setTimeout(function() {
    evt.emit('helloNode', "Node.js");
}, 3000);   // 비동기 방식으로 실행된다는 것을 확인

var calculator = require('./test.js');
console.log(calculator.double(3));  // 9
console.log(calculator.plus(3));    // 6

console.log("====================================");
var os = require('os');

console.log(os.tmpdir());
console.log(os.type());

var cpus = os.cpus();
for (var i = 0; i < cpus.length; i++) {
    console.log("CPU[" + (i + 1) + "]");
    console.log("model: " + cpus[i].model);
    console.log("speed: " + cpus[i].speed);
}

console.log("====================================");
var util = require('util');
var data = util.format(
    '%d, %s, %j', 6, 'chapter', {content : 'module'}
);
console.log(data);
