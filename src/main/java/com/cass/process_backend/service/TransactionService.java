package com.cass.process_backend.service;

import com.cass.process_backend.entity.Transaction;
import com.cass.process_backend.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<Transaction> listTransactionsTotalByShopName() {
        return repository.findAllByOrderByShopNameAscIdDesc();
    }
}
