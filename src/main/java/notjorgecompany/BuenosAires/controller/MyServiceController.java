package notjorgecompany.BuenosAires.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import notjorgecompany.BuenosAires.odt.MyService;
import notjorgecompany.BuenosAires.service.MyServiceService;

@Controller
public class MyServiceController {
	@Autowired
	MyServiceService myServiceService;
	
	@GetMapping("/service")
	public ModelAndView showServiceView() {
		
		List<MyService> serviceList = myServiceService.getAllService("10");
		ModelAndView mav = new ModelAndView("myService");
		mav.addObject("myServiceList", serviceList);
		return mav;
	}
	
}
