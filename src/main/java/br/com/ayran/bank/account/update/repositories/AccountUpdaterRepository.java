package br.com.ayran.bank.account.update.repositories;

import br.com.ayran.bank.account.create.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountUpdaterRepository extends JpaRepository<Account, Integer> {}
