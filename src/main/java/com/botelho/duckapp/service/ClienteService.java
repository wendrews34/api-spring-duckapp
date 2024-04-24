package com.botelho.duckapp.service;

import com.botelho.duckapp.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    List<Cliente> getAllClientes();

    Optional<Cliente> getClienteById(Long id);

    Cliente saveCliente(Cliente cliente);

    void deleteCliente(Long id);

    // Definir método findById para buscar cliente por ID
    Optional<Cliente> findById(Long id);

    // Outros métodos necessários
    // ...
}
