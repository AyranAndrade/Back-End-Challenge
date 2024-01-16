package br.com.ayran.bank.transfer.execute.models;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Transfer {
    private Integer sourceAccountId;
    private Integer recipientAccountId;
    private BigDecimal amount;
}
