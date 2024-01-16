package br.com.ayran.bank.account.find.repositories;

import br.com.ayran.bank.account.create.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountFinderRepository extends JpaRepository<Account, Integer> {}
