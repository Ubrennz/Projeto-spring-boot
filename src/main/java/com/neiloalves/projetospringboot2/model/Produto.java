package com.neiloalves.projetospringboot2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private Double preco;
    private String imagemUrl;

    // Set<> (conjunto), para garantir q eu não tenha um produto com mais de uma ocorrencia da msm categoria
    // o msm produto não pode ter mais de uma categoria mais de uma vez

    // set<> é uma interface, não pode ser instanciada, por isso q instanciamos o HashSet<>()

    // pq instanciamos? pq a coleção deve començar vazia, e não nula
    // @Transient // annotation do JPA inpede q o JPA teste interprete isso daqui

    @ManyToMany // Como é uma nova tabela, produto_categoria vai ter a chave fk das duas tabelas
    @JoinTable(name = "produto_categoria",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private Set<Categoria> categorias = new HashSet<>();

    // qual ver ser o nome da tabela, e quais vão ser as chaves fk q associar a tabela de produto com a tabela de categoria

    // "name =" vai ser o nome da tabela de associação no banco de dados
    // "joinColumns = " um conceita parecido com o ManyToOne
    // "inverseJoinColumns =" definir qual vai ser a chave fk da outra entidade, como eu estou na classe Produto, a outra entidade é a Categoria

    public Produto() {
    }

    public Produto(Long id, String nome, String descricao, Double preco, String imagemUrl) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imagemUrl = imagemUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }
}
