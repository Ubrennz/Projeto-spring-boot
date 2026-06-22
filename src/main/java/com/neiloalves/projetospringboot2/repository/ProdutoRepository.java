package com.neiloalves.projetospringboot2.repository;

import com.neiloalves.projetospringboot2.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
