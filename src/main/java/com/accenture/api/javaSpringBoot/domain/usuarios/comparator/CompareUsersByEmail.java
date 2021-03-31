package com.accenture.api.javaSpringBoot.domain.usuarios.comparator;

import com.accenture.api.javaSpringBoot.domain.usuarios.domain.Usuario;

import java.util.Comparator;

public class CompareUsersByEmail implements Comparator<Usuario> {
    public int compare(Usuario user1, Usuario user2) {
        return user1.getEmail().compareTo(user2.getEmail());
    }
}
