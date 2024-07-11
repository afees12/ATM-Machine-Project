// src/main/java/com/example/atm/service/ATMService.java
package com.example.atm.service;

import com.example.atm.model.Account;
import org.springframework.stereotype.Service;

@Service
public class ATMService {
    private Account account;

    public ATMService() {
        this.account = new Account("123456", 1000.0);
    }

    public double checkBalance() {
        return account.getBalance();
    }

    public void deposit(double amount) {
        account.setBalance(account.getBalance() + amount);
    }

    public void withdraw(double amount) {
        if (account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
        } else {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }
}

