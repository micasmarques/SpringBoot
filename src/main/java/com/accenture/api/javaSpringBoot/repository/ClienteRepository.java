package com.accenture.api.javaSpringBoot.repository;

import com.accenture.api.javaSpringBoot.domain.clientes.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
