package com.pattern.design.structural.adapter._01_before;

public class AccountService {
    public Account findAccountByUsername(String username) {
        Account account = new Account();
        account.setName(username);
        account.setEmail(username);
        account.setPassword(username);
        return account;
    }

    public void createNewAccount(Account account) {

    }

    public void updateAccount(Account account) {

    }
}
