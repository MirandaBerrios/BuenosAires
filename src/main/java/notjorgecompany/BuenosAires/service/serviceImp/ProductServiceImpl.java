package notjorgecompany.BuenosAires.service.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import notjorgecompany.BuenosAires.mapper.ProductMapper;
import notjorgecompany.BuenosAires.odt.Product;
import notjorgecompany.BuenosAires.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductMapper productMapper; 
	
	@Override
	public List<Product> getAllProducts() {
		List<Product> productos = productMapper.getAllProduct();
		
		
		productos.forEach(p ->{
			if(p.getIsAvailable().toUpperCase().equals("S")){
				p.setIsAvailable("Disponible");
			}else {
				p.setIsAvailable("Agotado");
			};
		});
		
		return productos;
	}

	@Override
	public Product getProductById(String id) {
		Product product = productMapper.getProductById("10");
		return product;
		
	}

	@Override
	public int addNewProduct(Product product) {
		System.err.println("guardando ... "+product.getName() );
		return productMapper.addNewProduct(product);
			
	}


	
	
	
	

}
