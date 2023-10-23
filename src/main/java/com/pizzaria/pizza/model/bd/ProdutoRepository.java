package com.pizzaria.pizza.model.bd;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pizzaria.pizza.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Integer>{
    List<Produto> findByTipo(String tipo);
}
