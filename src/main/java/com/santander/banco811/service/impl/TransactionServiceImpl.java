package com.santander.banco811.service.impl;

import com.santander.banco811.dto.TransactionRequest;
import com.santander.banco811.dto.TransactionResponse;
import com.santander.banco811.repository.AccountRepository;
import com.santander.banco811.repository.TransactionRespository;
import com.santander.banco811.service.TransactionService;
import com.santander.banco811.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRespository transactionRespository;

    @Autowired
    AccountRepository accountRepository;



    @Override
    public TransactionResponse create(TransactionRequest transactionRequest) {
        Transaction transaction = new Transaction(transactionRequest);
        transaction.setAccountId(transactionRequest.getAccountId());
        transactionRespository.save(transaction);
        return new TransactionResponse(transaction);
    }

    @Override
    public TransactionResponse getById(Integer id) {
      Transaction transaction = transactionRespository.findById(id).orElseThrow();
      return new TransactionResponse(transaction);
    }

    @Override
    public Page<Transaction> getByAccountId(Integer id, int page, int size){
        PageRequest pageRequest = PageRequest.of(
                page,
                size
        );
       return transactionRespository.findByAccountId(id, pageRequest);
    }


}
