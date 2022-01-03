package com.example.spring_batch_tp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transaction {

    @Id
    int transactionId;

    @ManyToOne
    @JoinColumn(name = "account_id")
    Account account;

    double amount;
    Date transactionDate;
    Date debitDate;

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Date getDebitDate() {
        return debitDate;
    }

    public void setDebitDate(Date debitDate) {
        this.debitDate = debitDate;
    }
}
