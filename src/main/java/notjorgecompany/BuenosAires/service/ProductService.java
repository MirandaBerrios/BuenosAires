package notjorgecompany.BuenosAires.service;

import java.util.List;

import notjorgecompany.BuenosAires.odt.Product;

public interface ProductService {
	
	public List<Product> getAllProducts();

	public Product getProductById();
}
