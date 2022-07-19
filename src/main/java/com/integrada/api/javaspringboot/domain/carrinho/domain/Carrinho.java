package com.integrada.api.javaspringboot.domain.carrinho.domain;

import com.integrada.api.javaspringboot.domain.produto.domain.Produto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@Table(name = "Carrinho")
public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @Getter
    @Setter
    private Integer id;

    @Column(name = "PRODUTOS", nullable = false)
    @Getter
    @Setter
    @ManyToMany
    @JoinTable(name="Produto",
            joinColumns={@JoinColumn(name="ID")})
    private List<Produto> produtos;
}
