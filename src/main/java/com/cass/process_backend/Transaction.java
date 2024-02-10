package com.cass.process_backend;

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
                this.id(), this.type(), this.date(),
                amount,
                this.cpf(), this.card(), this.hour(), this.shopOwner(), this.shopName());
    }

    public Transaction withData(String date) throws ParseException {
        var dateFormat = new SimpleDateFormat("yyyyMMdd");
        var dateP = dateFormat.parse(date);

        return new Transaction(this.id(), this.type(),
                new Date(dateP.getTime()),
                this.amount(), this.cpf(), this.card(), this.hour(), this.shopOwner(), this.shopName());
    }

    public Transaction withHora(String hour) throws ParseException {
        var hourFormat = new SimpleDateFormat("HHmmss");
        var hourP = hourFormat.parse(hour);

        return new Transaction(this.id(), this.type(), this.date(), this.amount(), this.cpf(), this.card(),
                new Time(hourP.getTime()),
                this.shopOwner(), this.shopName());
    }
}