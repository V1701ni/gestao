
package gestao;

import gestao.model.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GestaoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void deveCriarClienteComNome() {
		Cliente cliente = new Cliente();
		cliente.setNome("João Silva");

		assertEquals("João Silva", cliente.getNome());
	}
}

