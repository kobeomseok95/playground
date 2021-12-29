package architecture.clean.account.application.port.out;

import architecture.clean.account.domain.Account;

public interface UpdateAccountStatePort {

    void updateActivities(Account account);
}
