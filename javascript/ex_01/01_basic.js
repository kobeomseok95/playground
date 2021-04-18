// 동적 형변환
var i = 1;
var ch = "a";
console.log(i + ch);

ch = 1
console.log(i + ch);


// 프로토타입 기반 객체 지향
console.log('==============================================');
var person = { name: "Beomseok Ko", age: 24 };
console.log(person);

person.height = 187;
console.log(person);

// 실행시 평가
console.log('==============================================');
eval("var a = 1, b = 2;");
console.log(a, b);

// 고차 함수
console.log('==============================================');
var fun1 = function (fun2) {
    fun2();
};

fun1(function () {
    console.log("hello~");
});