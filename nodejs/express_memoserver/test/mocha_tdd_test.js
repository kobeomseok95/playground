const { doesNotMatch } = require('assert');
var assert = require('assert');
var math = require('./math');

suite('math test', function() {
    test('math.pow test', function() {
        assert.deepEqual(4, math.pow(2, 2));
        assert.deepEqual(1, math.pow(1, 2));
    });

    test('math.abs test', function() {
        assert.deepEqual(10, math.abs(-10));
        assert.deepEqual(10, math.abs(10));
    });

    test('math.asyncAbs test', function() {
        math.asyncAbs(-10, function(err, number) {
            assert.ifError(err);
            assert.deepEqual(10, number);
            done();
        });
    });
})
