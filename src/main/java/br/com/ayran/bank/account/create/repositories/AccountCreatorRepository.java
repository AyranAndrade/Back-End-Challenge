package br.com.ayran.bank.account.create.repositories;

import br.com.ayran.bank.account.create.models.Account;
import org.springframework.data.repository.Repository;

public interface AccountCreatorRepository extends Repository<Account, Integer> {
    Account save(Account account);
}
