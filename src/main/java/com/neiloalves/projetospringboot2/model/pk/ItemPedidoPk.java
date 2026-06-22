package com.neiloalves.projetospringboot2.model.pk;

import com.neiloalves.projetospringboot2.model.Pedido;
import com.neiloalves.projetospringboot2.model.Produto;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

// nesse caso aqui de ser uma classe auxiliar de chave composta,
// usa a annotation @Embeddable
@Embeddable // incorporável, embutível ou integrável
public class ItemPedidoPk {
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    // tem q ter tanto o .equals quanto o hashCode dos dois atributos para fazer a comparação
    // pois são os dois juntos q identificam o item
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ItemPedidoPk that)) return false;
        return Objects.equals(getPedido(), that.getPedido()) && Objects.equals(getProduto(), that.getProduto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPedido(), getProduto());
    }
}
