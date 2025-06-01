package com.anupam.budget.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@NoArgsConstructor
@Data
@Setter
@Getter
public class Transaction {
    @Id @GeneratedValue
    private Long id;
    private BigDecimal amount;
    private String category;
    private String description;
    private String type; // Income or Expense
    private LocalDate date;

    public Transaction(BigDecimal amount, String category, String description, String type, LocalDate date, BankAccount bankAccount) {
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.type = type;
        this.date = date;
        this.bankAccount = bankAccount;
    }
    @ManyToOne
    private BankAccount bankAccount; 

}
