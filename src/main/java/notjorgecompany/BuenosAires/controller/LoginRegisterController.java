package notjorgecompany.BuenosAires.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import notjorgecompany.BuenosAires.object.Customer;
import notjorgecompany.BuenosAires.service.CustomerService;

@Controller
public class LoginRegisterController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/register")
	public String getRegisterView(Model model) {
		
		Customer customer = new Customer();
		
		model.addAttribute("customer", customer);
		return "register"; 
	}
	
	
	@PostMapping("/register_new_customer")
	public String registerNewCustomer(@ModelAttribute("customer") Customer customer,HttpServletRequest request) {
		customerService.insertNewCustomer(customer); 
		return "redirect:/home"; 
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
