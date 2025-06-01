package com.anupam.budget.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
public class BankAccount {
    @Id @GeneratedValue
    private Long id;
    private String ownerName;
    private BigDecimal initialAmount;
    public BankAccount(String ownerName, BigDecimal initialAmount) {
        this.ownerName = ownerName;
        this.initialAmount = initialAmount;
    }
}
