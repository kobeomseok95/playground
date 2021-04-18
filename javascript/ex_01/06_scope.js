/* js의 스코프는 블록 단위가 아닌 함수 단위다!
function foo() {
    if (true){
        var a = 10;
        console.log(a);
    }

    console.log(a); 호출가능!
}

ES6 부터는 const, let을 이용해 블록 레벨 스코프도 지원!
*/

var global_scope = 'global';
var local_function = function() {
    var local_scope = 'local';
    console.log(local_scope);
    console.log(global_scope);

    return "완료";
}

console.log(local_function());  // 항상 함수에 대한 리턴값 출력
// console.log(local_scope); 에러!

console.log("===========================================================");
var a = 'a';

function outer() {
    var b = 'b';
    console.log(a);

    function inner() {
        var c = 'c';
        console.log(b);
        console.log(c);
    }
    // console.log(c);  c 스코프는 inner에만 해당

    inner();
}
outer();

// console.log(c);
console.log("===========================================================");
var text = 'global';

function foo() {
    console.log(text);
    // foo 함수에서 text를 참조할 때 자신의 스코프에서 text를 찾고 없으면 상위 스코프인
    // 전역 스코프에서 text를 찾아 출력한다.

    // 즉, 처음 선언되었을 때, 어떤 스코프에 있는지가 중요하다
}

function bar() {
    text = 'bar';
    foo();
}

bar();

console.log("===========================================================");
