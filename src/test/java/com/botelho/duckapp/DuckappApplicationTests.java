package com.botelho.duckapp;

import com.botelho.duckapp.entity.Pato;
import com.botelho.duckapp.enums.StatusPato;
import com.botelho.duckapp.service.PatoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.http.MediaType;
import java.util.Collections;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class DuckappApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetAllPatos() throws Exception {
		// Configurar o comportamento do serviço mock
		Pato pato = new Pato(1L, "Donald", "Marreco", 3, "Macho", StatusPato.DISPONIVEL, "Mãe Pata");
		PatoService patoService = null;
		when(patoService.getAllPatos()).thenReturn(Collections.singletonList(pato));

		// Executar a requisição HTTP e validar o resultado
		mockMvc.perform(MockMvcRequestBuilders.get("/patos")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].nome").value("Donald"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].raca").value("Marreco"));
	}
}