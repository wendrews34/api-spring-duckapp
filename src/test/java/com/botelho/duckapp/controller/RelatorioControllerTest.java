package com.botelho.duckapp.controller;

import com.botelho.duckapp.service.RelatorioService;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class RelatorioControllerTest {

    @Mock
    private RelatorioService relatorioService;

    @InjectMocks
    private RelatorioController relatorioController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGenerateRelatorioExcel() throws IOException {
        Workbook workbook = new XSSFWorkbook();
        byte[] excelBytes = workbookToByteArray(workbook);
        when(relatorioService.gerarRelatorioExcel()).thenReturn(excelBytes);

        ResponseEntity<byte[]> response = relatorioController.gerarRelatorioExcel();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(excelBytes.length, response.getBody().length);
    }

    @Test
    public void testGenerateRelatorioPDF() throws IOException {
        byte[] pdfBytes = "PDF Relatório".getBytes();
        when(relatorioService.gerarRelatorioPDF()).thenReturn(pdfBytes);

        ResponseEntity<byte[]> response = relatorioController.gerarRelatorioPDF();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(pdfBytes.length, response.getBody().length);
    }

    private byte[] workbookToByteArray(Workbook workbook) throws IOException {
        byte[] bytes;
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            workbook.write(outputStream);
            bytes = outputStream.toByteArray();
        } finally {
            workbook.close();
        }
        return bytes;
    }
}