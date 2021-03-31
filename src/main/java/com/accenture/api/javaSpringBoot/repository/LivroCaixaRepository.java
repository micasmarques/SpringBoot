package com.accenture.api.javaSpringBoot.repository;

import com.accenture.api.javaSpringBoot.domain.livroCaixa.domain.LivroCaixa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroCaixaRepository extends JpaRepository<LivroCaixa, Integer> {
}
