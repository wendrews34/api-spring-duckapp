package com.botelho.duckapp.controller;

import com.botelho.duckapp.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping("/realizar")
    public void realizarVenda(@RequestParam List<Long> idPatos, @RequestParam Long idCliente) {
        vendaService.realizarVenda(idPatos, idCliente);
    }
}

