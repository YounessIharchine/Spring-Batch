package com.example.spring_batch_tp.config.transaction;

import com.example.spring_batch_tp.config.transaction.model.TransactionItem;
import com.example.spring_batch_tp.model.Transaction;
import com.example.spring_batch_tp.repository.AccountRepository;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TransactionProcessor implements ItemProcessor<TransactionItem, Transaction> {

    @Autowired
    AccountRepository accountRepository;

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    @Override
    public Transaction process(TransactionItem item) throws Exception {
        Transaction transaction = new Transaction();
        transaction.setTransactionId((item.getTransactionId()));
        transaction.setAmount(item.getAmount());
        transaction.setTransactionDate(dateFormat.parse(item.getTransactionDate()));
        transaction.setDebitDate(dateFormat.parse(dateFormat.format(new Date())));
        transaction.setAccount(accountRepository.findById(item.getAccountId()));
        return transaction;
    }


}