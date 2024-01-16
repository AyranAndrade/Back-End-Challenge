package br.com.ayran.bank.transfer.execute.exceptions;

public class InactiveAccountException extends RuntimeException {
    public InactiveAccountException() {
        super("Conta usada na transferência está inativa");
    }
}
