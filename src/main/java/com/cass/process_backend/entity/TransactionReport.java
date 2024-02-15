package com.cass.process_backend.entity;

import java.math.BigDecimal;
import java.util.List;

public record TransactionReport(
        String shopName,
        BigDecimal total,
        List<Transaction> transactions
) {
    public TransactionReport addTotal(BigDecimal amount) {
        return new TransactionReport(shopName, total.add(amount), transactions);
    }

    public TransactionReport addTransaction(Transaction transaction) {
        transactions.add(transaction);
        return new TransactionReport(shopName, total, transactions);
    }
}
