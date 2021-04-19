// 이벤트를 활용하는 객체에는 해당 이벤트가 발생할 때 대응하여 동작하는 콜백함수를
// 가지는데, 이러한 함수를 이벤트 리스너라고 부르기도 한다.

var EventEmitter = require('events');

var custom_event = new EventEmitter();

custom_event.on('call', function() {
	console.log('이벤트 콜');
});

// custom_event.removeAllListeners();

custom_event.emit('call');
