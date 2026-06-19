package com.neiloalves.projetospringboot2.service;

import com.neiloalves.projetospringboot2.model.Pedido;
import com.neiloalves.projetospringboot2.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido finndById(Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        return pedido.get();
    }

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }
}
