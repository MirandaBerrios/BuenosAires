package notjorgecompany.BuenosAires.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import notjorgecompany.BuenosAires.object.Customer;
import notjorgecompany.BuenosAires.service.CustomerService;

@Controller
public class PerfilController {
	
	@Autowired
	CustomerService customerService; 
	

	@GetMapping("/perfil")
	public ModelAndView getRegisterView(Model model) {
		ModelAndView mav = new ModelAndView("perfil");
		Customer customer = customerService.getCustomerById("10");		
		mav.addObject("customer", customer);
		return mav; 
	}
	
	
	@PostMapping("/update_new_customer")
	public String registerNewCustomer(@ModelAttribute("customer") Customer customer,HttpServletRequest request) {
		System.err.println("entramos");
		try {
			customerService.updateCustomer(customer); 
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return "redirect:/"; 
		
	}
		
	
	

}
