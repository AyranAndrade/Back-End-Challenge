package br.com.ayran.bank.customer.address.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Table(name = "streets")
@Getter
@Setter
public class Street {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "street_id")
    private Integer id;

    @JsonProperty("street")
    private String name;

    private String number;

    @ManyToOne(cascade = PERSIST)
    @JoinColumn(name = "city_id")
    private City city;
}
