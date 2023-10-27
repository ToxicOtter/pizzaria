package com.pizzaria.pizza.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private long cpf;
    private String nome;
    private String enderecoEntrega;
    private long telefone;
    private String senha;
    @OneToMany(mappedBy = "cliente")
    private List<PedidoClienteProduto> pedidoClienteProduto;

    public Cliente(int id, String email, long cpf, String nome, String enderecoEntrega, long telefone){    
    }

    public Cliente(int id, String email, long cpf, String nome, String enderecoEntrega, long telefone, String senha){    
        this.id = id;
        this.email = email;
        this.cpf = cpf;
        this.nome = nome;
        this.enderecoEntrega = enderecoEntrega;
        this.telefone = telefone;
        this.senha = senha;
    }
}
