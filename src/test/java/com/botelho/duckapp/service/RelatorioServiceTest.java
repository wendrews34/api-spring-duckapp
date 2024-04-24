package com.botelho.duckapp.service;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class RelatorioServiceTest {

    @Mock
    private Workbook mockWorkbook;

    @Mock
    private PDDocument mockPdfDocument;

    @InjectMocks
    private RelatorioService relatorioService;

    public RelatorioServiceTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGerarRelatorioExcel() throws IOException {
        byte[] byteArray = relatorioService.gerarRelatorioExcel();
        assertNotNull(byteArray);
        assertTrue(byteArray.length > 0); // Verifica se o array de bytes não está vazio
        // Aqui você pode adicionar mais asserções para validar o conteúdo gerado, se necessário
    }

    @Test
    void testGerarRelatorioPDF() throws IOException {
        byte[] byteArray = relatorioService.gerarRelatorioPDF();
        assertNotNull(byteArray);
        assertTrue(byteArray.length > 0); // Verifica se o array de bytes não está vazio
        // Aqui você pode adicionar mais asserções para validar o conteúdo gerado, se necessário
    }
}
