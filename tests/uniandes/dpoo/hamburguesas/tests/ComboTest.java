package uniandes.dpoo.hamburguesas.tests;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Combo;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ComboTest {
	//pruebas para la clase Combo
	
	private Combo combo1;
	private ArrayList<ProductoMenu> itemsCombo = new ArrayList<ProductoMenu>();
	private ProductoMenu producto1 = new ProductoMenu("papas fritas", 5000);
	private ProductoMenu producto2 = new ProductoMenu("hamburguesa sencilla", 12000);
	private ProductoMenu producto3 = new ProductoMenu("gaseosa", 3000);
	
	
	
	
	@BeforeEach
	void setUp() throws Exception{
		agregarProductos();
		combo1 = new Combo("combo basico", 0.10, itemsCombo);
	}
	@AfterEach
    void tearDown( ) throws Exception{
    }
	
	@Test
	private void testGetNombre() {
		assertEquals("combo basico", combo1.getNombre(), "El nombre del combo no es el esperado.");
	}
	
	@Test
	private void getPrecio() {
        assertEquals(18000, combo1.getPrecio(), "El precio del combo no es el esperado.");
	}
	
	
	
	private void agregarProductos() {
		itemsCombo.add(producto1);
		itemsCombo.add(producto2);
		itemsCombo.add(producto3);
	}
}
