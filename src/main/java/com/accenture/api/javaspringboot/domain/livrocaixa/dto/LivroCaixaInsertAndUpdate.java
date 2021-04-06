package com.accenture.api.javaspringboot.domain.livrocaixa.dto;

import com.accenture.api.javaspringboot.domain.clientes.domain.Cliente;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

public class LivroCaixaInsertAndUpdate {
    private int id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataLancamento;
    private String descricao;
    private String tipo;
    private float valor;
    private int cliente;

    public LivroCaixaInsertAndUpdate() {
    }

    public LivroCaixaInsertAndUpdate(Date dataLancamento, String descricao, String tipo, float valor, int cliente) {
        this.dataLancamento = dataLancamento;
        this.descricao = descricao;
        this.tipo = tipo;
        this.valor = valor;
        this.cliente = cliente;
    }

    public LivroCaixaInsertAndUpdate(int id, Date dataLancamento, String descricao, String tipo, float valor, int cliente) {
        this.id = id;
        this.dataLancamento = dataLancamento;
        this.descricao = descricao;
        this.tipo = tipo;
        this.valor = valor;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public LivroCaixaInsertAndUpdate setId(int id) {
        this.id = id;
        return this;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public LivroCaixaInsertAndUpdate setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public LivroCaixaInsertAndUpdate setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public String getTipo() {
        return tipo;
    }

    public LivroCaixaInsertAndUpdate setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public float getValor() {
        return valor;
    }

    public LivroCaixaInsertAndUpdate setValor(float valor) {
        this.valor = valor;
        return this;
    }

    public int getCliente() {
        return cliente;
    }

    public LivroCaixaInsertAndUpdate setCliente(int cliente) {
        this.cliente = cliente;
        return this;
    }
}
