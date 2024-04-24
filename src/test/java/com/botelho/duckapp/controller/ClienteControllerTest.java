package com.botelho.duckapp.controller;

import com.botelho.duckapp.dto.ClienteDTO;
import com.botelho.duckapp.entity.Cliente;
import com.botelho.duckapp.enums.TipoCliente;
import com.botelho.duckapp.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClienteController.class)
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;

    @Test
    public void testCreateCliente() throws Exception {
        // Dados do cliente para o teste
        ClienteDTO clienteDTO = new ClienteDTO("Maria", "Fulana", TipoCliente.NORMAL);

        // Cliente esperado após o salvamento
        Cliente clienteSalvo = new Cliente(1L, "Maria", "Fulana", TipoCliente.NORMAL);

        // Simular o serviço de cliente ao salvar um cliente
        doReturn(clienteSalvo).when(clienteService).saveCliente(any(Cliente.class));

        // Requisição POST para criar um novo cliente
        ResultActions resultActions = mockMvc.perform(post("/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"nome\": \"Maria\", \"sobrenome\": \"Fulana\", \"tipo\": \"NORMAL\" }"));

        // Verifica se a requisição retorna status HTTP 201 Created
        resultActions.andExpect(status().isCreated());
    }
}
