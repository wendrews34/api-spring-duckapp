package com.botelho.duckapp.testutil;

import com.botelho.duckapp.entity.Cliente;
import com.botelho.duckapp.entity.Pato;
import com.botelho.duckapp.entity.Venda;
import com.botelho.duckapp.enums.StatusPato;
import com.botelho.duckapp.enums.TipoCliente;

import java.util.ArrayList;
import java.util.List;

public class TestDataUtil {

    public static Cliente createCliente(Long id, String nome, String sobrenome, TipoCliente tipo) {
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setNome(nome);
        cliente.setSobrenome(sobrenome);
        cliente.setTipo(tipo);
        return cliente;
    }

    public static Pato createPato(Long id, String nome, String raca, int idade, String sexo, StatusPato status, String mae) {
        Pato pato = new Pato();
        pato.setId(id);
        pato.setNome(nome);
        pato.setRaca(raca);
        pato.setIdade(idade);
        pato.setSexo(sexo);
        pato.setStatus(status);
        pato.setMae(mae);
        return pato;
    }

    public static List<Pato> createSamplePatos() {
        List<Pato> patos = new ArrayList<>();
        patos.add(createPato(1L, "Donald", "Marreco", 3, "Macho", StatusPato.DISPONIVEL, "Mãe Pata"));
        patos.add(createPato(2L, "Daisy", "Marreca", 2, "Fêmea", StatusPato.DISPONIVEL, "Mãe Marreca"));
        patos.add(createPato(3L, "Huguinho", "Patinho", 1, "Macho", StatusPato.RESERVADO, "Mãe Patinha"));
        return patos;
    }

    public static Venda createVenda(Long id, Cliente cliente, Pato pato, double valor) {
        Venda venda = new Venda();
        venda.setId(id);
        venda.setCliente(cliente);
        return venda;
    }
}