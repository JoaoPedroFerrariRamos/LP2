package space.indietech;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class meupalTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void crud1ClienteMeupalPF() throws Exception {
		createClientepf();

		pegarCliente();

		addCartao();

		pegarClienteComCartao();
	}

	private void pegarClienteComCartao() throws Exception {
		String location = "/meupal/cliente/taok@gmail";

		mockMvc.perform(get(location).header("Content-Type", "application/json").header("token",
				"eyJhbGciOiJIUzI1NiJ9.eyJ1c3VhcmlvIjoiZmVycmFyaSJ9.5Faand6d988Rd8b920ACNCe-ctSWAr4F3ekZYzHx3do"))
				.andExpect(jsonPath("$.nome").value("Ferrari")).andExpect(jsonPath("$.email").value("taok@gmail"))
				.andExpect(jsonPath("$.cartoes[0].nomeCartao").value("Ferrari"))
				.andExpect(jsonPath("$.cartoes[0].numCartao").value(123))
				.andExpect(jsonPath("$.cartoes[0].saldo").value(100)).andExpect(status().is2xxSuccessful());
	}

	private void addCartao() throws Exception {
		String location = "/meupal/cartao/taok@gmail";

		String json = "{\"nomeCartao\": \"Ferrari\",  \"numCartao\": 123, \"saldo\": 100}";

		mockMvc.perform(post(location).header("Content-Type", "application/json")
				.header("token",
						"eyJhbGciOiJIUzI1NiJ9.eyJ1c3VhcmlvIjoiZmVycmFyaSJ9.5Faand6d988Rd8b920ACNCe-ctSWAr4F3ekZYzHx3do")
				.content(json)).andExpect(jsonPath("$.nomeCartao").value("Ferrari"))
				.andExpect(jsonPath("$.numCartao").value(123)).andExpect(jsonPath("$.saldo").value(100))
				.andExpect(status().is2xxSuccessful());
	}

	private void pegarCliente() throws Exception {
		String location = "/meupal/cliente";

		mockMvc.perform(get(location).header("Content-Type", "application/json").header("token",
				"eyJhbGciOiJIUzI1NiJ9.eyJ1c3VhcmlvIjoiZmVycmFyaSJ9.5Faand6d988Rd8b920ACNCe-ctSWAr4F3ekZYzHx3do"))
				.andExpect(status().is2xxSuccessful()).andExpect(jsonPath("$[0].nome").value("Ferrari"))
				.andExpect(jsonPath("$[0].email").value("taok@gmail"))
				.andExpect(jsonPath("$[0].cartoes[0]").doesNotExist());
	}

	private void createClientepf() throws Exception {
		String location = "/meupal/cliente";

		String json = "{\"nome\": \"Ferrari\", \"email\": \"taok@gmail\"}";

		mockMvc.perform(post(location).header("Content-Type", "application/json")
				.header("token",
						"eyJhbGciOiJIUzI1NiJ9.eyJ1c3VhcmlvIjoiZmVycmFyaSJ9.5Faand6d988Rd8b920ACNCe-ctSWAr4F3ekZYzHx3do")
				.content(json)).andExpect(status().is2xxSuccessful()).andExpect(jsonPath("$.nome").value("Ferrari"))
				.andExpect(jsonPath("$.email").value("taok@gmail")).andExpect(jsonPath("$.cartoes[0]").doesNotExist());

	}

}
