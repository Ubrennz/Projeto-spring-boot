package com.neiloalves.projetospringboot2.repository;

import com.neiloalves.projetospringboot2.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

// UsuarioRepository vai ser o repository responsavel por fazer operações com a entidade Usuario
// UsuarioRepository está reutilizando o JPArepository<O tipo da entidade q a pessoa vai acessar, e o tipo da chave sendo Long

// os nossos Repositorys eles serão interfaces, pq o JpaRepository tbm é uma interface
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // o spring data JPA ele já tem uma implementação padrão para essa interface

    // se a gente definiar aqui o JpaRepository generic, usando a sua entidade e o tipo do id da entidade,
    // já vamos ter uma implementação padrão para esse tipo especifico q definimos aqui
}
