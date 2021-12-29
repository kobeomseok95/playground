package architecture.clean.account.application.service;

import architecture.clean.account.application.port.in.GetAccountBalanceQuery;
import architecture.clean.account.application.port.out.LoadAccountPort;
import architecture.clean.account.domain.Money;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

import static architecture.clean.account.domain.Account.AccountId;

@RequiredArgsConstructor
public class GetAccountBalanceService implements GetAccountBalanceQuery {

    private final LoadAccountPort loadAccountPort;

    @Override
    public Money getAccountBalance(AccountId accountId) {
        return loadAccountPort.loadAccount(accountId, LocalDateTime.now())
                .calculateBalance();
    }
}
