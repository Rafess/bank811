package com.santander.banco811.controller;

import com.santander.banco811.dto.AccountRequest;
import com.santander.banco811.dto.AccountResponse;
import com.santander.banco811.dto.TransactionRequest;
import com.santander.banco811.dto.TransactionResponse;
import com.santander.banco811.model.Account;
import com.santander.banco811.model.AccountType;
import com.santander.banco811.model.Transaction;
import com.santander.banco811.service.AccountService;
import com.santander.banco811.service.TransactionService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@RestController
@RequestMapping("/transacao")
public class TransactionController {

    TransactionService transactionService;


    @PostMapping
    public TransactionResponse create(@RequestBody TransactionRequest transactionRequest) {
        return transactionService.create(transactionRequest);
    }

    @GetMapping("/{id}")
    public TransactionResponse getById(@PathVariable Integer id) {
        return transactionService.getById(id);
    }

    @GetMapping("/account")
    public Page<Transaction> getByAccountId(@RequestParam Integer accountId,
                                                    @RequestParam(required = false, defaultValue = "0") int page,
                                                    @RequestParam(required = false, defaultValue = "3") int size) {
        return transactionService.getByAccountId(accountId, page, size);
    }

}
