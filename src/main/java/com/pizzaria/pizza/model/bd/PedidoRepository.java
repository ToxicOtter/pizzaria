package com.pizzaria.pizza.model.bd;

import org.springframework.data.repository.CrudRepository;

import com.pizzaria.pizza.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Integer>{
    Pedido findFirstByOrderByNumeroDesc();
}
