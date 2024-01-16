package br.com.ayran.bank.transfer.reverse.repositories;

import br.com.ayran.bank.transfer.execute.models.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferReverserRepository extends JpaRepository<TransferEntity, Integer> {}
