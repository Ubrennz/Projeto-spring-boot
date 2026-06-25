package com.neiloalves.projetospringboot2.service;

import com.neiloalves.projetospringboot2.model.Usuario;
import com.neiloalves.projetospringboot2.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // registrando no mecanismo de injeção de dependecia, como componente do spring
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario insert(Usuario usuario) {
        return usuarioRepository.save(usuario); // o usuarioRepository.save retornar o obj
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id); // vai retonar um objeto optinal, do tipo Usuario
        return usuario.get(); // a operação .get() do optional vai retornar o objeto do tipo usuario q tiver dentro do optional
    }

    public void updateData(Usuario entity, Usuario usuario) {
        entity.setNome(usuario.getNome());
        entity.setEmail(usuario.getEmail());
        entity.setTelefone(usuario.getTelefone());
        // ai a pessoa diz quais campos devem ser atualizados
    }

    // vai receber um id para buscar o usuário q a genter quer atualizar
    // e tbm vai receber um usuario com esses novos dados, para atualizar os dados antigos
    public Usuario update(Long id, Usuario usuario) {
        Usuario entity = usuarioRepository.getReferenceById(id); // pegando o usuário q desejamos atualizar pelo id
        updateData(entity, usuario);
        return usuarioRepository.save(entity);
    }

    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }
}
