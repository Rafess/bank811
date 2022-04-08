package com.santander.banco811.projection;

import com.santander.banco811.model.AccountType;
import org.springframework.beans.factory.annotation.Value;


public interface AccountView {
    Integer getBalance();

    AccountType getAccountType();

    @Value("#{target.number + ' - ' + target.agency}")
    String getAgencyNumber();

    UserView getUser();

}
