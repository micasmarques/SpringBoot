package com.accenture.api.javaspringboot.repository;

import com.accenture.api.javaspringboot.domain.clientes.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
