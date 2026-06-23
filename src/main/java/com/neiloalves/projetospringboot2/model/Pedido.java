package com.neiloalves.projetospringboot2.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.neiloalves.projetospringboot2.enums.StatusPedido;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// quando a pessoa faz uma chamada de um pedido, automaticamente o JPA pega o usuário associado a ele
// por conta da relação ManyToOne. Isso é padrão do JPA. Isso usando o @JsonIgnore em um dos lados

// o JsonIgnore vai ignorar a associação feita
// EX: o @JsonIgnore está na classe Usuario, então lá na chamada, não vai aparecer a lista de pedidos associadas ao objeto Usuario,
// Agr se for na classe Pedido, lá na chamada vai ser ignorado a classe usuario

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // formatando a data e hora dentro do Json
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant momento;

    private Integer statusPedido;

    @JsonIgnore
    @ManyToOne // 1 usuário pode ter varios pedidos
    @JoinColumn(name = "usuario_id") // fazendo a associação da chave estrangeria, e dando o nome para essa chave estrangeria
    private Usuario usuario;

    // no ItemPedido temno o ID na vdd, e o ID por sua ver é q tem o Pedido
    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemPedido> itens = new HashSet<>();

    public Pedido() {
    }

    public Pedido(Long id, Instant momento, StatusPedido statusPedido, Usuario usuario) {
        this.id = id;
        this.momento = momento;
        setStatusPedido(statusPedido);
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMomento() {
        return momento;
    }

    public void setMomento(Instant momento) {
        this.momento = momento;
    }

    public StatusPedido getStatusPedido() {
        return StatusPedido.valueOf(statusPedido);
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        if (statusPedido != null) {
            this.statusPedido = statusPedido.getCode();
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<ItemPedido> getItens() {
        return itens;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pedido pedido)) return false;
        return Objects.equals(getId(), pedido.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
