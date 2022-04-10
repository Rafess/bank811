package com.santander.banco811.dto;

import com.santander.banco811.model.Account;
import lombok.Getter;

import java.math.BigDecimal;

@Getter

public class TransactionRequest {
    private BigDecimal value;
    private String transactionType;
    private Integer number;
    private Integer agency;
    private Account accountId;


}
