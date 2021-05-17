// Mocha BDD Interface 
// describe 함수는 given, when을 나타내는데 쓰이고
// context 함수는 Scenario를 표현하는 데 쓰인다. 
// it 함수는 then, User story의 결론을 보여준다.

var assert = require('assert');
var Atm = require('./atm');
var atm = new Atm(5000);

// ATM에서 현금을 인출할 때
describe('Feature: get cash from an ATM:', function () {
    context('Scenario: success', function () { // Scenario : 현금인출 성공한 상황 
        describe('When the user asks the ATM for 500', function () { // When : 유저가 ATM에서 500을 꺼내려할 때
            atm.withDraw(500);
            it('Then the ATM will have 500', function () { // Then : ATM은 500을 갖게 된다. 
                assert.equal(atm.AtmRemainingCash(), 500);
            });
            it("Then the user's account will have 4500", function (done) { // Then : 유저의 계좌에는 4500이 남게 된다. 
                assert.equal(atm.getAccount(), 4500);
                done();
            });
        });
    });
});