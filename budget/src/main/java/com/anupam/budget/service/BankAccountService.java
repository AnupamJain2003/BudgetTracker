package com.anupam.budget.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anupam.budget.model.BankAccount;
import com.anupam.budget.repository.BankRepository;

@Service
public class BankAccountService {
    @Autowired
    private BankRepository accountRepo;

    public BankAccount createAccount(String ownerName, BigDecimal initialAmount) {
        return accountRepo.save(new BankAccount(ownerName, initialAmount));
    }
    public boolean validateAccount(Long accountId, String ownerName) {
    Optional<BankAccount> account = accountRepo.findById(accountId);
    return account.isPresent() && account.get().getOwnerName().equalsIgnoreCase(ownerName);
}

    public BankAccount getAccount(Long id) {
        return accountRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }
}

