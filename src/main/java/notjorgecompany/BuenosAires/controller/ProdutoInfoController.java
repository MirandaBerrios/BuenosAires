package notjorgecompany.BuenosAires.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.transbank.webpay.exception.TransactionCreateException;
import cl.transbank.webpay.webpayplus.WebpayPlus;
import cl.transbank.webpay.webpayplus.model.WebpayPlusTransactionCreateResponse;
import notjorgecompany.BuenosAires.ErrorController;
import notjorgecompany.BuenosAires.odt.Product;
import notjorgecompany.BuenosAires.service.ProductService;

@Controller
public class ProdutoInfoController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/producto-info")
	public ModelAndView showProductById(Model model) {	
		Product producto = productService.getProductById("10");
		model.addAttribute("producto", producto);
		
		ModelAndView mav = new ModelAndView("/producto-info");
		
        Map<String, Object> details = new HashMap<>();
        details.put("buyOrder", "1001");
        details.put("sessionId", "10");
        details.put("amount", 650000);
        details.put("returnUrl", "http://localhost:8080/");

        try {
            final WebpayPlusTransactionCreateResponse response = WebpayPlus.Transaction.create("1001", "10", 650000, "http://localhost:8080/");
            details.put("url", response.getUrl());
            details.put("token", response.getToken());
        } catch (TransactionCreateException | IOException e) {
        	System.err.println(e);
            return null;
        }
        mav.addObject("producto", producto);
        mav.addObject("details", details);
		return mav;
		
	};
	
	
	
	
	
	
	
}
