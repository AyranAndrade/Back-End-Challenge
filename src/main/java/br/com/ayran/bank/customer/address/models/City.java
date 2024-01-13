package br.com.ayran.bank.customer.address.models;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "city_id")
    private Integer id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;
}
