package notjorgecompany.BuenosAires;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import notjorgecompany.BuenosAires.mapper.ProductMapper;
import notjorgecompany.BuenosAires.odt.Product;
import notjorgecompany.BuenosAires.service.ProductService;

@SpringBootTest
class BuenosAiresApplicationTests {
	
	@Autowired
	ProductService productService; 
	
	@Autowired 
	ProductMapper productMapper; 
	
	@Test
	void contextLoads() {
		List<Product> productos = productService.getAllProducts();
		productos.forEach(producto -> {
			System.err.println(" ");
			System.err.println(" id : " + producto.getId());
			System.err.println(" producto: " + producto.getName());
			System.err.println(" $: " + producto.getValue());
			System.err.println(" ");
		});
		
	}

}
