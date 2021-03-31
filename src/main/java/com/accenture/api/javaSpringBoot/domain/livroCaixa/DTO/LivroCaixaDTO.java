package com.accenture.api.javaSpringBoot.domain.livroCaixa.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class LivroCaixaDTO {
    private int id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataLancamento;
    private String descricao;
    private String tipo;
    private float valor;
    private int cliente;

    public LivroCaixaDTO() {
    }

    public LivroCaixaDTO(Date dataLancamento, String descricao, String tipo, float valor, int cliente) {
        this.dataLancamento = dataLancamento;
        this.descricao = descricao;
        this.tipo = tipo;
        this.valor = valor;
        this.cliente = cliente;
    }

    public LivroCaixaDTO(int id, Date dataLancamento, String descricao, String tipo, float valor, int cliente) {
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

    public LivroCaixaDTO setId(int id) {
        this.id = id;
        return this;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public LivroCaixaDTO setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public LivroCaixaDTO setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public String getTipo() {
        return tipo;
    }

    public LivroCaixaDTO setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public float getValor() {
        return valor;
    }

    public LivroCaixaDTO setValor(float valor) {
        this.valor = valor;
        return this;
    }

    public int getCliente() {
        return cliente;
    }

    public LivroCaixaDTO setCliente(int cliente) {
        this.cliente = cliente;
        return this;
    }
}
