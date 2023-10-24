package com.pizzaria.pizza.model.bd;

import org.springframework.data.repository.CrudRepository;

import com.pizzaria.pizza.model.PedidoClienteProduto;

public interface PedidoClienteProdutoRepository extends CrudRepository<PedidoClienteProduto, Integer> {
    
}
