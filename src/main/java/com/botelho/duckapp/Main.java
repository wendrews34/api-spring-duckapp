package com.botelho.duckapp;

import com.botelho.duckapp.entity.Pato;
import com.botelho.duckapp.enums.StatusPato;

public class Main {
    public static void main(String[] args) {
        // Criando um novo pato com status inicial
        Pato pato = new Pato();
        pato.setId(1L);
        pato.setNome("Donald");
        pato.setRaca("Marreco");
        pato.setIdade(3);
        pato.setSexo("Macho");
        pato.setStatus(StatusPato.DISPONIVEL);

        // Exibindo informações do pato
        System.out.println("Informações do Pato:");
        System.out.println("Nome: " + pato.getNome());
        System.out.println("Raça: " + pato.getRaca());
        System.out.println("Idade: " + pato.getIdade());
        System.out.println("Sexo: " + pato.getSexo());
        System.out.println("Status: " + pato.getStatus());

        // Alterando o status do pato
        pato.setStatus(StatusPato.VENDIDO);

        // Exibindo o novo status do pato
        System.out.println("Novo Status: " + pato.getStatus());
    }
}

