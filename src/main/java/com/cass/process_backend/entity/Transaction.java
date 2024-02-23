package com.cass.process_backend.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.math.BigDecimal;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public record Transaction(
        @Id
        Long id,
        Integer type,
        Date date,
        BigDecimal amount,
        Long cpf,
        String card,
        Time hour,
        //postgreSQL don't restrict to uppercase column names
        @Column("shop_owner")
        String shopOwner,
        @Column("shop_owner")
        String shopName
) {
    //wither pattern
    public Transaction withAmount(BigDecimal amount) {
        return new Transaction(
                id(), type(), date(),
                amount,
                cpf(), card(), hour(), shopOwner(), shopName());
    }

    public Transaction withDate(String date) throws ParseException {
        var dateFormat = new SimpleDateFormat("yyyyMMdd");
        var dateP = dateFormat.parse(date);

        return new Transaction(id(), type(),
                new Date(dateP.getTime()),
                amount(), cpf(), card(), hour(), shopOwner(), shopName());
    }

    public Transaction withHour(String hour) throws ParseException {
        var hourFormat = new SimpleDateFormat("HHmmss");
        var hourP = hourFormat.parse(hour);

        return new Transaction(id(), type(), date(), amount(), cpf(), card(),
                new Time(hourP.getTime()),
                shopOwner(), shopName());
    }
}