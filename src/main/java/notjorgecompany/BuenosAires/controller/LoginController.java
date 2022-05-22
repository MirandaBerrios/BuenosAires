package notjorgecompany.BuenosAires.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String showLogin()  {
		System.err.println("showing login");
		return "login";

	}

	
	@GetMapping({"/loginsuccess"})
	public String loginCheck() {
		return "redirect:/home";
	}
	
	
	

}
