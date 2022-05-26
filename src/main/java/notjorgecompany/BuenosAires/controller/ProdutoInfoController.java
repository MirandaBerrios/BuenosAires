package notjorgecompany.BuenosAires.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import notjorgecompany.BuenosAires.odt.Product;
import notjorgecompany.BuenosAires.service.ProductService;

@Controller
public class ProdutoInfoController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/producto-info")
	public String showProductById(Model model) {	
		Product producto = productService.getProductById("10");
		model.addAttribute("producto", producto);
		return "producto-info";
		
	};
	
	
	
	
	
}
