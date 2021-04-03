package com.accenture.api.javaspringboot.domain.livrocaixa.domain;

import com.accenture.api.javaspringboot.domain.clientes.domain.Cliente;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "LivroCaixa")
public class LivroCaixa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "Data_Lancamento", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataLancamento;

    @Column(name = "Descricao", nullable = false)
    private String descricao;

    @Column(name = "Tipo", nullable = false)
    private String tipo;

    @Column(name = "Valor",nullable = false)
    private float valor;

    @ManyToOne
    private Cliente cliente;

    public LivroCaixa() {
    }

    public LivroCaixa(int id, Date dataLancamento, String descricao, String tipo, float valor) {
        this.id = id;
        this.dataLancamento = dataLancamento;
        this.descricao = descricao;
        this.tipo = tipo;
        this.valor = valor;
    }

    public LivroCaixa(Date dataLancamento, String descricao, String tipo, float valor, Cliente cliente) {
        this.dataLancamento = dataLancamento;
        this.descricao = descricao;
        this.tipo = tipo;
        this.valor = valor;
        this.cliente = cliente;
    }

    public LivroCaixa(int id, Date dataLancamento, String descricao, String tipo, float valor, Cliente cliente) {
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

    public LivroCaixa setId(int id) {
        this.id = id;
        return this;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public LivroCaixa setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public LivroCaixa setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public String getTipo() {
        return tipo;
    }

    public LivroCaixa setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public float getValor() {
        return valor;
    }

    public LivroCaixa setValor(float valor) {
        this.valor = valor;
        return this;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LivroCaixa setCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }
}
