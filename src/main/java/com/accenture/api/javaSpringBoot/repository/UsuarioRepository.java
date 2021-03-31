package com.accenture.api.javaSpringBoot.repository;

import com.accenture.api.javaSpringBoot.domain.usuarios.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByLoginAndSenha(String login, String senha);
}