package com.pizzaria.pizza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import com.pizzaria.pizza.model.Cliente;
import com.pizzaria.pizza.model.Produto;
import com.pizzaria.pizza.model.bd.ClienteRepository;
import com.pizzaria.pizza.model.bd.ProdutoRepository;

@Controller
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    private List<List<Integer>> itens = new ArrayList<>();

    @GetMapping("/home")
    public ModelAndView listarClientes() {
        ModelAndView mAv = new ModelAndView("cliente");
        mAv.addObject("listaDeClientes", clienteRepository.findAll());
        mAv.addObject("listaDePizzas", produtoRepository.findByTipo("Pizza"));
        mAv.addObject("listaDeBebidas", produtoRepository.findByTipo("Bebida"));
        mAv.addObject("cliente", new Cliente());
        mAv.addObject("produto", new Produto());
        return mAv;
    }

    @PostMapping("/salvarItem")
    public String receberPizza(@RequestParam("id") int pizzaId, @RequestParam("qtd") int pizzaQtd) {
        List<Integer> pizza = new ArrayList<Integer>();
        pizza.add(pizzaId);
        pizza.add(pizzaQtd);
        System.out.println(pizza);
        itens.add(pizza);
        System.out.println(itens);
        return "redirect:/home";
    }
}
