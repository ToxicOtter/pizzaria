package com.pizzaria.pizza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.pizzaria.pizza.model.Cliente;
import com.pizzaria.pizza.model.Pedido;
import com.pizzaria.pizza.model.PedidoClienteProduto;
import com.pizzaria.pizza.model.Produto;
import com.pizzaria.pizza.model.bd.ClienteRepository;
import com.pizzaria.pizza.model.bd.PedidoClienteProdutoRepository;
import com.pizzaria.pizza.model.bd.PedidoRepository;
import com.pizzaria.pizza.model.bd.ProdutoRepository;

@Controller
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private PedidoClienteProdutoRepository pedidoItemRepository;

    //private List<List<Integer>> itens = new ArrayList<>();
    private List<PedidoClienteProduto> itens = new ArrayList<>();
    private Pedido pedidoAtual;
    private Produto produtoSelecionado;
    private Cliente clienteLogado;

    @RequestMapping("/")
    public ModelAndView home() {
        Optional<Cliente> tempClienteLogado = clienteRepository.findById(1);
        clienteLogado = tempClienteLogado.get();
        System.out.println(clienteLogado.getNome());
        ModelAndView mAv = new ModelAndView("home");
        return mAv;
    }

    @GetMapping("/selecionarItens")
    public ModelAndView listarClientes() {
        ModelAndView mAv = new ModelAndView("cliente");
        mAv.addObject("listaDeClientes", clienteRepository.findAll());
        mAv.addObject("listaDePizzas", produtoRepository.findByTipo("Pizza"));
        mAv.addObject("listaDeBebidas", produtoRepository.findByTipo("Bebida"));
        mAv.addObject("cliente", new Cliente());
        mAv.addObject("produto", new Produto());
        mAv.addObject("itens", itens);
        return mAv;
    }

    @PostMapping("/salvarItem")
    public String receberPizza(@RequestParam("id") int pizzaId, @RequestParam("qtd") int pizzaQtd, @RequestParam("tamanho") String pizzaTamanho, @RequestParam("valorTotalUnitario") String pizzaValorTotal) {
        // List<Integer> pizza = new ArrayList<Integer>();
        // System.out.println(pizzaTamanho);
        // System.out.println(pizzaValorTotal);
        // pizza.add(pizzaId);
        // pizza.add(pizzaQtd);
        // System.out.println(pizza);
        // System.out.println(itens);
        PedidoClienteProduto itemPedido = new PedidoClienteProduto(pedidoAtual, clienteLogado, produtoSelecionado, pizzaQtd, pizzaTamanho, Float.parseFloat(pizzaValorTotal));
        pedidoItemRepository.save(itemPedido);
        itens.add(itemPedido);
        System.out.println(clienteLogado.getNome());
        return "redirect:/selecionarItens";
    }

    @RequestMapping("/selecionaProduto")
    public ModelAndView selecionarProduto(@RequestParam("id") int id) {
        System.out.println("buscando o produto: " + id);
        Optional<Produto> produtoTemp = produtoRepository.findById(Integer.valueOf(id));
        //Produto produto = produtoTemp.get();
        produtoSelecionado = produtoTemp.get();
        System.out.println("produto: " + produtoSelecionado.getNome());

        ModelAndView modelAndView = new ModelAndView("produtos");
        modelAndView.addObject("produto", produtoSelecionado);
        return modelAndView;
    }

    @RequestMapping("/iniciarPedido")
    public String iniciarPedido() {
        pedidoAtual = new Pedido((float) 0, "Iniciado", "");
        pedidoRepository.save(pedidoAtual);
        System.out.println(pedidoAtual.getNumero());
        return "redirect:/selecionarItens";
    }

    @RequestMapping("/deletarPedido")
    public String deletarPedido(){
        pedidoRepository.delete(pedidoAtual);
        return "redirect:/";
    }
}
