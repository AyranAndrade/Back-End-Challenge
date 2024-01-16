package br.com.ayran.bank.transfer.execute.services;

import br.com.ayran.bank.transfer.execute.models.Transfer;

public interface TransferExecutorService {
    Integer transfer(Transfer transferDescriptor);
}
