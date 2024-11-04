package uniandes.dpoo.hamburguesas.tests;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uniandes.dpoo.hamburguesas.mundo.*;


public class PedidoTest {
	
	private Pedido pedido1;
	private Pedido pedido2;
	private Pedido pedido3;
	
	private ArrayList<ProductoMenu> items = new ArrayList<ProductoMenu>();
	private ProductoMenu producto1 = new ProductoMenu("papas fritas", 5000);
	private ProductoMenu producto2 = new ProductoMenu("hamburguesa sencilla", 12000);
	private ProductoMenu producto3 = new ProductoMenu("gaseosa", 3000);
	
	
	
	@BeforeEach
	void setUp() throws Exception{
		agregarProductos();
		pedido1 = new Pedido("pedro", "carrera 8");
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testGetIdPedido() {
		assertEquals(0, pedido1.getIdPedido(), "El id del pedido no es el esperado.");
	}
	

	
	@Test
	void testGetNombreCliente() {
		assertEquals("pedro", pedido1.getNombreCliente(), "El nombre del cliente no es el esperado.");
	}
	
	@Test
	void testgetPrecioTotal() {
        pedido1.agregarProducto(producto1);
        assertEquals(producto1.getPrecio()+ producto1.getPrecio()*0.19, pedido1.getPrecioTotalPedido(), "El producto no se agregó correctamente.");
    }
	
	@Test
	void testgetPrecioTotalVarios() {
        pedido1.agregarProducto(producto1);
        pedido1.agregarProducto(producto2);
        pedido1.agregarProducto(producto3);
        assertEquals((producto1.getPrecio()+ producto1.getPrecio()*0.19 + producto2.getPrecio()+ producto2.getPrecio()*0.19 + producto3.getPrecio()+ producto3.getPrecio()*0.19), pedido1.getPrecioTotalPedido(), "El producto no se agregó correctamente.");
    }
	
	@Test
	void testGenerarTextoFactura() {
		pedido1.agregarProducto(producto1);
        pedido1.agregarProducto(producto2);
        pedido1.agregarProducto(producto3);
        String factura = pedido1.generarTextoFactura();
        assertTrue(factura.contains("pedro"));
        assertTrue(factura.contains("carrera 8"));
        assertTrue(factura.contains("Precio Neto:  20000"));
        assertTrue(factura.contains("IVA:          3800"));
        assertTrue(factura.contains("Precio Total: 23800"));
		
	}
	
	
	
	
	private void agregarProductos() {
		items.add(producto1);
		items.add(producto2);
		items.add(producto3);
	}

}
