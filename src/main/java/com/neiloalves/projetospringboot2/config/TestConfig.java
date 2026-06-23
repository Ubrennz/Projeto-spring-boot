package com.neiloalves.projetospringboot2.config;

import com.neiloalves.projetospringboot2.enums.StatusPedido;
import com.neiloalves.projetospringboot2.model.*;
import com.neiloalves.projetospringboot2.repository.*;
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

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

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

        // getCategorias() para acessar a coleção de categorias do produto pd1
        // .add() para add um elemento nessa coleção, add a categoria (c2)
        // uma associação entre objetos
        pd1.getCategorias().add(c2);
        pd2.getCategorias().add(c1);

        pd1.getCategorias().add(c1);

        // para salvar novamente os produtos com as novas associações
        produtoRepository.saveAll(Arrays.asList(pd1, pd2));

        ItemPedido oi1 = new ItemPedido(p1, pd1, 2, pd1.getPreco());
        ItemPedido oi2 = new ItemPedido(p2, pd2, 1, pd2.getPreco());

        itemPedidoRepository.saveAll(Arrays.asList(oi1, oi2));

        Pagamento pay1 = new Pagamento(null, Instant.now(), p1);
        p1.setPagamento(pay1);

        /*
        * Para vc salvar um objeto depedente 1 para 1, vc não vai chamar o repository do proprio objeto
        * ai vamos fazer a associação de mão dupla em memoria, ai chamamos o .setPagamento do pedido associado
        * e dps salvamos o pedido, ai o JPA vai tratar de o pagamento desse pedido        *
        */

        pedidoRepository.save(p1);

    }
}
