package br.com.ayran.bank.notification.send.exceptions;

public class NotificationNotSentException extends RuntimeException {
    public NotificationNotSentException() {
        super("Notificação não foi enviada");
    }
}
