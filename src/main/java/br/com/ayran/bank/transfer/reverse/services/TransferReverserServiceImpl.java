package br.com.ayran.bank.transfer.reverse.services;

import br.com.ayran.bank.account.update.repositories.AccountUpdaterRepository;
import br.com.ayran.bank.transfer.execute.models.TransferEntity;
import br.com.ayran.bank.transfer.find.repositories.TransferFinderRepository;
import br.com.ayran.bank.transfer.reverse.exceptions.TransferNotFoundException;
import br.com.ayran.bank.transfer.reverse.repositories.TransferReverserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferReverserServiceImpl implements TransferReverserService {
    @Autowired
    private TransferFinderRepository transferFinder;

    @Autowired
    private TransferReverserRepository transferReverser;

    @Autowired
    private AccountUpdaterRepository accountUpdater;

    @Override
    public void reverseTransfer(Integer transferId) {
        this.transferFinder
                .findById(transferId)
                .ifPresentOrElse(this::reverseTransferIfPresent, TransferNotFoundException::new);
    }

    private void reverseTransferIfPresent(TransferEntity v) {
        v.getFrom().deposit(v.getAmount());
        v.getTo().withdraw(v.getAmount());

        this.accountUpdater.save(v.getFrom());
        this.accountUpdater.save(v.getTo());

        this.transferReverser.delete(v);
    }
}
