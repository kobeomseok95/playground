function Foo() {}

Foo.prototype = {
    bar: function() {
        console.log('foo_bar 실행');
    }
};

function Bar() {}

// Foo 상속
Bar.prototype = Object.create(Foo.prototype);
Bar.prototype.baz = function() {
    console.log('Bar_baz 실행');
}

Foo.prototype.bar();
Bar.prototype.bar();
Bar.prototype.baz();

console.log("===============================");
var util = require('util');
function Bar2(){}

// util로 상속
util.inherits(Bar2, Foo);
Bar2.prototype.baz = function() {
    console.log('Bar2_baz 실행');
};

Foo.prototype.bar();
Bar2.prototype.bar();
Bar2.prototype.baz();
