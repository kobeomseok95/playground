package architecture.clean.account.application.port.in;

import architecture.clean.account.domain.Money;

import static architecture.clean.account.domain.Account.AccountId;

public interface GetAccountBalanceQuery {

    Money getAccountBalance(AccountId accountId);
}
