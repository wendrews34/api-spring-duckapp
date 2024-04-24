package com.botelho.duckapp.controller;

import com.botelho.duckapp.entity.Pato;
import com.botelho.duckapp.service.PatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patos")
public class PatoController {

    private final PatoService patoService;

    @Autowired
    public PatoController(PatoService patoService) {
        this.patoService = patoService;
    }

    @GetMapping
    public ResponseEntity<List<Pato>> getAllPatos() {
        List<Pato> patos = patoService.getAllPatos();
        return ResponseEntity.ok(patos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pato> getPatoById(@PathVariable Long id) {
        Optional<Pato> pato = patoService.getPatoById(id);
        return pato.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pato> createPato(@RequestBody Pato pato) {
        Pato savedPato = patoService.savePato(pato);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pato> updatePato(@PathVariable Long id, @RequestBody Pato updatedPato) {
        Pato pato = patoService.updatePato(id, updatedPato);
        if (pato != null) {
            return ResponseEntity.ok(pato);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePato(@PathVariable Long id) {
        patoService.deletePato(id);
        return ResponseEntity.noContent().build();
    }
}