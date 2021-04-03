package com.accenture.api.javaspringboot.repository;

import com.accenture.api.javaspringboot.domain.livrocaixa.domain.LivroCaixa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface LivroCaixaRepository extends JpaRepository<LivroCaixa, Integer> {
    List<LivroCaixa> findByClienteId(int id);
    List<LivroCaixa> findByDataLancamentoBetweenAndClienteId(Date start, Date end, int id);
}
