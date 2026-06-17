package com.neiloalves.projetospringboot2.repository;

import com.neiloalves.projetospringboot2.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
