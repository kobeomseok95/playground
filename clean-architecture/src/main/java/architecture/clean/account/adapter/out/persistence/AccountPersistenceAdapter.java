package architecture.clean.account.adapter.out.persistence;

import architecture.clean.account.application.port.out.LoadAccountPort;
import architecture.clean.account.application.port.out.UpdateAccountStatePort;
import architecture.clean.account.domain.Account;
import architecture.clean.account.domain.Activity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

import static architecture.clean.account.domain.Account.*;

@Component
@RequiredArgsConstructor
class AccountPersistenceAdapter
        implements LoadAccountPort, UpdateAccountStatePort {

    private final ActivityRepository activityRepository;
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Override
    public Account loadAccount(
            AccountId accountId,
            LocalDateTime baselineDate) {

        AccountJpaEntity account = accountRepository.findById(accountId.getValue())
                .orElseThrow(EntityNotFoundException::new);

        List<ActivityJpaEntity> activities = activityRepository.findByOwnerSince(
                accountId.getValue(),
                baselineDate);

        Long withdrawalBalance = orZero(activityRepository
                .getWithdrawalBalanceUntil(
                        accountId.getValue(),
                        baselineDate));

        Long depositBalance = orZero(activityRepository
                .getDepositBalanceUntil(
                        accountId.getValue(),
                        baselineDate));

        return accountMapper.mapToDomainEntity(
                account,
                activities,
                withdrawalBalance,
                depositBalance);
    }

    private Long orZero(Long value){
        return value == null ? 0L : value;
    }

    @Override
    public void updateActivities(Account account) {
        for (Activity activity : account.getActivityWindow().getActivities()) {
            if (activity.getId() == null) {
                activityRepository.save(accountMapper.mapToJpaEntity(activity));
            }
        }
    }
}
