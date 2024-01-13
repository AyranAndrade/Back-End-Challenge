package br.com.ayran.bank.customer.create.repositories;

import br.com.ayran.bank.customer.create.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerCreatorRepository extends JpaRepository<Customer, Integer> {}
