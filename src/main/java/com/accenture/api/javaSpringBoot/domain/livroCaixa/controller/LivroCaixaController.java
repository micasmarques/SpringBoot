package com.accenture.api.javaSpringBoot.domain.livroCaixa.controller;

import com.accenture.api.javaSpringBoot.domain.respostaDelete.ResponseDell;
import com.accenture.api.javaSpringBoot.domain.clientes.domain.Cliente;
import com.accenture.api.javaSpringBoot.domain.livroCaixa.domain.LivroCaixa;
import com.accenture.api.javaSpringBoot.domain.livroCaixa.DTO.LivroCaixaDTO;
import com.accenture.api.javaSpringBoot.repository.ClienteRepository;
import com.accenture.api.javaSpringBoot.repository.LivroCaixaRepository;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LivroCaixaController {
    private final LivroCaixaRepository livroCaixaRepository;
    private final ClienteRepository clienteRepository;


    public LivroCaixaController(LivroCaixaRepository livroCaixaRepository, ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
        this.livroCaixaRepository = livroCaixaRepository;
    }

    // Listar Produtos
    @RequestMapping(value = "/livroCaixa", method = RequestMethod.GET)
    public @ResponseBody
    List<LivroCaixa> listar(){
        return livroCaixaRepository.findAll();
    }

    //cadastrar produtos
    @RequestMapping(value = "/livroCaixa", method = RequestMethod.POST)
    public @ResponseBody LivroCaixa cadastrar(@RequestBody LivroCaixaDTO livroCaixaDTO) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Cliente cli = clienteRepository.findById(livroCaixaDTO.getCliente()).
                orElseThrow(()->new RuntimeException("Registro não encontrado"));
        LivroCaixa livroCaixa = new LivroCaixa(livroCaixaDTO.getDataLancamento(),
                livroCaixaDTO.getDescricao(), livroCaixaDTO.getTipo(),
                livroCaixaDTO.getValor(), cli);
        return livroCaixaRepository.save(livroCaixa);
    }

    //filtrar produtos
    @RequestMapping(value = "/livroCaixa/{codigo}", method = RequestMethod.GET)
    public @ResponseBody Optional<LivroCaixa> filtrar(@PathVariable Integer codigo){
        return livroCaixaRepository.findById(codigo);
    }

    //alterar produtos
    @RequestMapping(value = "/livroCaixa", method = RequestMethod.PUT)
    public @ResponseBody LivroCaixa alterar(@RequestBody LivroCaixa livroCaixa){
        return livroCaixaRepository.save(livroCaixa);
    }

    //deletar produtos
    @RequestMapping(value = "/livroCaixa/{codigo}", method = RequestMethod.DELETE)
    public @ResponseBody
    ResponseDell deletar(@PathVariable Integer codigo){
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

    // ordenando por email / Codigo = 0
    // ordenanod por nome / codigo = 1
//    @RequestMapping(value = "/livroCaixa/order/{codigo}", method = RequestMethod.GET)
//    public @ResponseBody List<? extends Object> filterBy(@PathVariable String codigo){
//        List<Usuario> lista = this.listar();
//        switch (codigo) {
//            case "email":
//                Collections.sort(lista, new CompareUsersByEmail());
//                return lista;
//            case "nome":
//                Collections.sort(lista, new CompareUsersByNome());
//                return lista;
//            default:
//                List<String> list = null;
//                list.add("Filtro invalido. Tente novamente");
//                return list;
//        }
//    }
}
