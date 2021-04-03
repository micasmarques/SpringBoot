package com.accenture.api.javaspringboot.domain.usuarios.services;

import com.accenture.api.javaspringboot.domain.usuarios.domain.Usuario;
import com.accenture.api.javaspringboot.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public String verificaLoginAndSenha(String usuario, String senha){
        Usuario obj = usuarioRepository.findByLoginAndSenha(usuario, senha);
        if (obj == null){
            return "Usuario e/ou senha invalida!";
        }
        if (obj.getStatus().equals("C")) {
            return "Usuario está inativo no sistema!";
        } return "Usuario "+ obj.getNome() + " logado com sucesso!";
    }
}
