package br.com.ayran.bank.customer.address.models;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Table(name = "streets")
public class Street {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "street_id")
    private Integer id;
    private String name;
    private String number;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}
