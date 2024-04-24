package com.botelho.duckapp.enums;

public enum StatusPato {
    DISPONIVEL("Disponível"),
    VENDIDO("Vendido"),
    RESERVADO("Reservado");

    private final String descricao;

    StatusPato(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    // Método estático para obter o enum a partir de uma string
    public static StatusPato fromString(String texto) {
        for (StatusPato status : StatusPato.values()) {
            if (status.descricao.equalsIgnoreCase(texto)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Status inválido: " + texto);
    }
}