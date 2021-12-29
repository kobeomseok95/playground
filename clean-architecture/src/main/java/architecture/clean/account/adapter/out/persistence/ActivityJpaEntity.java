package architecture.clean.account.adapter.out.persistence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.GenerationType.*;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "ACTIVITY")
@Getter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
class ActivityJpaEntity {

    @Id @GeneratedValue(strategy = IDENTITY) @Column(name = "ACTIVITY_ID")
    private Long id;

    private LocalDateTime timestamp;
    private Long ownerAccountId;
    private Long sourceAccountId;
    private Long targetAccountId;
    private Long amount;
}
