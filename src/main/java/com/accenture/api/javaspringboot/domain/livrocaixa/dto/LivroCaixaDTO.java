package com.accenture.api.javaspringboot.domain.livrocaixa.dto;

import com.accenture.api.javaspringboot.domain.livrocaixa.domain.LivroCaixa;

import java.util.Date;

public class LivroCaixaDTO extends LivroCaixa {
    private Double saldo;

    public LivroCaixaDTO(Double saldo) {
        this.saldo = saldo;
    }

    public LivroCaixaDTO(int id, Date dataLancamento, String descricao, String tipo, float valor, Double saldo) {
        super(id, dataLancamento, descricao, tipo, valor);
        this.saldo = saldo;
    }

    public Double getSaldo() {
        return saldo;
    }

    public LivroCaixaDTO setSaldo(Double saldo) {
        this.saldo = saldo;
        return this;
    }
}
