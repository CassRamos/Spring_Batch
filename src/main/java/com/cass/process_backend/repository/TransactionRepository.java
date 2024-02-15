package com.cass.process_backend.repository;

import com.cass.process_backend.entity.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    List<Transaction> findAllByOrderByShopNameAscIdDesc();
}
