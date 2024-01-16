package br.com.ayran.bank.exception.handle.controllers;

import br.com.ayran.bank.transfer.execute.exceptions.AccountNotFoundException;
import br.com.ayran.bank.transfer.execute.exceptions.InactiveAccountException;
import br.com.ayran.bank.transfer.execute.exceptions.NoSufficientBalanceException;
import br.com.ayran.bank.transfer.reverse.exceptions.TransferNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class GeneralExceptionHandler {
    @ExceptionHandler(value = DataIntegrityViolationException.class)
    @ResponseStatus(value = BAD_REQUEST)
    public Map<String, String> handleNonUniqueFieldException() {
        return Collections.singletonMap("error", "CPF, CNPJ e agência devem ser únicos.");
    }

    @ExceptionHandler(value = NoSufficientBalanceException.class)
    @ResponseStatus(value = BAD_REQUEST)
    public Map<String, String> handleNoSufficientBalanceException(NoSufficientBalanceException e) {
        return Collections.singletonMap("error", e.getMessage());
    }

    @ExceptionHandler(value = InactiveAccountException.class)
    @ResponseStatus(value = BAD_REQUEST)
    public Map<String, String> handleInactiveAccountException(InactiveAccountException e) {
        return Collections.singletonMap("error", e.getMessage());
    }

    @ExceptionHandler(value = AccountNotFoundException.class)
    @ResponseStatus(value = NOT_FOUND)
    public Map<String, String> handleAccountNotFound(AccountNotFoundException e) {
        return Collections.singletonMap("error", e.getMessage());
    }

    @ExceptionHandler(value = TransferNotFoundException.class)
    @ResponseStatus(value = NOT_FOUND)
    public Map<String, String> handleTransferNotFound(TransferNotFoundException e) {
        return Collections.singletonMap("error", e.getMessage());
    }
}
