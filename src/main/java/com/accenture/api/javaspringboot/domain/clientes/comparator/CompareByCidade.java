package com.accenture.api.javaspringboot.domain.clientes.comparator;

import com.accenture.api.javaspringboot.domain.clientes.domain.Cliente;

import java.util.Comparator;

public class CompareByCidade implements Comparator<Cliente> {
    public int compare(Cliente cliente1, Cliente cliente2) {
        return cliente1.getCidade().compareTo(cliente2.getCidade());
    }
}
