package br.com.ayran.bank.transfer.find.repositories;

import br.com.ayran.bank.transfer.execute.models.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferFinderRepository extends JpaRepository<TransferEntity, Integer> {}
