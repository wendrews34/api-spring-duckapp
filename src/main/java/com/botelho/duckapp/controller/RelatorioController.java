package com.botelho.duckapp.controller;

import com.botelho.duckapp.service.RelatorioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/relatorios")
@Api(tags = "Relatórios")
public class RelatorioController {

    @Autowired
    private RelatorioService relatorioService;

    @ApiOperation("Gerar relatório em formato Excel")
    @GetMapping("/excel")
    public ResponseEntity<byte[]> gerarRelatorioExcel() throws IOException {
        byte[] relatorioBytes = relatorioService.gerarRelatorioExcel();
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=relatorio.xlsx")
                .body(relatorioBytes);
    }

    @ApiOperation("Gerar relatório em formato PDF")
    @GetMapping("/pdf")
    public ResponseEntity<byte[]> gerarRelatorioPDF() throws IOException {
        byte[] relatorioBytes = relatorioService.gerarRelatorioPDF();
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=relatorio.pdf")
                .body(relatorioBytes);
    }
}