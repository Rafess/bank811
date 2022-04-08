package com.santander.banco811.repository;

import com.santander.banco811.model.Account;
import com.santander.banco811.model.AccountType;
import com.santander.banco811.projection.AccountView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    List<Account> findByBalanceLessThan(BigDecimal balance);
    List<Account> findByBalanceLessThanEqual(BigDecimal balance);
    List<Account> findByBalanceGreaterThan(BigDecimal balance);
    List<Account> findByBalanceGreaterThanEqual(BigDecimal balance);

    List<Account> findByBalanceBetween(BigDecimal initialBalance, BigDecimal finalBalance);
    List<Account> findByBalanceIn(List<BigDecimal> balances);

    List<Account> findByAccountTypeAndBalanceBetweenOrderByBalance(AccountType accountType, BigDecimal initialBalance, BigDecimal finalBalance);

    List<Account> findByUsuario_cpf(String cpf);

    Boolean existsByAccountType(AccountType accountType);

    @Query("select c from Account c " +
            "where (c.accountType = :accountType and c.usuario.cpf = :cpf) " +
            "or (c.accountType = :accountType or c.balance = :balance)")
    List<Account> findByAccountTypeAndCpfOrAccountTypeAndBalance(
            @Param("accountType") AccountType accountType,
            @Param("cpf") String cpf,
            @Param("balance") BigDecimal balance
    );

    @Query("select c from Account c " +
            "where c.accountType = :accountType and c.usuario.name = :name")
    List<Account> findByAccountTypeAndUsuarioName(
            @Param("accountType") AccountType accountType,
            @Param("name") String name
    );


    List<AccountView> findAllByAccountType(AccountType accountType);
}


