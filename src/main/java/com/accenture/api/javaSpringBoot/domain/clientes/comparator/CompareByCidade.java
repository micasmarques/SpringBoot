package com.accenture.api.javaSpringBoot.domain.clientes.comparator;

import com.accenture.api.javaSpringBoot.domain.clientes.domain.Cliente;

import java.util.Comparator;

public class CompareByCidade implements Comparator<Cliente> {
    public int compare(Cliente cliente1, Cliente cliente2) {
        return cliente1.getCidade().compareTo(cliente2.getCidade());
    }
}
