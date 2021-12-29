package architecture.clean.account.adapter.in.web;

import architecture.clean.account.application.port.in.SendMoneyCommand;
import architecture.clean.account.application.port.in.SendMoneyUseCase;
import architecture.clean.account.domain.Money;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static architecture.clean.account.domain.Account.AccountId;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts/send")
class SendMoneyController {

    private final SendMoneyUseCase sendMoneyUseCase;

    @PostMapping("/{sourceAccountId}/{targetAccountId}/{amount}")
    public void sendMoney(
            @PathVariable("sourceAccountId") Long sourceAccountId,
            @PathVariable("targetAccountId") Long targetAccountId,
            @PathVariable("amount") Long amount
    ) {
        SendMoneyCommand command = new SendMoneyCommand(
                new AccountId(sourceAccountId),
                new AccountId(targetAccountId),
                Money.of(amount);
        );
        sendMoneyUseCase.sendMoney(command);
    }
}
