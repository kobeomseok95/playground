package com.pattern.design.structural.adapter._01_before;

import com.pattern.design.structural.adapter._01_before.adapter.AccountUserDetailsService;
import com.pattern.design.structural.adapter._01_before.security.LoginHandler;
import com.pattern.design.structural.adapter._01_before.security.UserDetailsService;

public class App {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        UserDetailsService userDetailsService = new AccountUserDetailsService(accountService);
        LoginHandler handler = new LoginHandler(userDetailsService);

        handler.login("test", "test");
    }
}
