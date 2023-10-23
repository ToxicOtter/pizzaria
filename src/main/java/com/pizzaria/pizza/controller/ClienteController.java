package com.pizzaria.pizza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pizzaria.pizza.model.Cliente;
import com.pizzaria.pizza.model.bd.ClienteRepository;
import com.pizzaria.pizza.model.bd.ProdutoRepository;

@Controller
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/testeLista")
    public ModelAndView listarClientes() {
        ModelAndView mAv = new ModelAndView("cliente");
        mAv.addObject("listaDeClientes", clienteRepository.findAll());
        mAv.addObject("listaDePizzas", produtoRepository.findByTipo("Pizza"));
        mAv.addObject("cliente", new Cliente());
        return mAv;
    }
}
