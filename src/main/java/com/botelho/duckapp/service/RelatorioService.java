package com.botelho.duckapp.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class RelatorioService {

    public byte[] gerarRelatorioExcel() throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Relatório de Vendas");

        // Cabeçalho do relatório
        String[] headers = {"Cliente", "Pato Vendido", "Status", "Valor da Venda"};
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        // Dados de exemplo (substitua com dados reais do seu sistema)
        String[][] dadosVenda = {
                {"Cliente A", "Pato 1", "Concluída", "100.00"},
                {"Cliente B", "Pato 2", "Concluída", "120.00"},
                {"Cliente C", "Pato 3", "Em Andamento", "80.00"}
        };

        // Preenchendo os dados na planilha
        int rowNum = 1;
        for (String[] venda : dadosVenda) {
            Row row = sheet.createRow(rowNum++);
            for (int cellNum = 0; cellNum < headers.length; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(venda[cellNum]);
            }
        }

        // Escrever o workbook em um ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();
        return outputStream.toByteArray();
    }

    public byte[] gerarRelatorioPDF() throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
        contentStream.beginText();
        contentStream.newLineAtOffset(50, 700);
        contentStream.showText("Relatório de Vendas");
        contentStream.newLine();

        // Dados de exemplo (substitua com dados reais do seu sistema)
        String[][] dadosVenda = {
                {"Cliente A", "Pato 1", "Concluída", "100.00"},
                {"Cliente B", "Pato 2", "Concluída", "120.00"},
                {"Cliente C", "Pato 3", "Em Andamento", "80.00"}
        };

        float y = 700;
        for (String[] venda : dadosVenda) {
            y -= 20;
            contentStream.newLineAtOffset(0, -20);
            for (String value : venda) {
                contentStream.showText(value + "   ");
            }
        }

        contentStream.endText();
        contentStream.close();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        document.save(outputStream);
        document.close();
        return outputStream.toByteArray();
    }
}
