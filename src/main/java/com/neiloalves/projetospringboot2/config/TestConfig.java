package com.neiloalves.projetospringboot2.config;

import com.neiloalves.projetospringboot2.model.Pedido;
import com.neiloalves.projetospringboot2.model.Usuario;
import com.neiloalves.projetospringboot2.repository.PedidoRepository;
import com.neiloalves.projetospringboot2.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository; // injeção de dependencia
    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public void run(String... args) throws Exception {
        Usuario u1 = new Usuario(null, "Brenno Pereira", "ubrennz@gmail.com", "988888888", "123456");
        Pedido p1 = new Pedido(null, Instant.now(), u1);

        Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        Pedido p2 = new Pedido(null, Instant.now(), u2);

        usuarioRepository.saveAll(Arrays.asList(u1, u2));
        pedidoRepository.saveAll(Arrays.asList(p1, p2));
    }
}
