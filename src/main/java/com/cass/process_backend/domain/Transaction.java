package com.cass.process_backend.domain;

import java.math.BigDecimal;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public record Transaction(
        Long id,
        Integer type,
        Date date,
        BigDecimal amount,
        Long cpf,
        String card,
        Time hour,
        String shopOwner,
        String shopName
) {
    //wither pattern
    public Transaction withValor(BigDecimal amount) {
        return new Transaction(
                id(), type(), date(),
                amount,
                cpf(), card(), hour(), shopOwner(), shopName());
    }

    public Transaction withData(String date) throws ParseException {
        var dateFormat = new SimpleDateFormat("yyyyMMdd");
        var dateP = dateFormat.parse(date);

        return new Transaction(id(), type(),
                new Date(dateP.getTime()),
                amount(), cpf(), card(), hour(), shopOwner(), shopName());
    }

    public Transaction withHora(String hour) throws ParseException {
        var hourFormat = new SimpleDateFormat("HHmmss");
        var hourP = hourFormat.parse(hour);

        return new Transaction(id(), type(), date(), amount(), cpf(), card(),
                new Time(hourP.getTime()),
                shopOwner(), shopName());
    }
}