package com.neiloalves.projetospringboot2.service;

import com.neiloalves.projetospringboot2.model.Categoria;
import com.neiloalves.projetospringboot2.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findById(Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.get();
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }
}
