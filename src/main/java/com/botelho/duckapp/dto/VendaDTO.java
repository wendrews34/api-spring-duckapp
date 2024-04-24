package com.botelho.duckapp.dto;

import javax.validation.constraints.NotNull;
import java.util.List;

public class VendaDTO {

    @NotNull
    private Long idCliente;

    @NotNull
    private List<Long> idPatos;

    // Getters e Setters

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public List<Long> getIdPatos() {
        return idPatos;
    }

    public void setIdPatos(List<Long> idPatos) {
        this.idPatos = idPatos;
    }
}

