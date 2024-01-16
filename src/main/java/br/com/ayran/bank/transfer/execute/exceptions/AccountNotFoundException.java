package br.com.ayran.bank.transfer.execute.exceptions;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException() {
        super("Conta não encontrada");
    }
}
