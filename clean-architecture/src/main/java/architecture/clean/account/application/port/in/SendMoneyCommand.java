package architecture.clean.account.application.port.in;

import architecture.clean.account.domain.Money;
import architecture.clean.common.SelfValidating;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Value;

import javax.validation.Validator;
import javax.validation.constraints.NotNull;

import static architecture.clean.account.domain.Account.AccountId;
@Value
@EqualsAndHashCode(callSuper = false)
@Getter
public
class SendMoneyCommand extends SelfValidating<SendMoneyCommand> {

    @NotNull
    private final AccountId sourceAccountId;

    @NotNull
    private final AccountId targetAccountId;

    @NotNull
    private final Money money;

    public SendMoneyCommand(
            AccountId sourceAccountId,
            AccountId targetAccountId,
            Money money) {
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.money = money;
        this.validateSelf();
    }
}
