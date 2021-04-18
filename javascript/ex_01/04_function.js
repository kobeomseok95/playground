function sum(a, b){
    return a + b;
}

var add = sum;
console.log(typeof add);    //function

var student = {
    name : 'beomseok',
    age : 27,
}
console.log(student.name);

delete student.name;
console.log(student.name);  // undefined
console.log(student);

delete student;
console.log(student);       // 객체가 삭제되지 않는다!

// 익명 함수 ==============================================
var f = function (a) {
    return "anonymous function";
}

console.log(f);     // [Function: f]
console.log(f());   // anonymous function

// callback 함수 ==============================================
function one() {
    return 1;
}

var two = function () {
    return 2;
}

console.log(typeof one);    //function
console.log(typeof two);    //function
function invoke_and_add(a, b) {
    return a() + b();
}

console.log(invoke_and_add(one, two));

function one_2() {
    return 1;
}

function invoke_and_add(a, b) {
    return a() + b();
}

console.log(invoke_and_add(one, function() {
    return 2;
}));    // 매개변수에 익명함수를 넣은 callback 함수
