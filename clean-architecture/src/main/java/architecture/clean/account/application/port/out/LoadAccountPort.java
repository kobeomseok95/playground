package architecture.clean.account.application.port.out;

import architecture.clean.account.domain.Account;

import java.time.LocalDateTime;

import static architecture.clean.account.domain.Account.*;

public interface LoadAccountPort {

    Account loadAccount(AccountId accountId, LocalDateTime now);
}
