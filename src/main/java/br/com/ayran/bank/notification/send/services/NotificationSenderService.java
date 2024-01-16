package br.com.ayran.bank.notification.send.services;

import br.com.ayran.bank.customer.create.models.Customer;

public interface NotificationSenderService {
    void sendNotification(Customer customer);
}
