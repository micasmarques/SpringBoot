package com.accenture.api.javaSpringBoot.domain.usuarios.controller;

import com.accenture.api.javaSpringBoot.domain.respostaDelete.ResponseDell;
import com.accenture.api.javaSpringBoot.domain.usuarios.comparator.CompareUsersByEmail;
import com.accenture.api.javaSpringBoot.domain.usuarios.comparator.CompareUsersByNome;
import com.accenture.api.javaSpringBoot.domain.usuarios.domain.Usuario;
import com.accenture.api.javaSpringBoot.repository.UsuarioRepository;
import com.sun.istack.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {
    private final UsuarioRepository acoes;

    public UsuarioController(UsuarioRepository acoes) {
        this.acoes = acoes;
    }

    //     Listar Produtos
    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public List<Usuario> listar() {
        return acoes.findAll();
    }

//    cadastrar produtos
    @RequestMapping(value = "/usuarios/save", method = RequestMethod.POST)
    public @ResponseBody Usuario cadastrar(@RequestBody Usuario usuario){
        usuario.setDataCadastro(LocalDate.now());
        return acoes.save(usuario);
    }

    //filtrar produtos
    @RequestMapping(value = "/usuarios/{codigo}", method = RequestMethod.GET)
    public Usuario filtrar(@PathVariable Integer codigo) {
        return acoes.findById(codigo)
                .orElseThrow(()->new RuntimeException("Usuario não encontrado"));
    }

    //alterar produtos
    @RequestMapping(value = "/usuarios", method = RequestMethod.PUT)
    public Usuario alterar(@PathVariable Usuario usuario) {
        return acoes.save(usuario);
    }

    //deletar produtos
    @RequestMapping(value = "/usuarios/{codigo}", method = RequestMethod.DELETE)
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

//    @RequestMapping(value = "/usuarios/{login}-{senha}", method = RequestMethod.GET)
//    public @ResponseBody ResponseEntity<String> findByLoginAndSenha(@PathVariable String login, @PathVariable String senha){
//        List<Usuario> usersList = acoes.findAll();
//        @NotNull
//        Usuario usuario = new Usuario();
//        String msg = "";
//        for (Usuario user: usersList) {
//            if((user.getLogin()).equals(login) && (user.getSenha()).equals(senha))
//                usuario = user;
//        }
//        if (usuario.getStatus().equals("C")) msg = "Usuario está inativado no sistema";
//        else msg = "Usuario " + usuario.getNome() + "foi logado com sucesso.";
//        return ResponseEntity.ok().body(msg);
//    }

    @RequestMapping(value = "/usuarios/order/{codigo}", method = RequestMethod.GET)
    public @ResponseBody List<?> filterBy(@PathVariable String codigo) {
        List<Usuario> lista = this.listar();
        switch (codigo) {
            case "email":
                lista.sort(new CompareUsersByEmail());
                return lista;
            case "nome":
                lista.sort(new CompareUsersByNome());
                return lista;
            default:
                List<String> list = null;
                assert false;
                list.add("Filtro invalido. Tente novamente");
                return list;
        }
    }
}
