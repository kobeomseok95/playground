package architecture.clean.account.adapter.out.persistence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "ACCOUNT")
@Getter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
class AccountJpaEntity {

    @Id @GeneratedValue(strategy = IDENTITY) @Column(name = "ACCOUNT_ID")
    private Long id;

}
