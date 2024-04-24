package com.botelho.duckapp.service;

import com.botelho.duckapp.entity.Venda;
import com.botelho.duckapp.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;

    @Autowired
    public VendaService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public List<Venda> getAllVendas() {
        return vendaRepository.findAll();
    }

    public Optional<Venda> getVendaById(Long id) {
        return vendaRepository.findById(id);
    }

    public Venda saveVenda(Venda venda) {
        // Implementar lógica para salvar a venda, se necessário
        return vendaRepository.save(venda);
    }

    public void deleteVenda(Long id) {
        vendaRepository.deleteById(id);
    }

    public Long getClienteIdFromVenda(Long vendaId) {
        Optional<Venda> vendaOptional = vendaRepository.findById(vendaId);
        return vendaOptional.map(venda -> venda.getCliente().getId()).orElse(null);
    }
}