package br.com.ayran.bank.customer.create.services;

import br.com.ayran.bank.customer.create.models.Customer;
import br.com.ayran.bank.customer.create.repositories.CustomerCreatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerCreatorServiceImpl implements CustomerCreatorService {
    @Autowired
    private CustomerCreatorRepository repository;

    @Override
    public void create(Customer customer) {
        this.repository.save(customer);
    }
}
