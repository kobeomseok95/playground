function makeException() {
    throw new Error('Custom Exception');
}

setTimeout(function() {
    console.log('hello');
    setTimeout(function() {
        console.log('hello');
    }, 1000);
}, 1000);

try{
    makeException();
} catch(err) {
    console.log('try-catch ' + err.stack);
}

console.log('!!!!!!!!!!!!!!');
