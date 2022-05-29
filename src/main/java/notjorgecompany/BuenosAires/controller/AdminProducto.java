package notjorgecompany.BuenosAires.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import notjorgecompany.BuenosAires.odt.Product;
import notjorgecompany.BuenosAires.service.ProductService;
@Controller
public class AdminProducto {
	
		@Autowired
		ProductService productService; 
	
		@GetMapping("/admin-product")
		public ModelAndView showAdminProducto() {
			ModelAndView mav = new ModelAndView("admin-producto");
			Product producto = new Product(); 
			mav.addObject("product", producto); 
			
			return mav;
		
		}
		
		
		@PostMapping("/add-product")
		public String addNewProduct(@ModelAttribute("producto") Product producto) {
			System.err.println("producto -> " + producto);
			producto.setImage("");
			productService.addNewProduct(producto);
			return "redirect:/";
		}
	 
}
