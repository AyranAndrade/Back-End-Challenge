package br.com.ayran.bank.account.create.controllers;

import br.com.ayran.bank.account.create.models.Account;
import br.com.ayran.bank.account.create.services.AccountCreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class AccountCreatorController {
    @Autowired
    private AccountCreatorService service;

    @PostMapping("/accounts/")
    @ResponseStatus(CREATED)
    public void create(@RequestBody Account account) {
        System.out.println(account);
        System.out.println(account.test());
        this.service.create(account);
    }
}
