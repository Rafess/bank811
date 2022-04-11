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
    private TestEntityManager testEntityManager;

    @Autowired
    AccountRepository accountRepository;

    @Mock
    AccountRequest accountRequest = new AccountRequest();

    @Test
    void validateFindByNumberIfRepositoryBlank() {
        Account account = new Account();
        account.setNumber(932834);
        account.setAgency(11);
        account.setAccountType(AccountType.PF);
        account.setUser(accountRequest.getUser());
        account = testEntityManager.persist(account);
        PageRequest pageRequest =  PageRequest.of(3,1);
        var accountFound = accountRepository.findByNumber(account.getNumber(), pageRequest );
        Assertions.assertEquals(accountFound.getNumber(), account.getNumber());
    }


//    @Test
//    void findByAccountType() {
//    }
}