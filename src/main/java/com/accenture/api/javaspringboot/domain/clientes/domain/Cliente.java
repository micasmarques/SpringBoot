package com.accenture.api.javaspringboot.domain.clientes.domain;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "Clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "DATA_CADASTRO", nullable = false)
    private LocalDate dataCadastro;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "cpfCnpj", nullable = false)
    private String cpfCnpj;

    @Column(name = "logradouro", nullable = false)
    private String logradouro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "uf")
    private String uf;

    @Column(name = "cep", nullable = false)
    private String cep;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "EMAIL")
    private String email;

    public Cliente() {
    }

    public Cliente(Integer id, LocalDate dataCadastro, String nome, String cpfCnpj, String logradouro, String cidade, String uf, String cep, String email) {
        this.id = id;
        this.dataCadastro = dataCadastro;
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.email = email;
    }

    public Cliente(Integer id, LocalDate dataCadastro, String nome, String cpfCnpj, String logradouro, String cidade, String uf, String cep, String telefone, String email) {
        this.id = id;
        this.dataCadastro = dataCadastro;
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.telefone = telefone;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public Cliente setId(Integer id) {
        this.id = id;
        return this;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public Cliente setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Cliente setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public Cliente setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
        return this;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public Cliente setLogradouro(String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    public String getCidade() {
        return cidade;
    }

    public Cliente setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public String getUf() {
        return uf;
    }

    public Cliente setUf(String uf) {
        this.uf = uf;
        return this;
    }

    public String getCep() {
        return cep;
    }

    public Cliente setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public Cliente setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Cliente setEmail(String email) {
        this.email = email;
        return this;
    }
}
