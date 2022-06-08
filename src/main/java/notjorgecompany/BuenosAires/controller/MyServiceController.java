package notjorgecompany.BuenosAires.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.transbank.webpay.exception.TransactionCreateException;
import cl.transbank.webpay.webpayplus.WebpayPlus;
import cl.transbank.webpay.webpayplus.model.WebpayPlusTransactionCreateResponse;
import notjorgecompany.BuenosAires.object.Customer;
import notjorgecompany.BuenosAires.odt.MyService;
import notjorgecompany.BuenosAires.service.CustomerService;
import notjorgecompany.BuenosAires.service.MyServiceService;

@Controller
public class MyServiceController {
	@Autowired
	MyServiceService myServiceService;
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/service")
	public ModelAndView showServiceView() {
		MyService defaultService = new MyService();
		defaultService.setPrice("50000");
		defaultService.setIdCustomer("10");
		defaultService.setIdState("1");
		List<MyService> serviceList = myServiceService.getAllService("10");	
		ModelAndView mav = new ModelAndView("myService");
		mav.addObject("myServiceList", serviceList);
		mav.addObject("myService", defaultService); 
		
		
		return mav;
	}
	
	
	@PostMapping("/service/payment")
	public ModelAndView payService(@Param("service") MyService myService){
		
			System.err.println("entrando...");
			System.err.println(myService);
			ModelAndView mav = new ModelAndView("buyService");
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
			String date = dtf.format(LocalDateTime.now());
			
			Customer customer = customerService.getCustomerById(myService.getIdCustomer());
		
			String respondUrl = "http://localhost:5000/service";
			
			Map<String, Object> details = new HashMap<>();
			details.put("buyOrder", myService.getPrice());
	        details.put("sessionId", myService.getDate()+myService.getHour());
	        details.put("amount", Double.parseDouble(myService.getPrice()));
	        details.put("returnUrl", respondUrl);
	        
	        MyService endService = new MyService();
	        
	        endService.setId("SE"+ customer.getId() + date );
	        endService.setType(myService.getType());
	        endService.setHour(myService.getHour());
	        endService.setDate(myService.getDate());
	        endService.setIdCustomer(customer.getId());
	        endService.setIdEmployee("00");
	        endService.setIdState("1"); 
	        endService.setDescription(myService.getDescription());
	        
	        //myServiceService.insertNewService(endService);
	        
	        
	        try {
	            final WebpayPlusTransactionCreateResponse response = WebpayPlus.Transaction.create("1001", endService.getId(),
	            																				  Double.parseDouble(myService.getPrice()),
	            																				  respondUrl);
	            details.put("url", response.getUrl());
	            details.put("token", response.getToken());
	            
	        } catch (TransactionCreateException | IOException e) {
	        	System.err.println(e);
	            return null;
	        }
	        
	        mav.addObject("details", details);
            return mav;	
		
	}
}
