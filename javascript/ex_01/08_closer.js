/*
    클로저 : 외부 함수 실행이 끝나고 외부 함수가 소멸된 이후에도
    내부 함수가 외부 함수의 변수에 접근할 수 있는 것

    내부 함수의 참조로 인해 값을 유지하게 되는 것.
*/

var num = 1;
function foo() {
    var num = 2;

    function bar() {// 클로저 함수 외부 함수의 변수를 저장하는 함수
        console.log(num);
    }

    return bar;
}

var baz = foo();
baz();

console.log("==================================================");
function f() {
    var a = [];
    var i;

    // for (i = 0; i < 3; i++) { 모두 3이 출력, 
    //     a[i] = function () {
    //         return i;
    //     }
    // }

        for (i = 0; i < 3; i++){
            a[i] = (function(x) {
                return function() {
                    return x;
                }
            })(i);
        }
    return a;
}

var b = f();

// 다 3이 나온다.
// var b = f(); 에서 반복문이 모두 실행된 후 출력되기 때문이다.
console.log(b[0]());
console.log(b[1]());
console.log(b[2]());

// 클로저는 연결된 함수 범위에서 최종 처리된 값을 가지게 된다.
