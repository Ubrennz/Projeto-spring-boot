package com.neiloalves.projetospringboot2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// quando a pessoa faz uma chamada de um pedido, automaticamente o JPA pega o usuário associado a ele
// Isso não acontece quando é uma relação OneToMany, o JPA não carrega os objetos do lado do Many por padrão
// isso é chamado de "Lazy Loading", isso para não estourar a mémoria do pc
// Só dar pra chamar os do lado para Many se fizer uma chamado do lado do Many

// o JsonIgnore vai ignorar a associação feita
// EX: o @JsonIgnore está na classe Usuario, então lá na chamada, não vai aparecer a lista de pedidos associadas ao objeto Usuario,
// Agr se for na classe Pedido, lá na chamada vai ser ignorado a classe usuario

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id // -> indicando qual vai ser a chave primaria do db
    @GeneratedValue(strategy = GenerationType.IDENTITY) // estrategia de auto encremento
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String senha;

    // nome do atributo q tem lá do outro lado da associação (tabela pedido)
    // ele está mapeado pela entidade usuario, lá do outro lado
    // @JsonIgnore // para parar o loop de chamdas no json
    @OneToMany(mappedBy = "usuario") // 1 usuario tem varios pedidos
    private List<Pedido> pedidos = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(Long id, String nome, String email, String telefone, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Usuario usuario)) return false;
        return Objects.equals(getId(), usuario.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
