package com.pizzaria.pizza.model.bd;

import java.util.List;

import com.pizzaria.pizza.model.Cliente;
import com.pizzaria.pizza.model.Produto;

public interface ClienteDAO {
    public List<Cliente> listarClientes();
    public List<Produto> listarPizzas();
    public List<Produto> listarBebidas();
}
