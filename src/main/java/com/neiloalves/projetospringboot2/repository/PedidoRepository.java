package com.neiloalves.projetospringboot2.repository;

import com.neiloalves.projetospringboot2.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
