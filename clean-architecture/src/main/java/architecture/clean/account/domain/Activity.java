package architecture.clean.account.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.time.LocalDateTime;

import static architecture.clean.account.domain.Account.*;

@Value
@RequiredArgsConstructor
public class Activity {

    @Getter
    private final ActivityId id;

    @Getter
    @NonNull
    private final AccountId ownerAccountId;

    @Getter
    @NonNull
    private final AccountId sourceAccountId;

    @Getter
    @NonNull
    private final AccountId targetAccountId;

    @Getter
    @NonNull
    private final LocalDateTime timestamp;

    @Getter
    @NonNull
    private final Money money;

    public Activity(
            @NonNull AccountId ownerAccountId,
            @NonNull AccountId sourceAccountId,
            @NonNull AccountId targetAccountId,
            @NonNull LocalDateTime timestamp,
            @NonNull Money money) {
        this.id = null;
        this.ownerAccountId = ownerAccountId;
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.timestamp = timestamp;
        this.money = money;
    }

    @Value
    public static class ActivityId {
        private final Long value;
    }
}
