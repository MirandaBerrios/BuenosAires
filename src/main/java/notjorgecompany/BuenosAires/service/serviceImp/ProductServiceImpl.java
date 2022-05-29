package notjorgecompany.BuenosAires.service.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
		Product product = productMapper.getProductById(id);
		
		return product;
		
	}

	@Override
	public Product productoPorId(String id, Model model) {
		// TODO Auto-generated method stub
		
		return null;
	}


	
	
	
	

}
