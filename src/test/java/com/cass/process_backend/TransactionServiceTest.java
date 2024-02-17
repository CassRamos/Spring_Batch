package com.cass.process_backend;

import com.cass.process_backend.entity.Transaction;
import com.cass.process_backend.repository.TransactionRepository;
import com.cass.process_backend.service.TransactionService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {

    @InjectMocks
    private TransactionService service;

    @Mock
    private TransactionRepository repository;

    @Test
    public void testListTransactionsTotalByShopName() {
        final String store1 = "Store 1", store2 = "Store 2";

        var transaction1 = new Transaction(
                1L, 1, new Date(System.currentTimeMillis()),
                BigDecimal.valueOf(100.00), 52426918309L,
                "4353-6921-4491-3192",
                new Time(System.currentTimeMillis()),
                "shopOwner1", store1);

        var transaction2 = new Transaction(
                2L, 1, new Date(System.currentTimeMillis()),
                BigDecimal.valueOf(50.0), 48560694587L,
                "0258-2633-4999-2587",
                new Time(System.currentTimeMillis()),
                "shopOwner2", store2);

        var transaction3 = new Transaction(
                3L, 1, new Date(System.currentTimeMillis()),
                BigDecimal.valueOf(75.0), 15214879648L,
                "7985-4618-5687-0202",
                new Time(System.currentTimeMillis()),
                "shopOwner1", store1);

        var mockTransactions = List.of(transaction1, transaction2, transaction3);

        when(repository.findAllByOrderByShopNameAscIdDesc())
                .thenReturn(mockTransactions);

        var reports = service.listTransactionsTotalByShopName();

        assertEquals(2, reports.size());

        reports.forEach(report ->{
            if (report.shopName().equals(store1)){
                assertEquals(2,report.transactions().size());
                assertEquals(BigDecimal.valueOf(175.0),report.total());
                assertTrue(report.transactions().contains(transaction1));
                assertTrue(report.transactions().contains(transaction3));
            } else if (report.shopName().equals(store2)) {
                assertEquals(1, report.transactions().size());
                assertEquals(BigDecimal.valueOf(50.0),report.total());
                assertTrue(report.transactions().contains(transaction2));
            }
        });

    }

}
