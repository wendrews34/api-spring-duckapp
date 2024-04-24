package com.botelho.duckapp.service;

import com.botelho.duckapp.entity.Cliente;
import com.botelho.duckapp.entity.Venda;
import com.botelho.duckapp.repository.VendaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class VendaServiceTest {

    @Mock
    private VendaRepository vendaRepository;

    @InjectMocks
    private VendaService vendaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllVendas() {
        // Mockando o comportamento do repository para retornar uma lista vazia de vendas
        when(vendaRepository.findAll()).thenReturn(Collections.emptyList());

        List<Venda> vendas = vendaService.getAllVendas();

        assertNotNull(vendas);
        assertEquals(0, vendas.size());
    }

    @Test
    void testGetVendaById_ExistingId() {
        Long vendaId = 1L;
        Venda vendaMock = new Venda();
        vendaMock.setId(vendaId);

        // Mockando o comportamento do repository para retornar uma venda com o ID específico
        when(vendaRepository.findById(vendaId)).thenReturn(Optional.of(vendaMock));

        Optional<Venda> result = vendaService.getVendaById(vendaId);

        assertTrue(result.isPresent());
        assertEquals(vendaId, result.get().getId());
    }

    @Test
    void testGetVendaById_NonExistingId() {
        Long vendaId = 999L;

        // Mockando o comportamento do repository para retornar Optional vazio
        when(vendaRepository.findById(vendaId)).thenReturn(Optional.empty());

        Optional<Venda> result = vendaService.getVendaById(vendaId);

        assertFalse(result.isPresent());
    }

    @Test
    void testSaveVenda() {
        Venda venda = new Venda();

        // Mockando o comportamento do repository para salvar a venda e retornar a mesma venda
        when(vendaRepository.save(venda)).thenReturn(venda);

        Venda savedVenda = vendaService.saveVenda(venda);

        assertNotNull(savedVenda);
        assertEquals(venda, savedVenda);
    }

    @Test
    void testDeleteVenda() {
        Long vendaId = 1L;

        // Não há necessidade de mockar o retorno do repository, apenas verificar a chamada de deleteById
        vendaService.deleteVenda(vendaId);

        // Verifica se o método deleteById foi chamado uma vez com o ID especificado
        verify(vendaRepository, times(1)).deleteById(vendaId);
    }

    @Test
    void testGetClienteIdFromVenda() {
        Long vendaId = 1L;
        Long clienteId = 100L;

        Venda venda = new Venda();
        Cliente cliente = new Cliente();
        cliente.setId(clienteId);
        venda.setCliente(cliente);

        // Mockando o comportamento do repository para retornar a venda com o cliente associado
        when(vendaRepository.findById(vendaId)).thenReturn(Optional.of(venda));

        Long resultClientId = vendaService.getClienteIdFromVenda(vendaId);

        assertNotNull(resultClientId);
        assertEquals(clienteId, resultClientId);
    }
}
