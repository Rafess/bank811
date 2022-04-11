package com.santander.banco811.service.impl;
import com.santander.banco811.dto.AccountRequest;
import com.santander.banco811.dto.AccountResponse;
import com.santander.banco811.dto.UserResponse;
import com.santander.banco811.model.Account;
import com.santander.banco811.model.AccountType;
import com.santander.banco811.projection.AccountView;
import com.santander.banco811.repository.AccountRepository;
import com.santander.banco811.repository.UserRepository;
import com.santander.banco811.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    UserRepository userRepository;

    UserResponse userResponse = new UserResponse();

    @Override
    public Page<Account> getAll(Integer number, int page, int size) {

        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "number");

        if (number != null) {
            return accountRepository.findByNumber(number, pageRequest);
        } else {
            return accountRepository.findAll(pageRequest);
        }
    }
    @Override
    public Page<AccountView> getAllByAccountType(AccountType accountType, int page, int size) {

        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "number");

        return accountRepository.findByAccountType(accountType, pageRequest);
    }

    @Override
    public AccountResponse create(AccountRequest accountRequest) {
        Account account = new Account(accountRequest);
        account.setUser(accountRequest.getUser());
        account.setAccountType(accountRequest.getAccountType());
        account.setBalance(BigDecimal.valueOf(0.00));
        accountRepository.save(account);
        return new AccountResponse(account);

    }

    @Override
    public Account getById(Integer id) {
        return accountRepository.findById(id).orElseThrow();
    }

    @Override
    public Account update(AccountRequest accountRequest, Integer id) {
        Account account = accountRepository.findById(id).orElseThrow();

        account.setNumber(accountRequest.getNumber());
        account.setAgency(accountRequest.getAgency());
        account.setAccountType(accountRequest.getAccountType());
        account.setUser(accountRequest.getUser());
        return accountRepository.save(account);
    }

    @Override
    public void delete(Integer id) {
        var account = accountRepository.findById(id).orElseThrow();

        accountRepository.delete(account);
    }
}
