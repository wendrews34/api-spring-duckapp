package com.botelho.duckapp.controller;

import com.botelho.duckapp.entity.Pato;
import com.botelho.duckapp.service.PatoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class PatoControllerTest {

    @Mock
    private PatoService patoService;

    @InjectMocks
    private PatoController patoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetPatoById() {
        Long id = 1L;
        Pato pato = new Pato();
        pato.setId(id);
        pato.setNome("Donald");
        pato.setRaca("Marreco");
        pato.setIdade(3);
        pato.setSexo("Macho");
        pato.setStatus(null);

        when(patoService.getPatoById(id)).thenReturn(Optional.of(pato));

        ResponseEntity<Pato> response = patoController.getPatoById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(pato.getId(), response.getBody().getId());
        assertEquals(pato.getNome(), response.getBody().getNome());
        assertEquals(pato.getRaca(), response.getBody().getRaca());
        assertEquals(pato.getIdade(), response.getBody().getIdade());
        assertEquals(pato.getSexo(), response.getBody().getSexo());
        assertEquals(pato.getStatus(), response.getBody().getStatus());
    }

    // Implemente outros testes conforme necessário
}
