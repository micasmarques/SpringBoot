package com.accenture.api.javaSpringBoot.domain.clientes.comparator;

import com.accenture.api.javaSpringBoot.domain.clientes.domain.Cliente;

import java.util.Comparator;

public class CompareByCpfCnpj implements Comparator<Cliente> {
    public int compare(Cliente cliente1, Cliente cliente2) {
        return cliente1.getCpfCnpj().compareTo(cliente2.getCpfCnpj());
    }
}
