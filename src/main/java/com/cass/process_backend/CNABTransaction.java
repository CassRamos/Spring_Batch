package com.cass.process_backend;

import java.math.BigDecimal;

public record CNABTransaction(Integer type,
                              String date,
                              BigDecimal amount,
                              Long cpf,
                              String card,
                              String hour,
                              String shopOwner,
                              String shopName) {


}

