package br.com.ayran.bank.customer.create.controllers;

import br.com.ayran.bank.customer.create.models.Customer;
import br.com.ayran.bank.customer.create.services.CustomerCreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class CustomerCreatorController {
    @Autowired
    private CustomerCreatorService service;

    @PostMapping("/customers/")
    @ResponseStatus(CREATED)
    public void create(@RequestBody Customer customer) {
        System.out.println(customer);
        this.service.create(customer);
    }
}
