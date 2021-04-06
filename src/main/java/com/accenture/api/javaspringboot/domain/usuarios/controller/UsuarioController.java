package com.accenture.api.javaspringboot.domain.usuarios.controller;

import com.accenture.api.javaspringboot.domain.respostaDelete.ResponseDell;
import com.accenture.api.javaspringboot.domain.usuarios.comparator.CompareUsersByEmail;
import com.accenture.api.javaspringboot.domain.usuarios.comparator.CompareUsersByNome;
import com.accenture.api.javaspringboot.domain.usuarios.domain.Usuario;
import com.accenture.api.javaspringboot.domain.usuarios.services.UsuarioService;
import com.accenture.api.javaspringboot.repository.UsuarioRepository;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
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
        usuario.setDataCadastro(LocalDate.now());
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
            case "email":
                lista.sort(new CompareUsersByEmail());
                return lista;
            case "nome":
                lista.sort(new CompareUsersByNome());
                return lista;
            default:
                return lista;
        }
    }

    @GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
        return usuarioService.exportReport(format);
    }
}
