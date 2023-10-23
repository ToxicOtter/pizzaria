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
    private int cpf;
    private String nome;
    private String enderecoEntrega;
    private int telefone;
    @OneToMany(mappedBy = "cliente")
    private List<PedidoClienteProduto> pedidoClienteProduto;

    public Cliente(int id, String email, int cpf, String nome, String enderecoEntrega, int telefone){
        
    }
}
