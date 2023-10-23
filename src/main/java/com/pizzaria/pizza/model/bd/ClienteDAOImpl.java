package com.pizzaria.pizza.model.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.pizzaria.pizza.model.Cliente;

@Component
public class ClienteDAOImpl implements ClienteDAO {
    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> lista = null;
        try {
            Connection conn = DriverManager.getConnection("jdbc:h2:C:/Users/luan_/Downloads/pizzaria", "teste","teste");
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("select * from cliente");
            lista = new ArrayList<Cliente>();
            while (rs.next()) {
                lista.add(
                    new Cliente(
                        rs.getInt("id"), 
                        rs.getString("email"), 
                        rs.getInt("cpf"), 
                        rs.getString("nome"), 
                        rs.getString("endereco_entrega"), 
                        rs.getInt("telefone")
                    )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
