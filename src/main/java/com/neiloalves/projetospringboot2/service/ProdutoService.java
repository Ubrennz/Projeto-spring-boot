package com.neiloalves.projetospringboot2.service;

import com.neiloalves.projetospringboot2.model.Produto;
import com.neiloalves.projetospringboot2.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto findById(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.get();
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

}
