package com.example.spring_batch_tp.repository;

import com.example.spring_batch_tp.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {

    Account findById(int id);

}