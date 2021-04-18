/*
    호이스팅 : 함수 안에서 변수를 선언할 때, 어떤 위치에 있든
    함수의 시작 위치로 끌어올리는 현상
*/
function foo() {
    // var a; 호이스팅!
    console.log(a);     //undefined
    var a = 100;
    console.log(a);     //100
}

foo();
console.log("========================================")

foo2();

function foo2() {
    console.log("출력");
}

// 이 경우는 에러발생
// foo3();
// 
// var foo3 = function() {
//     console.log("출력");
// } 아래의 코드와 같다.

// 함수는 반드시 최상단에 선언하자
// var foo3;
// foo3();
// foo3 = function() {
//     console.log("출력");
// };
var foo3 = function() {
    console.log("출력");
};
foo3(); // 이렇게 말이지