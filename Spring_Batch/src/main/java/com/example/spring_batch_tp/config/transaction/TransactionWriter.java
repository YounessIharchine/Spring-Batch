package com.example.spring_batch_tp.config.transaction;

import com.example.spring_batch_tp.model.Transaction;
import com.example.spring_batch_tp.repository.TransactionRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionWriter implements ItemWriter<Transaction> {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public void write(List<? extends Transaction> transactions) throws Exception {
        transactionRepository.saveAll(transactions);
    }

}
