package com.santander.banco811.dto;

import com.santander.banco811.model.Account;
import com.santander.banco811.model.AccountType;
import com.santander.banco811.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class AccountResponse {
    private Integer id;
    private Integer number;
    private Integer agency;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
    private BigDecimal balance;
    private AccountType accountType;
    private User user;

    public AccountResponse(Account account) {
        this.id = account.getId();
        this.number = account.getNumber();
        this.agency = account.getAgency();
        this.creationDate = account.getCreationDate();
        this.updateDate = account.getUpdateDate();
        this.balance = account.getBalance();
        this.accountType = account.getAccountType();
        this.user = account.getUser();
    }

    public static List<AccountResponse> toResponse(List<Account> accounts) {
        return accounts.stream().map(AccountResponse::new).collect(Collectors.toList());
    }
}
