package com.neiloalves.projetospringboot2.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "pagamento")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant momemto;

    // a pessoa faz isso na classe dependente, já q o Pedido é a classe principal
    // e pode ter pedidos sem pagamento
    @JsonIgnore
    @OneToOne
    @MapsId
    private Pedido pedido;

    public Pagamento() {
    }

    public Pagamento(Long id, Instant momemto, Pedido pedido) {
        this.id = id;
        this.momemto = momemto;
        this.pedido = pedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMomemto() {
        return momemto;
    }

    public void setMomemto(Instant momemto) {
        this.momemto = momemto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
