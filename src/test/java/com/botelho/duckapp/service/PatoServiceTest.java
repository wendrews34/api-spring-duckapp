package com.botelho.duckapp.service;

import com.botelho.duckapp.entity.Pato;
import com.botelho.duckapp.enums.StatusPato;
import com.botelho.duckapp.repository.PatoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PatoServiceTest {

    @Mock
    private PatoRepository patoRepository;

    @InjectMocks
    private PatoServiceImpl patoService;

    @Test
    void testSavePato() {
        Pato pato = new Pato("Donald", "Marreco", 3, "Macho", StatusPato.DISPONIVEL, "Mãe Pata");

        // Configurar o comportamento do repositório mock
        when(patoRepository.save(any(Pato.class))).thenReturn(new Pato(1L, "Donald", "Marreco", 3, "Macho", StatusPato.DISPONIVEL, "Mãe Pata"));

        // Chamar o método a ser testado
        Pato resultado = patoService.savePato(pato);

        // Verificar se o método retornou o pato salvo corretamente
        assertNotNull(resultado);
        assertEquals(pato.getNome(), resultado.getNome());
    }

    @Test
    void testUpdatePato() {
        Long id = 1L;
        Pato patoExistente = new Pato(id, "Donald", "Marreco", 3, "Macho", StatusPato.DISPONIVEL, "Mãe Pata");
        Pato patoAtualizado = new Pato(id, "Donald", "Marreco", 3, "Macho", StatusPato.VENDIDO, "Mãe Pata Atualizada");

        // Configurar o comportamento do repositório mock para findById
        when(patoRepository.findById(id)).thenReturn(Optional.of(patoExistente));

        // Configurar o comportamento do repositório mock para save
        when(patoRepository.save(any(Pato.class))).thenReturn(patoAtualizado);

        // Chamar o método a ser testado
        Pato resultado = patoService.updatePato(id, patoAtualizado);

        // Verificar se o método retornou o pato atualizado corretamente
        assertNotNull(resultado);
        assertEquals(StatusPato.VENDIDO, resultado.getStatus());
        assertEquals("Mãe Pata Atualizada", resultado.getMae());
    }
}
