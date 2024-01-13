package br.com.ayran.bank.account.create.services;

import br.com.ayran.bank.account.create.models.Account;
import br.com.ayran.bank.account.create.repositories.AccountCreatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountCreatorServiceImpl implements AccountCreatorService {
    @Autowired
    private AccountCreatorRepository repository;

    @Override
    public void create(Account account) {
        this.repository.save(account);
    }
}
