package notjorgecompany.BuenosAires.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import notjorgecompany.BuenosAires.odt.Product;
import notjorgecompany.BuenosAires.service.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	ProductService productService; 
	
	@GetMapping("/")
	public String showProducts(Model model)  {
			
			List<Product> productos = productService.getAllProducts();
			model.addAttribute("productos", productos);
			System.err.println("mostando home");

		return "home";

	}
	
	

}
