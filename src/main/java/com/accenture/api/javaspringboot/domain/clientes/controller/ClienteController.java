package com.accenture.api.javaspringboot.domain.clientes.controller;


import com.accenture.api.javaspringboot.domain.respostaDelete.ResponseDell;
import com.accenture.api.javaspringboot.domain.clientes.comparator.CompareByCidade;
import com.accenture.api.javaspringboot.domain.clientes.comparator.CompareByCpfCnpj;
import com.accenture.api.javaspringboot.domain.clientes.comparator.CompareByName;
import com.accenture.api.javaspringboot.domain.clientes.comparator.CompareByUF;
import com.accenture.api.javaspringboot.domain.clientes.domain.Cliente;
import com.accenture.api.javaspringboot.repository.ClienteRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ClienteController {
    private final ClienteRepository acoes;

    public ClienteController(ClienteRepository acoes) {
        this.acoes = acoes;
    }

    // Listar Produtos
    @RequestMapping(value = "/clientes", method = RequestMethod.GET)
    public @ResponseBody
    List<Cliente> listar(){
        return acoes.findAll();
    }

    //cadastrar produtos
    @RequestMapping(value = "/clientes", method = RequestMethod.POST)
    public @ResponseBody Cliente cadastrar(@RequestBody Cliente cliente){
        cliente.setDataCadastro(LocalDate.now());
        return acoes.save(cliente);
    }

    //filtrar produtos
    @RequestMapping(value = "/clientes/{codigo}", method = RequestMethod.GET)
    public @ResponseBody Cliente filtrar(@PathVariable Integer codigo){
        return acoes.findById(codigo).
                orElseThrow(()->new RuntimeException("Cliente não encontrado"));
    }

    //alterar produtos
    @RequestMapping(value = "/clientes", method = RequestMethod.PUT)
    public @ResponseBody Cliente alterar(@RequestBody Cliente cliente){
        return acoes.save(cliente);
    }

    //deletar produtos
    @RequestMapping(value = "/clientes/{codigo}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseDell deletar(@PathVariable Integer codigo){
        ResponseDell response = new ResponseDell();
        try{
            Cliente cliente = filtrar(codigo);
            acoes.delete(cliente);
            response.setMensage("Cliente removido com sucesso");
        } catch (Exception erro){
            response.setMensage("Erro!!!!! Falha ao remover: " + erro.getMessage());
        }
        return response;
    }

    // ordenando por nome, cpfcnpj, cidade, uf
    @RequestMapping(value = "/clientes/order/{codigo}", method = RequestMethod.GET)
    public @ResponseBody List<? extends Object> filterBy(@PathVariable String codigo){
        List<Cliente> lista = this.listar();
        switch (codigo) {
            case "nome":
                Collections.sort(lista, new CompareByName());
                return lista;
            case "cpfCnpj":
                Collections.sort(lista, new CompareByCpfCnpj());
                return lista;
            case "cidade":
                Collections.sort(lista, new CompareByCidade());
                return lista;
            case "uf":
                Collections.sort(lista, new CompareByUF());
                return lista;
            default:
                return lista;
        }
    }
}
