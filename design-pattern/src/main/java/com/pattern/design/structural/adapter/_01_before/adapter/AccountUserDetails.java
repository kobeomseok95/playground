package com.pattern.design.structural.adapter._01_before.adapter;

import com.pattern.design.structural.adapter._01_before.Account;
import com.pattern.design.structural.adapter._01_before.security.UserDetails;

// adapter
public class AccountUserDetails implements UserDetails {

    private Account account;

    public AccountUserDetails(Account account) {
        this.account = account;
    }

    @Override
    public String getUsername() {
        return account.getName();
    }

    @Override
    public String getPassword() {
        return account.getPassword();
    }
}
