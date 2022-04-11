package com.santander.banco811.repository;

import com.santander.banco811.model.Account;
import com.santander.banco811.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionRespository extends JpaRepository<Transaction, Integer> {

    Page<Transaction> findByAccountId(Integer id, Pageable pageable);
}
