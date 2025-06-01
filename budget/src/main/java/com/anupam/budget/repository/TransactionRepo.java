package com.anupam.budget.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anupam.budget.model.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {
List<Transaction> findByBankAccountId(Long accountId);
    List<Transaction> findByBankAccountIdAndType(Long accountId, String type);
}
