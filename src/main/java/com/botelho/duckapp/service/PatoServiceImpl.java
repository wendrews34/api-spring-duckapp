package com.botelho.duckapp.service;

import com.botelho.duckapp.entity.Pato;
import com.botelho.duckapp.repository.PatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatoServiceImpl implements PatoService {

    private final PatoRepository patoRepository;

    @Autowired
    public PatoServiceImpl(PatoRepository patoRepository) {
        this.patoRepository = patoRepository;
    }

    @Override
    public List<Pato> getAllPatos() {
        return patoRepository.findAll();
    }

    @Override
    public Optional<Pato> getPatoById(Long id) {
        return patoRepository.findById(id);
    }

    @Override
    public Pato savePato(Pato pato) {
        // Implementar lógica de validação, se necessário
        return patoRepository.save(pato);
    }

    @Override
    public Pato updatePato(Long id, Pato updatedPato) {
        Optional<Pato> existingPato = patoRepository.findById(id);
        if (existingPato.isPresent()) {
            Pato pato = existingPato.get();
            pato.setNome(updatedPato.getNome());
            pato.setRaca(updatedPato.getRaca());
            pato.setIdade(updatedPato.getIdade());
            pato.setSexo(updatedPato.getSexo());
            pato.setStatus(updatedPato.getStatus());
            pato.setMae(updatedPato.getMae());
            return patoRepository.save(pato);
        } else {
            // Tratamento adequado para pato não encontrado
            return null;
        }
    }

    @Override
    public void deletePato(Long id) {
        patoRepository.deleteById(id);
    }
}