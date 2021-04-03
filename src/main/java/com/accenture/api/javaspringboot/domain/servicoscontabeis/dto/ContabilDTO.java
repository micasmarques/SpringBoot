package com.accenture.api.javaspringboot.domain.servicoscontabeis.dto;

import com.accenture.api.javaspringboot.domain.livrocaixa.dto.LivroCaixaDTO;

import java.util.ArrayList;
import java.util.List;

public class ContabilDTO {
    private Integer id;
    private String nome;
    private String cpfCnpj;
    private String telefone;
    private List<LivroCaixaDTO> contabilList = new ArrayList<>();

    public ContabilDTO() {
    }

    public ContabilDTO(String nome, String cpfCnpj, String telefone, List<LivroCaixaDTO> contabilList) {
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.telefone = telefone;
        this.contabilList = contabilList;
    }

    public ContabilDTO(Integer id, String nome, String cpfCnpj, String telefone, List<LivroCaixaDTO> contabilList) {
        this.id = id;
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.telefone = telefone;
        this.contabilList = contabilList;
    }

    public Integer getId() {
        return id;
    }

    public ContabilDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public ContabilDTO setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public ContabilDTO setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public ContabilDTO setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public List<LivroCaixaDTO> getContabilList() {
        return contabilList;
    }

    public ContabilDTO setContabilList(List<LivroCaixaDTO> contabilList) {
        this.contabilList = contabilList;
        return this;
    }
}
