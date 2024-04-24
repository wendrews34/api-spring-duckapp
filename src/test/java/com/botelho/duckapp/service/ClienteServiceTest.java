package com.botelho.duckapp.service;

import com.botelho.duckapp.entity.Cliente;
import com.botelho.duckapp.enums.TipoCliente;
import com.botelho.duckapp.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteServiceImpl clienteService;

    @Test
    void testGetAllClientes() {
        // Criar alguns clientes para simular o retorno do repositório
        Cliente cliente1 = new Cliente(1L, "Fulano", "de Tal", TipoCliente.SEM_DESCONTO);
        Cliente cliente2 = new Cliente(2L, "Ciclano", "Silva", TipoCliente.COM_DESCONTO);
        List<Cliente> clientes = Arrays.asList(cliente1, cliente2);

        // Configurar o comportamento do repositório mock
        when(clienteRepository.findAll()).thenReturn(clientes);

        // Chamar o método a ser testado
        List<Cliente> resultado = clienteService.getAllClientes();

        // Verificar se o método retornou os clientes corretos
        assertEquals(clientes.size(), resultado.size());
        assertEquals(cliente1, resultado.get(0));
        assertEquals(cliente2, resultado.get(1));
    }

}
