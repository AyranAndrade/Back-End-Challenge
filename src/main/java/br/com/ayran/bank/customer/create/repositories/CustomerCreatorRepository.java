package br.com.ayran.bank.customer.create.repositories;

import br.com.ayran.bank.customer.create.models.Customer;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface CustomerCreatorRepository extends Repository<Customer, Integer> {
    Customer save(Customer customer);
    /* This method exists because Spring needs it
    to create an account with customer id
    associated */
    Optional<Customer> findById(Integer id);
}
