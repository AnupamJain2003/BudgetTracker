package com.anupam.budget.controller;

import java.math.BigDecimal;
import java.util.Map;

import javax.swing.text.html.parser.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anupam.budget.model.BankAccount;
import com.anupam.budget.model.Transaction;
import com.anupam.budget.service.BankAccountService;
import com.anupam.budget.service.TransactionService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/accounts")
public class BankAccountController {
    @Autowired
    private BankAccountService accountService;
    @Autowired
    private TransactionService txService;

    @PostMapping
    public BankAccount createAccount(@RequestBody Map<String, Object> payload) {
        String ownerName = (String) payload.get("ownerName");
        BigDecimal initialAmount = new BigDecimal(payload.get("initialAmount").toString());
        return accountService.createAccount(ownerName, initialAmount);
    }
  
 
    @GetMapping("/accounts/validate")
    public Map<String, Object> validateAccount(@RequestParam Long accountId,@RequestParam String ownerName) {
    boolean isValid = accountService.validateAccount(accountId, ownerName);
    return Map.of(
        "accountId", accountId,
        "ownerName", ownerName,
        "valid", isValid
    );
}

    @PostMapping("/{accountId}/transactions")
    public Transaction addTransaction(@PathVariable Long accountId, @RequestBody Transaction tx) {
        return txService.addTransaction(accountId, tx);
    }

    @GetMapping("/{accountId}/balance")
    public Map<String, Object> getBalance(@PathVariable Long accountId) {
        BigDecimal balance = txService.calculateBalance(accountId);
        return Map.of("accountId", accountId, "balance", balance);
    }

    @GetMapping("/{accountId}/expenses-by-category")
    public Map<String, BigDecimal> expensesByCategory(@PathVariable Long accountId) {
        return txService.getExpensesByCategory(accountId);
    }

    @GetMapping("/{accountId}/income-sources")
    public Map<String, BigDecimal> incomeSources(@PathVariable Long accountId) {
        return txService.getIncomeSources(accountId);
    }
}
