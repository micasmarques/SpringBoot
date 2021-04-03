//package com.accenture.api.javaspringboot.domain.servicoscontabeis.domain;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "ServicosContabeis")
//public class ServicosContabeis {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//
//    @Column(name = "ID")
//    private int ID;
//
//    @Column(name = "nome")
//    private String nome;
//
//    @Column(name = "cpfCnpj")
//    private String cpfCnpj;
//
//    @Column(name = "telefone")
//    private String telefone;
//
//    @ManyToOne
//    @Column(name = "contabil")
//    private Contabil contabilList;
//
//    public int getID() {
//        return ID;
//    }
//
//    public ServicosContabeis setID(int ID) {
//        this.ID = ID;
//        return this;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public ServicosContabeis setNome(String nome) {
//        this.nome = nome;
//        return this;
//    }
//
//    public String getCpfCnpj() {
//        return cpfCnpj;
//    }
//
//    public ServicosContabeis setCpfCnpj(String cpfCnpj) {
//        this.cpfCnpj = cpfCnpj;
//        return this;
//    }
//
//    public String getTelefone() {
//        return telefone;
//    }
//
//    public ServicosContabeis setTelefone(String telefone) {
//        this.telefone = telefone;
//        return this;
//    }
//
//    public List<Contabil> getContabilList() {
//        return contabilList;
//    }
//
//    public ServicosContabeis setContabilList(List<Contabil> contabilList) {
//        this.contabilList = contabilList;
//        return this;
//    }
//}
