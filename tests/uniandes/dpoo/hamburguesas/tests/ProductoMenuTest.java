package uniandes.dpoo.hamburguesas.tests;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductoMenuTest {
	
	//pruebas para la clase productoMenu
	private ProductoMenu productoMenu1;

	@BeforeEach
	void setUp()throws Exception{
		productoMenu1 = new ProductoMenu("papas fritas", 5000);
	}
	
	@AfterEach
    void tearDown( ) throws Exception{
    }
	
	
	@Test
	void getNombre() {
		assertEquals("papas fritas", productoMenu1.getNombre(), "El nombre del ingrediente no es el esperado." );
	}
	
	@Test
	void getPrecio() {
		assertEquals(5000, productoMenu1.getPrecio(), "El precio del ingrediente no es el esperado." );
	}
}
