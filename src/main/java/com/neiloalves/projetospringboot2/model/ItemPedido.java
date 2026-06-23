package com.neiloalves.projetospringboot2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.neiloalves.projetospringboot2.model.pk.ItemPedidoPk;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_pedido")
public class ItemPedido {
    @EmbeddedId // precisa ser instanciada se não vai dar nullPointExecption
    private ItemPedidoPk id = new ItemPedidoPk(); // identificador correspondente a chave primaria
    private Integer quantidade;
    private Double preco;

    public ItemPedido() {
    }

    public ItemPedido(Pedido pedido, Produto produto, Integer quantidade, Double preco) {
        id.setPedido(pedido);
        id.setProduto(produto);
        this.quantidade = quantidade;
        this.preco = preco;
    }
    // na plataforma java EE oq vale, é o metodo get, ai vamos ter q colocar aqui, no
    // getPedido
    // esse getPedido é oq chava o pedido associado a esse Item de Pedido, ai o pedido
    // por sua vez q chamava o ItemPedido dnv, e ficava nesse loop infinito
    @JsonIgnore
    public Pedido getPedido() {
        return id.getPedido();
    }

    public void setQuantidade(Pedido pedido) {
        id.setPedido(pedido);
    }

    public Produto getProduto() {
        return id.getProduto();
    }

    public void setProduto(Produto produto) {
        id.setProduto(produto);
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    // aqui no java EE oq vale é o get, ai usamos o getSubTotal
    public Double getSubTotal() {
        return preco * quantidade;
    }
}
