package com.anupam.budget.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anupam.budget.model.BankAccount;
import com.anupam.budget.model.Transaction;
import com.anupam.budget.repository.BankRepository;
import com.anupam.budget.repository.TransactionRepo;
@Service
public class TransactionService {
    @Autowired
    private TransactionRepo txRepo;
    @Autowired
    private BankRepository accountRepo;

    public Transaction addTransaction(Long accountId, Transaction tx) {
        BankAccount account = accountRepo.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        tx.setBankAccount(account);
        tx.setDate(LocalDate.now());
        if(tx.getType().equalsIgnoreCase("Income"))
         account.setInitialAmount(account.getInitialAmount().add(tx.getAmount()));
        else
        account.setInitialAmount(account.getInitialAmount().subtract(tx.getAmount()));
        return txRepo.save(tx);
    }

    public BigDecimal calculateBalance(Long accountId) {
        BankAccount account = accountRepo.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        
        return account.getInitialAmount();
    }

    public Map<String, BigDecimal> getExpensesByCategory(Long accountId) {
        List<Transaction> expenses = txRepo.findByBankAccountIdAndType(accountId, "Expense");
        return expenses.stream().collect(Collectors.groupingBy(
                Transaction::getCategory,
                Collectors.mapping(Transaction::getAmount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
        ));
    }

    public Map<String, BigDecimal> getIncomeSources(Long accountId) {
        List<Transaction> income = txRepo.findByBankAccountIdAndType(accountId, "Income");
        return income.stream().collect(Collectors.groupingBy(
                Transaction::getCategory,
                Collectors.mapping(Transaction::getAmount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
        ));
    }
}
