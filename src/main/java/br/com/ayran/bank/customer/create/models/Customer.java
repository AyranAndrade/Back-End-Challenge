package br.com.ayran.bank.customer.create.models;

import br.com.ayran.bank.customer.address.models.Street;
import jakarta.persistence.*;
import lombok.Setter;
import lombok.ToString;

import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Table(name = "customers")
@ToString
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "customer_id")
    private Integer id;
    @Enumerated(STRING)
    private CustomerType type;
    private String name;
    @Column(name = "document_number")
    private String documentNumber;
    private String password;

    @ManyToOne(cascade = PERSIST)
    @JoinColumn(name = "street_id")
    private Street address;
}
