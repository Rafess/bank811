package com.santander.banco811.dto;

import com.santander.banco811.model.AccountType;
import com.santander.banco811.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
public class AccountRequest {
    private Integer number;
    private Integer agency;
    private AccountType accountType;
    private User user;

}
