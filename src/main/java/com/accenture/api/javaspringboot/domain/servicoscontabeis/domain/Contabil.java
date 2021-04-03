package com.accenture.api.javaspringboot.domain.servicoscontabeis.domain;

import com.accenture.api.javaspringboot.domain.livrocaixa.dto.LivroCaixaDTO;

import java.util.ArrayList;
import java.util.List;

public class Contabil {
    private Integer id;
    private String nome;
    private String cpfCnpj;
    private String telefone;
    private List<LivroCaixaDTO> contabilList = new ArrayList<>();

    public Contabil(Integer id, String nome, String cpfCnpj, String telefone, List<LivroCaixaDTO> contabilList) {
        this.id = id;
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.telefone = telefone;
        this.contabilList = contabilList;
    }

    public Contabil() {
    }

    public Integer getId() {
        return id;
    }

    public Contabil setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Contabil setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public Contabil setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public Contabil setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public List<LivroCaixaDTO> getContabilList() {
        return contabilList;
    }

    public Contabil setContabilList(List<LivroCaixaDTO> contabilList) {
        this.contabilList = contabilList;
        return this;
    }
}
