package com.santander.banco811.service.impl;
import com.santander.banco811.dto.AccountRequest;
import com.santander.banco811.dto.AccountResponse;
import com.santander.banco811.model.Account;
import com.santander.banco811.repository.AccountRepository;
import com.santander.banco811.repository.UserRepository;
import com.santander.banco811.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    UserRepository userRepository;
//    @Override
//    public List<Account> getAll(Integer numero) {
//
//        if (numero != null) {
//            return accountRepository.findByNome(numero);
//        } else {
//            return accountRepository.findAll();
//        }
//    }

    @Override
    public AccountResponse create(AccountRequest accountRequest, String username) {
        var user = userRepository.findByLogin(username);

        Account account = new Account(accountRequest, username);
        accountRepository.save(account);
        account.setUser(user.get());
        account.setAccountType(accountRequest.getAccountType());
         accountRepository.save(account);
         return new AccountResponse(account);
    }

//    @Override
//    public Account getById(Integer id) {
//        return accountRepository.findById(id).orElseThrow();
//    }
//
//    @Override
//    public Account update(AccountRequest accountRequest, Integer id) {
//        Account account = accountRepository.findById(id).orElseThrow();
//
//        account.setNome(accountRequest.getNome());
//        account.setCpf(accountRequest.getCpf());
//        account.setSenha(accountRequest.getSenha());
//
//        return accountRepository.save(account);
//    }
//
//    @Override
//    public void delete(Integer id) {
//        var account = accountRepository.findById(id).orElseThrow();
//
//        accountRepository.delete(account);
//    }
}
