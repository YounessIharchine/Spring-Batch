package com.example.spring_batch_tp.repository;

import com.example.spring_batch_tp.model.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

    Transaction findById(int id);
}