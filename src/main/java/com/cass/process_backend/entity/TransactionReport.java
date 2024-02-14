package com.cass.process_backend.entity;

import java.math.BigDecimal;
import java.util.List;

public class TransactionReport {
    String shopName;
    BigDecimal total;
    List<Transaction> transactions;
}
