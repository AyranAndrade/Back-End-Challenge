package br.com.ayran.bank.transfer.execute.services;

import br.com.ayran.bank.account.find.repositories.AccountFinderRepository;
import br.com.ayran.bank.account.update.repositories.AccountUpdaterRepository;
import br.com.ayran.bank.notification.send.services.NotificationSenderService;
import br.com.ayran.bank.transfer.execute.exceptions.AccountNotFoundException;
import br.com.ayran.bank.transfer.execute.exceptions.InactiveAccountException;
import br.com.ayran.bank.transfer.execute.exceptions.NoSufficientBalanceException;
import br.com.ayran.bank.transfer.execute.models.Transfer;
import br.com.ayran.bank.transfer.execute.models.TransferEntity;
import br.com.ayran.bank.transfer.execute.repositories.TransferExecutorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransferExecutorServiceImpl implements TransferExecutorService {
    @Autowired
    private TransferExecutorRepository transferRepository;

    @Autowired
    private AccountFinderRepository accountFinder;

    @Autowired
    private AccountUpdaterRepository accountUpdater;

    @Autowired
    private NotificationSenderService notificationSender;

    @Override
    @Transactional
    public Integer transfer(Transfer transferDescriptor) {
        Integer fromId = transferDescriptor.getSourceAccountId();
        Integer toId = transferDescriptor.getRecipientAccountId();
        BigDecimal amount = transferDescriptor.getAmount();

        var fromOptional = this.accountFinder.findById(fromId);
        var toOptional = this.accountFinder.findById(toId);

        if (fromOptional.isPresent() && toOptional.isPresent()) {
            var from = fromOptional.get();
            var to = toOptional.get();

            if (from.isActive() && to.isActive()) {
                if (from.hasBalance(amount)) {
                    from.withdraw(amount);
                    to.deposit(amount);

                    this.accountUpdater.save(from);
                    this.accountUpdater.save(to);

                    this.notificationSender.sendNotification(from.getCustomer());
                    this.notificationSender.sendNotification(to.getCustomer());

                    var entity = new TransferEntity(from, to, amount);
                    return this.transferRepository
                            .save(entity)
                            .getId();
                } else {
                    throw new NoSufficientBalanceException();
                }
            } else {
                throw new InactiveAccountException();
            }
        } else {
            throw new AccountNotFoundException();
        }
    }
}
