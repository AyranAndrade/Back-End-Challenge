package br.com.ayran.bank.transfer.execute.controllers;

import br.com.ayran.bank.transfer.execute.models.Transfer;
import br.com.ayran.bank.transfer.execute.services.TransferExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class TransferExecutorController {
    @Autowired
    private TransferExecutorService service;

    @PostMapping("/transfers")
    @ResponseStatus(CREATED)
    public ResponseEntity<Object> transfer(@RequestBody Transfer transferDescriptor) {
        Integer id =this.service.transfer(transferDescriptor);

        var uri = URI.create("/transfers/" + id);

        return ResponseEntity
                .created(uri)
                .build();
    }
}
