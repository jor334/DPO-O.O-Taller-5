package uniandes.dpoo.hamburguesas.tests;
import uniandes.dpoo.hamburguesas.excepciones.YaHayUnPedidoEnCursoException;
import uniandes.dpoo.hamburguesas.mundo.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RestauranteTest {
	private Restaurante restaurante1;

	
	@BeforeEach
	void setUp() throws Exception {
		restaurante1 = new Restaurante();
		
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	
	@Test
	void testIniciarPedido() throws YaHayUnPedidoEnCursoException {
        restaurante1.iniciarPedido("Juan Perez", "Calle 123");
        assertNotNull(restaurante1.getPedidoEnCurso(), "El pedido en curso no debería ser null.");
    }
	
	@Test
	void getPedidoEnCurso() {
		Pedido pedido = restaurante1.getPedidoEnCurso();
		assertNotNull(pedido, "La lista de pedidos en curso no debería ser null.");
	}
	
	@Test
	void testGetPedidos() {
        ArrayList<Pedido> pedidos = restaurante1.getPedidos();
        assertNotNull(pedidos, "La lista de pedidos no debería ser null.");
    }
	
	
	@Test
	void testGetMenuBase() {
		ArrayList<ProductoMenu> menuBase = restaurante1.getMenuBase();
        assertNotNull(menuBase, "El menu base no debería ser null.");
	}
}
