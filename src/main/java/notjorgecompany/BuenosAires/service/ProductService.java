package notjorgecompany.BuenosAires.service;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import notjorgecompany.BuenosAires.odt.Product;

public interface ProductService {
	
	public List<Product> getAllProducts();

	public Product getProductById(String id);
	

	

	public int addNewProduct(Product product);
	

	
}
