package com.accenture.api.javaSpringBoot.domain.servicosContabeis.controller;

import com.accenture.api.javaSpringBoot.domain.livroCaixa.controller.LivroCaixaController;
import com.accenture.api.javaSpringBoot.domain.livroCaixa.domain.LivroCaixa;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ServicosContabeis {

    private final LivroCaixaController livroCaixaController;

    public ServicosContabeis(LivroCaixaController livroCaixaController) {
        this.livroCaixaController = livroCaixaController;
    }

    @RequestMapping(value = "/servicosContabeis/{codigo}", method = RequestMethod.GET)
    public @ResponseBody List<LivroCaixa> filtrar(@PathVariable Integer codigo){
        List<LivroCaixa> todos = livroCaixaController.listar();
        List<LivroCaixa> filtro = new ArrayList<>();
        for (LivroCaixa livro : todos) {
            if (livro.getCliente().getId().equals(codigo))
                filtro.add(livro);
        }
        return filtro;
    }
}