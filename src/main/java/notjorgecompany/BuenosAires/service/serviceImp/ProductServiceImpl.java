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
		return productos;
	}

}
