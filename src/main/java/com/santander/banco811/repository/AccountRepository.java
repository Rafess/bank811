package com.santander.banco811.repository;

import com.santander.banco811.model.Account;
import com.santander.banco811.model.AccountType;
import com.santander.banco811.projection.AccountView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Page<Account> findByNumber(Integer number, Pageable pageable);

    @Query("select new com.santander.banco811.dto.AccountResponse(a.id, a.number, a.agency, a.creationDate, a.updateDate, a.balance, a.accountType, a.user) from Account a where a.accountType = :accountType")
        Page<AccountView> findByAccountType(@Param("accountType") AccountType accountType, Pageable pageable);



}


