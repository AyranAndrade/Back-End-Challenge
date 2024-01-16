package br.com.ayran.bank.transfer.execute.exceptions;

public class NoSufficientBalanceException extends RuntimeException {
    public NoSufficientBalanceException() {
        super("Sem saldo suficiente na conta");
    }
}
