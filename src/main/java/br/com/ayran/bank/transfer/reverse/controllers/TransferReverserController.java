package br.com.ayran.bank.transfer.reverse.controllers;

import br.com.ayran.bank.transfer.reverse.services.TransferReverserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferReverserController {
    @Autowired
    private TransferReverserService service;

    @DeleteMapping("/transfers/{id}")
    public void revertTransfer(@PathVariable Integer id) {
        this.service.reverseTransfer(id);
    }
}
