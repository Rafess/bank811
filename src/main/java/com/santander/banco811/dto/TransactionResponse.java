package com.santander.banco811.dto;

import com.santander.banco811.model.Account;
import com.santander.banco811.model.Transaction;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Getter
@RequiredArgsConstructor
public class TransactionResponse {
    private Integer id;
    private BigDecimal value;
    private String transactionType;
    private Integer number;
    private Integer agency;
    private Account accountId;
    public TransactionResponse(Transaction transaction) {
        this.id = transaction.getId();
        this.value = transaction.getValue();
        this.transactionType = transaction.getTransactionType();
        this.number = transaction.getNumber();
        this.agency = transaction.getAgency();
        this.accountId = transaction.getAccountId();
    }
}
