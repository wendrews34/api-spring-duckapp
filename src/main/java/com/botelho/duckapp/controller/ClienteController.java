package com.botelho.duckapp.controller;

import com.botelho.duckapp.dto.ClienteDTO;
import com.botelho.duckapp.entity.Cliente;
import com.botelho.duckapp.enums.TipoCliente;
import com.botelho.duckapp.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> clientes = clienteService.getAllClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        // Implemente lógica para buscar cliente por ID
        return clienteService.getClienteById(id)
                .map(cliente -> new ResponseEntity<>(cliente, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Cliente> saveCliente(@RequestBody ClienteDTO clienteDTO) {
        // Converta o DTO em uma entidade Cliente
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.getNome());
        cliente.setSobrenome(clienteDTO.getSobrenome());
        cliente.setTipo(clienteDTO.getTipo()); // Defina o tipo com base no DTO

        Cliente savedCliente = clienteService.saveCliente(cliente);
        return new ResponseEntity<>(savedCliente, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Outros métodos necessários conforme sua aplicação
    // Exemplo de atualização usando o enum TipoCliente
    @PutMapping("/{id}/atualizar-tipo")
    public ResponseEntity<Cliente> atualizarTipoCliente(@PathVariable Long id, @RequestParam TipoCliente tipoCliente) {
        return clienteService.getClienteById(id)
                .map(cliente -> {
                    cliente.setTipo(tipoCliente);
                    Cliente updatedCliente = clienteService.saveCliente(cliente);
                    return new ResponseEntity<>(updatedCliente, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
