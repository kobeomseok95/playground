var totalDeposit = 0;
var Account = function(deposit) {
    totlaDeposit = deposit;
}

Account.prototype.getAccount = function() {
    return totalDeposit;
}

Account.prototype.withDraw = function(money) {
    this.money = money;
    totlaDeposit -= money;
}

Account.prototype.AtmRemainingCash = function() {
    return this.money;
}

module.exports = Account;
