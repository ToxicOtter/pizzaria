package com.pizzaria.pizza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    private List<PedidoClienteProduto> itens = new ArrayList<>();
    private Pedido pedidoAtual;
    private Produto produtoSelecionado;
    private Cliente clienteLogado;
    private String respostaLogin;

    @RequestMapping("/")
    public ModelAndView home() {
        respostaLogin = null;
        ModelAndView mAv = new ModelAndView("home");
        mAv.addObject("cliente", clienteLogado);
        return mAv;
    }

    @GetMapping("/selecionarItens")
    public ModelAndView listarClientes() {
        respostaLogin = null;
        ModelAndView mAv = new ModelAndView("cardapio");
        mAv.addObject("listaDePizzas", produtoRepository.findByTipo("Pizza"));
        mAv.addObject("listaDeBebidas", produtoRepository.findByTipo("Bebida"));
        mAv.addObject("cliente", clienteLogado);
        mAv.addObject("itens", itens);
        return mAv;
    }

    @PostMapping("/salvarItem")
    public String receberPizza(@RequestParam("id") int pizzaId, @RequestParam("qtd") int pizzaQtd,
            @RequestParam("tamanho") String pizzaTamanho, @RequestParam("valorTotalUnitario") String pizzaValorTotal) {
        PedidoClienteProduto itemPedido = new PedidoClienteProduto(pedidoAtual, clienteLogado, produtoSelecionado,
                pizzaQtd, pizzaTamanho, Float.parseFloat(pizzaValorTotal));
        boolean aumentouQtd = false;
        if (itens != null) {
            for (PedidoClienteProduto item : itens) {
                if (item.getProduto().getId() == itemPedido.getProduto().getId()
                        && item.getTamanho().equals(itemPedido.getTamanho())) {
                    item.setQuantidadeProduto(item.getQuantidadeProduto() + itemPedido.getQuantidadeProduto());
                    item.setPrecoProduto(item.getPrecoProduto() + itemPedido.getPrecoProduto());
                    pedidoItemRepository.save(item);
                    aumentouQtd = true;
                }
            }
            if (!aumentouQtd) {
                pedidoItemRepository.save(itemPedido);
                itens.add(itemPedido);
            }
        } else {
            pedidoItemRepository.save(itemPedido);
            itens.add(itemPedido);
        }
        return "redirect:/selecionarItens";
    }

    @RequestMapping("/selecionaProduto")
    public ModelAndView selecionarProduto(@RequestParam("id") int id) {
        respostaLogin = null;
        Optional<Produto> produtoTemp = produtoRepository.findById(Integer.valueOf(id));
        produtoSelecionado = produtoTemp.get();

        ModelAndView modelAndView = new ModelAndView("produtos");
        modelAndView.addObject("produto", produtoSelecionado);
        modelAndView.addObject("cliente", clienteLogado);
        return modelAndView;
    }

    @RequestMapping("/iniciarPedido")
    public String iniciarPedido() {
        if (clienteLogado == null) {
            return "redirect:/autenticacao";
        }
        if (pedidoAtual == null || pedidoAtual.getStatus().equals("Finalizado")) {
            pedidoAtual = new Pedido((float) 0, "Iniciado", "", "");
            pedidoRepository.save(pedidoAtual);
        }
        return "redirect:/selecionarItens";
    }

    @RequestMapping("/deletarPedido")
    public String deletarPedido() {
        pedidoRepository.delete(pedidoAtual);
        pedidoAtual.setStatus("Finalizado");
        itens = new ArrayList<>();
        return "redirect:/";
    }

    @RequestMapping("/finalizar")
    public ModelAndView finalizar() {
        respostaLogin = null;
        float total = 0;
        for (PedidoClienteProduto item : itens) {
            total += item.getPrecoProduto();
        }

        ModelAndView mAv = new ModelAndView("finalizar");
        mAv.addObject("cliente", clienteLogado);
        mAv.addObject("itens", itens);
        mAv.addObject("total", total);
        return mAv;
    }

    @RequestMapping("/encerrar")
    public String encerrar(@RequestParam("pagamento") String pagamento, @RequestParam("valor") float valor, @RequestParam("endereco") String endereco) {
        pedidoAtual.setPagamento(pagamento);
        pedidoAtual.setStatus("Finalizado");
        pedidoAtual.setValor(valor);
        pedidoAtual.setEndereco(endereco);
        pedidoRepository.save(pedidoAtual);
        itens = new ArrayList<>();
        return "redirect:/";
    }

    @RequestMapping("/autenticacao")
    public ModelAndView autenticacao() {
        ModelAndView mAv = new ModelAndView("login");
        mAv.addObject("respostaLogin", respostaLogin);
        mAv.addObject("cliente", new Cliente());
        return mAv;
    }

    @RequestMapping("/login")
    public String login(@RequestParam("emailLogin") String email, @RequestParam("senhaLogin") String senha) {
        Cliente clienteTemp = clienteRepository.findByEmail(email);
        if (clienteTemp == null) {
            respostaLogin = "Usuário ou senha incorretos";
            return "redirect:/autenticacao";
        } else {
            if (clienteTemp.getSenha().equals(senha)) {
                clienteLogado = clienteTemp;
                return "redirect:/iniciarPedido";
            } else {
                respostaLogin = "Usuário ou senha incorretos";
                return "redirect:/autenticacao";
            }
        }
    }

    @RequestMapping("/signup")
    public String signup(@ModelAttribute("cliente") Cliente cliente) {
        Cliente clienteTemp = clienteRepository.findByEmail(cliente.getEmail());
        if (clienteTemp == null) {
            clienteRepository.save(cliente);
            respostaLogin = "Usuário cadastrado com sucesso. Faça o login!";
            return "redirect:/autenticacao";
        } else {
            respostaLogin = "Usuário já existe no sistema!";
            return "redirect:/autenticacao";
        }
    }

    @RequestMapping("/logout")
    public String logout(){
        clienteLogado = null;
        if(pedidoAtual.getStatus().equals("Iniciado")){
            pedidoRepository.delete(pedidoAtual);
            pedidoAtual.setStatus("Finalizado");
        }
        itens = new ArrayList<>();
        return "redirect:/";
    }
}