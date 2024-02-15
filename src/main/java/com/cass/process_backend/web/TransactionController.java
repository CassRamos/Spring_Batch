package com.cass.process_backend.web;

import com.cass.process_backend.entity.Transaction;
import com.cass.process_backend.entity.TransactionReport;
import com.cass.process_backend.service.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    List<TransactionReport> listAll() {
        return transactionService.listTransactionsTotalByShopName();
    }

}
