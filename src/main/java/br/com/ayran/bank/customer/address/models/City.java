package br.com.ayran.bank.customer.address.models;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.ToString;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Table(name = "cities")
@ToString
@NoArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "city_id")
    private Integer id;
    private String name;

    public City(String name) {
        this.name = name;
    }
}
