package com.integrada.api.javaspringboot.domain.usuario.controller;

import com.integrada.api.javaspringboot.domain.response_delete.ResponseDell;
import com.integrada.api.javaspringboot.domain.usuario.comparator.CompareUsersById;
import com.integrada.api.javaspringboot.domain.usuario.comparator.CompareUsersByNome;
import com.integrada.api.javaspringboot.domain.usuario.domain.Usuario;
import com.integrada.api.javaspringboot.domain.usuario.service.UsuarioService;
import com.integrada.api.javaspringboot.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioRepository acoes;
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioRepository acoes, UsuarioService usuarioService) {
        this.acoes = acoes;
        this.usuarioService = usuarioService;
    }

    //     Listar Produtos
    @GetMapping(value = "/usuarios")
    public List<Usuario> listar() {
        return acoes.findAll();
    }

    //    cadastrar produtos
    @PostMapping(value = "/usuarios")
    public @ResponseBody Usuario cadastrar(@RequestBody Usuario usuario){
        return acoes.save(usuario);
    }

    //filtrar produtos
    @GetMapping(value = "/usuarios/{codigo}")
    public Usuario filtrar(@PathVariable Integer codigo) {
        return acoes.findById(codigo)
                .orElseThrow(()->new RuntimeException("Usuario não encontrado"));
    }

    //alterar produtos
    @PutMapping(value = "/usuarios")
    public Usuario alterar(@RequestBody Usuario user) {
        return acoes.save(user);
    }

    //deletar produtos
    @DeleteMapping(value = "/usuarios/{codigo}")
    public @ResponseBody ResponseDell deletar(@PathVariable Integer codigo) {
        ResponseDell response = new ResponseDell();
        try {
            Usuario usuario = filtrar(codigo);
            acoes.delete(usuario);
            response.setMensage("Usuario removido com sucesso");
        } catch (Exception erro) {
            response.setMensage("Erro!!!!! Falha ao remover: " + erro.getMessage());
        }
        return response;
    }

    @RequestMapping("/login")
    public ResponseEntity<String> login(@RequestParam(value = "login") String login, @RequestParam(value = "senha") String senha){
        String msg = usuarioService.verificaLoginAndSenha(login, senha);
        return ResponseEntity.ok().body(msg);
    }

    @GetMapping(value = "/usuarios/order/{codigo}")
    public @ResponseBody List<Usuario> filterBy(@PathVariable String codigo) {
        List<Usuario> lista = this.listar();
        switch (codigo) {
            case "id":
                lista.sort((Comparator<? super Usuario>) new CompareUsersById());
                return lista;
            case "nome":
                lista.sort((Comparator<? super Usuario>) new CompareUsersByNome());
                return lista;
            default:
                return lista;
        }
    }
}
