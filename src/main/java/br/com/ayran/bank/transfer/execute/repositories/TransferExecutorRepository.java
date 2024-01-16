package br.com.ayran.bank.transfer.execute.repositories;

import br.com.ayran.bank.transfer.execute.models.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferExecutorRepository extends JpaRepository<TransferEntity, Integer> {}
