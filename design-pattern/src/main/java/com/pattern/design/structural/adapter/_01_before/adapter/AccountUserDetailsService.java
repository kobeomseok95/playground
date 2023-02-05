package com.pattern.design.structural.adapter._01_before.adapter;

import com.pattern.design.structural.adapter._01_before.Account;
import com.pattern.design.structural.adapter._01_before.AccountService;
import com.pattern.design.structural.adapter._01_before.security.UserDetails;
import com.pattern.design.structural.adapter._01_before.security.UserDetailsService;

// adapter
public class AccountUserDetailsService implements UserDetailsService {

    private AccountService accountService;

    public AccountUserDetailsService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUser(String username) {
        Account account = accountService.findAccountByUsername(username);
        return new AccountUserDetails(account);
    }
}
