package br.com.ayran.bank.customer.address.models;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Table(name = "states")
public class State {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "state_id")
    private Integer id;
    private String name;
}
