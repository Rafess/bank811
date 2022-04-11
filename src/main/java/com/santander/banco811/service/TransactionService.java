package com.santander.banco811.service;

import com.santander.banco811.dto.TransactionRequest;
import com.santander.banco811.dto.TransactionResponse;
import com.santander.banco811.model.Transaction;
import org.springframework.data.domain.Page;

public interface TransactionService {
    TransactionResponse create(TransactionRequest transactionRequest);

    TransactionResponse getById(Integer id);

    Page<Transaction> getByAccountId(Integer accountId, int page, int size);
}
