package com.santander.banco811.service;

import com.santander.banco811.dto.AccountRequest;
import com.santander.banco811.dto.AccountResponse;
import com.santander.banco811.model.Conta;

import java.util.List;

public interface AccountService {
    List<Conta> getAll(Integer numero);
    AccountResponse create(AccountRequest accountRequest, String username);
    Conta getById(Integer id);
    Conta update(AccountRequest accountRequest, Integer id);
    void delete(Integer id);
}
