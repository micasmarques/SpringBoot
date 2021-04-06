package com.accenture.api.javaspringboot.domain.livrocaixa.controller;

import com.accenture.api.javaspringboot.domain.clientes.domain.Cliente;
import com.accenture.api.javaspringboot.domain.livrocaixa.comparator.CompareByIDCliente;
import com.accenture.api.javaspringboot.domain.livrocaixa.domain.LivroCaixa;
import com.accenture.api.javaspringboot.domain.livrocaixa.dto.LivroCaixaInsertAndUpdate;
import com.accenture.api.javaspringboot.domain.respostaDelete.ResponseDell;
import com.accenture.api.javaspringboot.repository.ClienteRepository;
import com.accenture.api.javaspringboot.repository.LivroCaixaRepository;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LivroCaixaController {
    private final LivroCaixaRepository livroCaixaRepository;
    private final ClienteRepository clienteRepository;
    private final CompareByIDCliente compare = new CompareByIDCliente();


    public LivroCaixaController(LivroCaixaRepository livroCaixaRepository, ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
        this.livroCaixaRepository = livroCaixaRepository;
    }

    // Listar Produtos
    @GetMapping(value = "/livroCaixa")
    public @ResponseBody
    List<LivroCaixa> listar(){
        return livroCaixaRepository.findAll();
    }

    //cadastrar produtos
    @PostMapping (value = "/livroCaixa")
    public @ResponseBody LivroCaixa cadastrar(@RequestBody LivroCaixaInsertAndUpdate livroCaixa) {
        Cliente cli = clienteRepository.findById(livroCaixa.getCliente()).orElseThrow(()->new RuntimeException("Registro não encontrado"));
        LivroCaixa lc = new LivroCaixa(livroCaixa.getDataLancamento(),
                livroCaixa.getDescricao(), livroCaixa.getTipo(),
                livroCaixa.getValor(), cli);
        return livroCaixaRepository.save(lc);
    }

    //filtrar produtos
    @GetMapping(value = "/livroCaixa/{codigo}")
    public @ResponseBody Optional<LivroCaixa> filtrar(@PathVariable Integer codigo){
        return livroCaixaRepository.findById(codigo);
    }

    //alterar produtos
    @PutMapping(value = "/livroCaixa")
    public @ResponseBody LivroCaixa alterar(@RequestBody LivroCaixa livroCaixa){
        return livroCaixaRepository.save(livroCaixa);
    }

    //deletar produtos
    @DeleteMapping(value = "/livroCaixa/{codigo}")
    public @ResponseBody ResponseDell deletar(@PathVariable Integer codigo){
        ResponseDell response = new ResponseDell();
        try{
            LivroCaixa livroCaixa = filtrar(codigo).
            orElseThrow(()->new RuntimeException("Livro não encontrado"));
            livroCaixaRepository.delete(livroCaixa);
            response.setMensage("Registro removido com sucesso");
        } catch (Exception erro){
            response.setMensage("Erro!!!!! Falha ao remover: " + erro.getMessage());
        }
        return response;
    }

    @GetMapping(value = "/livroCaixa/order")
    public @ResponseBody List<LivroCaixa> filterBy(){
        List<LivroCaixa> lista = this.listar();
        lista.sort(compare);
        return lista;
    }
}