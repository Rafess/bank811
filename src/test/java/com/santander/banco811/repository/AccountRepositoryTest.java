package com.santander.banco811.repository;
import com.santander.banco811.dto.AccountRequest;
import com.santander.banco811.model.Account;
import com.santander.banco811.model.AccountType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@DataJpaTest
@Profile("test")
class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Mock
    AccountRequest accountRequest = new AccountRequest();

    @Test
    void validateFindByNumberIfRepositoryBlank() {
        Account account = new Account();
        PageRequest pageRequest =  PageRequest.of(3,1);
        var accountFound = accountRepository.findByNumber(account.getNumber(), pageRequest);
        Assertions.assertEquals(accountFound.getNumber(), account.getNumber());
    }


    @Test
    void validateFindByNumberWhenSuccess() {
        Account account = new Account();
        account.setNumber(123456);
        account.setAgency(20);
        account.setAccountType(AccountType.PF);
        account.setUser(accountRequest.getUser());
        accountRepository.save(account);
        PageRequest pageRequest = PageRequest.of(0,3);
        var accountFound = accountRepository.findByNumber(account.getNumber(), pageRequest);
        Assertions.assertEquals(accountFound.getNumber(), account.getNumber());
    }



}