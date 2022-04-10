package com.santander.banco811.service;

import com.santander.banco811.dto.AccountRequest;
import com.santander.banco811.dto.AccountResponse;
import com.santander.banco811.model.Account;
import com.santander.banco811.model.AccountType;
import org.springframework.data.domain.Page;


public interface AccountService {
    Page<Account> getAll(Integer number, int page, int size);

    Page<AccountResponse> getAllByAccountType(AccountType accountType, int page, int size);

    AccountResponse create(AccountRequest accountRequest, String username);
    Account getById(Integer id);
    Account update(AccountRequest accountRequest, Integer id);
    void delete(Integer id);
}
