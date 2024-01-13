package br.com.ayran.bank.account.create.models;

import br.com.ayran.bank.customer.create.models.Customer;
import jakarta.persistence.*;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.AUTO;
import static java.math.RoundingMode.HALF_UP;

@Entity
@Table(name = "accounts")
@ToString
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "account_id")
    private Integer id;
    private String agency;
    private BigDecimal balance;

    @Enumerated(STRING)
    private AccountStatus status;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public String test() {
        return balance.divide(new BigDecimal("2"), HALF_UP).toString();
    }
}
