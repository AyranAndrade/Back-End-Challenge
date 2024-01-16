package br.com.ayran.bank.account.create.models;

import br.com.ayran.bank.customer.create.models.Customer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

import static br.com.ayran.bank.account.create.models.AccountStatus.ACTIVE;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Table(name = "accounts")
@Setter
@Getter
public class Account {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "account_id")
    private Integer id;

    @Column(unique = true)
    private String agency;

    private BigDecimal balance;

    @Enumerated(STRING)
    private AccountStatus status;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public boolean isActive() {
        return this.getStatus().equals(ACTIVE);
    }

    public boolean hasBalance(BigDecimal amount) {
        return this.balance.compareTo(amount) >= 0;
    }

    public void withdraw(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
    }

    public void deposit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }
}
