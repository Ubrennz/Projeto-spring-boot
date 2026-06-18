package com.neiloalves.projetospringboot2.service;

import com.neiloalves.projetospringboot2.model.Usuario;
import com.neiloalves.projetospringboot2.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id); // vai retonar um objeto optinal, do tipo Usuario
        return usuario.get(); // a operação .get() do optional vai retornar o objeto do tipo usuario q tiver dentro do optional
    }
}
