package com.botelho.duckapp.dto;

import com.botelho.duckapp.enums.TipoCliente;

public class ClienteDTO {

    private String nome;
    private String sobrenome;
    private TipoCliente tipo;

    public ClienteDTO() {
        // Construtor vazio necessário para frameworks de serialização
    }

    public ClienteDTO(String nome, String sobrenome, TipoCliente tipo) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.tipo = tipo;
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }
}
