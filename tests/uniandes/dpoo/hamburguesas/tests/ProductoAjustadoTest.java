package uniandes.dpoo.hamburguesas.tests;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uniandes.dpoo.hamburguesas.mundo.*;


public class ProductoAjustadoTest {

	private ProductoAjustado productoAjustado1;
	private ProductoMenu producto1 = new ProductoMenu("hamburguesa sencilla", 12000);
	private Ingrediente ingrediente1 = new Ingrediente("Queso", 2000);
    private Ingrediente ingrediente2 = new Ingrediente("Tocineta", 3000);
	
	@BeforeEach
	void setUp() throws Exception {
		productoAjustado1 = new ProductoAjustado(producto1);
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testGetNombre() {
		assertEquals("hamburguesa sencilla", productoAjustado1.getNombre(), "El nombre del producto no es el esperado.");
	}

	
	@Test
	void testGetPrecio() {
		productoAjustado1.add(ingrediente1);
        productoAjustado1.add(ingrediente2);
        assertEquals(17000, productoAjustado1.getPrecio());
	}
	
	@Test
	void testGenerarTextoFactura() {
        productoAjustado1.add(ingrediente1);
        productoAjustado1.remove(ingrediente2);
        String factura = productoAjustado1.generarTextoFactura();

        assertTrue(factura.contains("hamburguesa"));
        assertTrue(factura.contains("+Queso                2000"));
        assertTrue(factura.contains("-Tocineta"));
        assertTrue(factura.contains("14000")); // Base price + Queso
    }
	
	
	
	
	
	
}
