package com.pizzaria.pizza.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numero;
    @Temporal(TemporalType.TIMESTAMP)
    private Date momento;
    private float valor;
    private String status;
    private String pagamento;
    @OneToMany(mappedBy = "pedido")
    private List<PedidoClienteProduto> pedidoClienteProduto;

    public Pedido(float valor, String status, String pagamento){
        this.valor = valor;
        this.status = status;
        this.pagamento = pagamento;
    }

    @PrePersist
    private void onCreate(){
        momento = new Date();
    }
}
