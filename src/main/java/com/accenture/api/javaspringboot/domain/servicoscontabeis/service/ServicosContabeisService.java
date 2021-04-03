package com.accenture.api.javaspringboot.domain.servicoscontabeis.service;

import com.accenture.api.javaspringboot.domain.livrocaixa.domain.LivroCaixa;
import com.accenture.api.javaspringboot.repository.LivroCaixaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicosContabeisService {
    @Autowired
    private LivroCaixaRepository lcr;

    public List<LivroCaixa> registroCliente(int id){
        return lcr.findByClienteId(id);
    }
}
