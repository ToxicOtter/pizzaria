package com.pizzaria.pizza.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(CompositeKey.class)
public class PedidoClienteProduto {
    @Id
    @ManyToOne
    @JoinColumn(name="pedido_id")
    private Pedido pedido;

    @Id
    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    @Id
    @ManyToOne
    @JoinColumn(name="produto_id")
    private Produto produto;

    private int quantidadeProduto;
    @Id
    private String tamanho;
    private float precoProduto;
}