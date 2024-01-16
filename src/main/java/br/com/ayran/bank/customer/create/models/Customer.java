package br.com.ayran.bank.customer.create.models;

import br.com.ayran.bank.account.create.models.Account;
import br.com.ayran.bank.customer.address.models.Street;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;
import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "customer_id")
    private Integer id;

    @Enumerated(STRING)
    private CustomerType type;

    private String name;

    @Column(name = "document_number", unique = true)
    private String documentNumber;

    @JsonProperty(access = WRITE_ONLY)
    private String password;

    @ManyToOne(cascade = PERSIST)
    @JoinColumn(name = "street_id")
    private Street address;

    @OneToMany(mappedBy = "customer")
    private List<Account> accounts;
}
