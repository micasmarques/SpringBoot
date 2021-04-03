package com.accenture.api.javaspringboot.domain.usuarios.comparator;

import com.accenture.api.javaspringboot.domain.usuarios.domain.Usuario;

import java.util.Comparator;

public class CompareUsersByNome implements Comparator<Usuario> {
    public int compare(Usuario user1, Usuario user2) {
        return user1.getNome().compareTo(user2.getNome());
    }
}
