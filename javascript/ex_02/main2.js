// 동기 방식의 에러처리는 try, catch로 해결하기

var fs = require('fs');
 

// 비동기적 읽기
fs.readFile('text100.txt', 'utf8', function(err, data) {
    if (err){
        console.log('비동기적 읽기 에러 발생');
        // return ;
    }
    console.log('비동기적 읽기 ' + data);
});

// 동기적 읽기
var text = fs.readFileSync('text.txt', 'utf8');
console.log('동기적 읽기 ' + text);

console.log("=================================");
var data = 'fs.writeFile test';

fs.writeFile('text1.txt', data, 'utf8', function(err){
    if(err){
        console.log('에러 발생');
        return ;
    } else{
        console.log('비동기적 쓰기 파일 완료');   
    }
});

fs.writeFileSync('text2.txt', data, 'utf8');
console.log('동기적 파일 쓰기 완료');
