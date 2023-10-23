package com.pizzaria.pizza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pizzaria.pizza.model.Cliente;
import com.pizzaria.pizza.model.bd.ClienteDAO;

@Controller
public class ClienteController {
    @Autowired
    private ClienteDAO clienteDAO;

    @GetMapping("/testeLista")
    public ModelAndView listarClientes() {
        List<Cliente> clientes = clienteDAO.listarClientes();
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getNome());
        }

        ModelAndView mAv = new ModelAndView("cliente");
        mAv.addObject("listaDeClientes", clientes);
        mAv.addObject("cliente", new Cliente());
        return mAv;
    }
}
