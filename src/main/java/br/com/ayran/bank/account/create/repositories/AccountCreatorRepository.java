package br.com.ayran.bank.account.create.repositories;

import br.com.ayran.bank.account.create.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountCreatorRepository extends JpaRepository<Account, Integer> {}
