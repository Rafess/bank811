package com.santander.banco811.service;

import com.santander.banco811.dto.AccountRequest;
import com.santander.banco811.dto.AccountResponse;
import com.santander.banco811.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAll(Integer number);
    AccountResponse create(AccountRequest accountRequest, String username);
    Account getById(Integer id);
    Account update(AccountRequest accountRequest, Integer id);
    void delete(Integer id);
}
