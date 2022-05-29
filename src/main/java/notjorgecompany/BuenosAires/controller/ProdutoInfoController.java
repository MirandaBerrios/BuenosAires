package notjorgecompany.BuenosAires.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@GetMapping("/producto-info/{id}")
	public ModelAndView showProductById(@PathVariable String id) {	
		Product producto = productService.getProductById(id);

		
		ModelAndView mav = new ModelAndView("/producto-info");
		
        Map<String, Object> details = new HashMap<>();
        details.put("buyOrder", "1001");
        details.put("sessionId", producto.getId());
        details.put("amount", Double.parseDouble(producto.getValue()));
        details.put("returnUrl", "http://localhost:8080/");

        try {
            final WebpayPlusTransactionCreateResponse response = WebpayPlus.Transaction.create("1001", producto.getId() , Double.parseDouble(producto.getValue()), "http://localhost:8080/");
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
	
	@GetMapping("/producto-info-admin/{id}")
	public ModelAndView showProductByIdAdmin(@PathVariable String id) {	
		Product producto = productService.getProductById(id);

		
		ModelAndView mav = new ModelAndView("/producto-info-admin");
		
        Map<String, Object> details = new HashMap<>();
        details.put("buyOrder", "1001");
        details.put("sessionId", producto.getId());
        details.put("amount", Double.parseDouble(producto.getValue()));
        details.put("returnUrl", "http://localhost:8080/");

        try {
            final WebpayPlusTransactionCreateResponse response = WebpayPlus.Transaction.create("1001", producto.getId() , Double.parseDouble(producto.getValue()), "http://localhost:8080/");
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
