package com.santander.banco811.service.impl;

import com.santander.banco811.dto.AccountRequest;
import com.santander.banco811.dto.AccountResponse;
import com.santander.banco811.model.Conta;
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
//    public List<Conta> getAll(Integer numero) {
//
//        if (numero != null) {
//            return contaRepository.findByNome(numero);
//        } else {
//            return contaRepository.findAll();
//        }
//    }

    @Override
    public AccountResponse create(AccountRequest accountRequest, String username) {
        var user = userRepository.findByLogin(username);

        Conta conta = new Conta(accountRequest);
        accountRepository.save(conta);
        conta.setUser(user.get());
        conta.setAccountType(accountRequest.getTipoConta());
         accountRepository.save(conta);
         return new AccountResponse(conta);
    }

//    @Override
//    public Conta getById(Integer id) {
//        return contaRepository.findById(id).orElseThrow();
//    }
//
//    @Override
//    public Conta update(ContaRequest contaRequest, Integer id) {
//        Conta conta = contaRepository.findById(id).orElseThrow();
//
//        conta.setNome(contaRequest.getNome());
//        conta.setCpf(contaRequest.getCpf());
//        conta.setSenha(contaRequest.getSenha());
//
//        return contaRepository.save(conta);
//    }
//
//    @Override
//    public void delete(Integer id) {
//        var conta = contaRepository.findById(id).orElseThrow();
//
//        contaRepository.delete(conta);
//    }
}
