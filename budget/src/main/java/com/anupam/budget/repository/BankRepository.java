package com.anupam.budget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anupam.budget.model.BankAccount;

@Repository
public interface BankRepository extends JpaRepository<BankAccount,Long>{

}
