package com.cass.process_backend.service;

import com.cass.process_backend.entity.TransactionReport;
import com.cass.process_backend.entity.TransactionType;
import com.cass.process_backend.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<TransactionReport> listTransactionsTotalByShopName() {
        var transactions = repository.findAllByOrderByShopNameAscIdDesc();
        var reportMap = new LinkedHashMap<String, TransactionReport>();

        transactions.forEach(transaction -> {
            String shopName = transaction.shopName();
            BigDecimal amount = transaction.amount();

            reportMap.compute(shopName, (key, existingReport) -> {
                var report = (existingReport != null) ? existingReport :
                        new TransactionReport(key, BigDecimal.ZERO, new ArrayList<>());

                return report.addTotal(amount).addTransaction(transaction);
            });
        });
        return new ArrayList<>(reportMap.values());
    }
}
