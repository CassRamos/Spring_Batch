package com.cass.process_backend;

import java.math.BigDecimal;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public record Transacao(
        Long id,
        Integer tipo,
        Date data,
        BigDecimal valor,
        Long cpf,
        String cartao,
        Time hora,
        String donoDaLoja,
        String nomeDaLoja
) {
    //wither pattern
    public Transacao withValor(BigDecimal valor) {
        return new Transacao(
                this.id(), this.tipo(), this.data(),
                valor,
                this.cpf(), this.cartao(), this.hora(), this.donoDaLoja(), this.nomeDaLoja());
    }

    public Transacao withData(String data) throws ParseException {
        var dateFormat = new SimpleDateFormat("yyyyMMdd");
        var dateP = dateFormat.parse(data);

        return new Transacao(this.id(), this.tipo(),
                new Date(dateP.getTime()),
                this.valor(), this.cpf(), this.cartao(), this.hora(), this.donoDaLoja(), this.nomeDaLoja());
    }

    public Transacao withHora(String hora) throws ParseException {
        var hourFormat = new SimpleDateFormat("HHmmss");
        var hourP = hourFormat.parse(hora);

        return new Transacao(this.id(), this.tipo(), this.data(), this.valor(), this.cpf(), this.cartao(),
                new Time(hourP.getTime()),
                this.donoDaLoja(), this.nomeDaLoja());
    }
}