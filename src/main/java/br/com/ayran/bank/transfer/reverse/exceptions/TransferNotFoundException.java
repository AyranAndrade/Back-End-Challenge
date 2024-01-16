package br.com.ayran.bank.transfer.reverse.exceptions;

public class TransferNotFoundException extends RuntimeException {
    public TransferNotFoundException() {
        super("Transferência não encontrada");
    }
}
