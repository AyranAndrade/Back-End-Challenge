package br.com.ayran.bank.transfer.execute.models;

import br.com.ayran.bank.account.create.models.Account;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Table(name = "transfers")
@Setter
@Getter
@NoArgsConstructor
public class TransferEntity {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "transfer_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "source_account_id")
    private Account from;

    @ManyToOne
    @JoinColumn(name = "recipient_account_id")
    private Account to;

    private BigDecimal amount;

    public TransferEntity(Account from, Account to, BigDecimal amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }
}
