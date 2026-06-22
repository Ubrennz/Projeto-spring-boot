package com.neiloalves.projetospringboot2.config;

import com.neiloalves.projetospringboot2.enums.StatusPedido;
import com.neiloalves.projetospringboot2.model.Categoria;
import com.neiloalves.projetospringboot2.model.Pedido;
import com.neiloalves.projetospringboot2.model.Produto;
import com.neiloalves.projetospringboot2.model.Usuario;
import com.neiloalves.projetospringboot2.repository.CategoriaRepository;
import com.neiloalves.projetospringboot2.repository.PedidoRepository;
import com.neiloalves.projetospringboot2.repository.ProdutoRepository;
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

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void run(String... args) throws Exception {
        Usuario u1 = new Usuario(null, "Brenno Pereira", "ubrennz@gmail.com", "988888888", "123456");
        Pedido p1 = new Pedido(null, Instant.now(), StatusPedido.ENVIADO, u1);

        Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        Pedido p2 = new Pedido(null, Instant.now(), StatusPedido.ESPERANDO_PAGAMENTO, u2);

        Categoria c1 = new Categoria(null, "Bonitos");
        Categoria c2 = new Categoria(null, "Livros");

        Produto pd1 = new Produto(null, "Livro 1", "Um livro de alguma coisa", 12.00, "www.com");
        Produto pd2 = new Produto(null, "Bandit 650", "Um moto bonita", 27000.00, "www.bandit650.com");

        usuarioRepository.saveAll(Arrays.asList(u1, u2));
        pedidoRepository.saveAll(Arrays.asList(p1, p2));
        categoriaRepository.saveAll(Arrays.asList(c1, c2));
        produtoRepository.saveAll(Arrays.asList(pd1, pd2));

    }
}
