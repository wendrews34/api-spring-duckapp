package com.botelho.duckapp.service;

import com.botelho.duckapp.entity.Pato;

import java.util.List;
import java.util.Optional;

public interface PatoService {

    List<Pato> getAllPatos();

    Optional<Pato> getPatoById(Long id);

    Pato savePato(Pato pato);

    Pato updatePato(Long id, Pato updatedPato);

    void deletePato(Long id);
}
