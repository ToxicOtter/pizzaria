package com.pizzaria.pizza.model.bd;

import org.springframework.data.repository.CrudRepository;
import com.pizzaria.pizza.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
}
