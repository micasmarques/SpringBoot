package com.accenture.api.javaspringboot.domain.usuarios.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ID")
    private Integer id;

    @Column(name = "DATA_CADASTRO", nullable = false)
    private LocalDate dataCadastro;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "LOGIN", nullable = false)
    private String login;

    @Column(name = "SENHA", nullable = false)
    private String senha;

    @Column(name = "TELEFONE")
    private String telefone;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PERFIL", nullable = false)
    private String perfil;

    @Column(name = "STATUS", nullable = false)
    private String status;

    public Integer getId() {
        return id;
    }

    public Usuario setId(Integer id) {
        this.id = id;
        return this;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public Usuario setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Usuario setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public Usuario setLogin(String logim) {
        this.login = logim;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public Usuario setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public Usuario setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Usuario setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPerfil() {
        return perfil;
    }

    public Usuario setPerfil(String perfil) {
        this.perfil = perfil;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Usuario setStatus(String status) {
        this.status = status;
        return this;
    }

}
