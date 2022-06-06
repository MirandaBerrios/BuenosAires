package notjorgecompany.BuenosAires.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.transbank.webpay.exception.TransactionCreateException;
import cl.transbank.webpay.webpayplus.WebpayPlus;
import cl.transbank.webpay.webpayplus.model.WebpayPlusTransactionCreateResponse;
import notjorgecompany.BuenosAires.object.Customer;
import notjorgecompany.BuenosAires.odt.Invoice;
import notjorgecompany.BuenosAires.odt.InvoiceReport;
import notjorgecompany.BuenosAires.odt.Product;
import notjorgecompany.BuenosAires.service.CustomerService;
import notjorgecompany.BuenosAires.service.InvoiceService;
import notjorgecompany.BuenosAires.service.ProductService;

@Controller
public class ProdutoInfoController {

	@Autowired
	ProductService productService;
	
	@Autowired
	CustomerService customerService; 
	
	@Autowired 
	InvoiceService invoiceService;
	
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
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		String date = dtf.format(LocalDateTime.now());
		
		Product product = productService.getProductById(id);
		ModelAndView mav = new ModelAndView("/producto-info-admin");
		String buyOrder = "SO"+product.getId()+product.getId()+ date;
		
        Map<String, Object> details = new HashMap<>();
        details.put("buyOrder", buyOrder);
        details.put("sessionId", product.getId());
        details.put("amount", Double.parseDouble(product.getValue()));
        String respondUrl = "http://localhost:8080/buySuccess/" + product.getId()+"/"+"10" + "/"+ buyOrder;
        details.put("returnUrl", respondUrl);

        try {
            final WebpayPlusTransactionCreateResponse response = WebpayPlus.Transaction.create("1001", product.getId(),
            																				  Double.parseDouble(product.getValue()),
            																				  respondUrl);
            details.put("url", response.getUrl());
            details.put("token", response.getToken());
        } catch (TransactionCreateException | IOException e) {
        	System.err.println(e);
            return null;
        }
        mav.addObject("producto", product);
        mav.addObject("details", details);
		return mav;
		
	};
	
	@PostMapping("/buySuccess/{idProduct}/{idCustomer}/{buyOrder}")
	public ModelAndView generateInvoice(@PathVariable String idProduct,
										@PathVariable String idCustomer,
										@PathVariable String buyOrder) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss");
		String dateNow = dtf.format(LocalDateTime.now());
		Product product = productService.getProductById(idProduct);
		Customer customer = customerService.getCustomerById(idCustomer);
		InvoiceReport invReport = new InvoiceReport();
		
		invReport.setNumeroFactura("IN"+customer.getId()+product.getId()+dateNow);
		invReport.setNameCustomer(customer.getName()+" "+customer.getLastName());
		invReport.setDate(dateNow);
		invReport.setDescription(product.getName());
		invReport.setAmount(product.getValue());
		invReport.setReleaseOrder("RO"+customer.getId()+product.getId()+dateNow);
		//1,noAplica 2,enBodega 3,Despado 4,entregado
		invReport.setStateReleaseOrder("2");
		//1,aceptado 2,modificado 3,cerrado
		invReport.setStateService("1");
		
		Invoice invoice = new Invoice();
		invoice.setId("IN"+customer.getId()+product.getId()+dateNow);
		invoice.setIdCustomer(customer.getId());
		invoice.setDate(dateNow);
		invoice.setDescription(product.getName());
		invoice.setAmount(product.getValue());
		invoice.setIdSell(buyOrder);
		invoice.setIdReleaseOrder("RO"+customer.getId()+product.getId()+dateNow);
		invoice.setIdProduct(product.getId());
		invoice.setIdService("SE"+customer.getId()+product.getId()+dateNow);
		
		//invoiceService.insertNewInvoice(invoice);
		
		ModelAndView mav = new ModelAndView("buyView");
		mav.addObject("invoice", invoice);
		mav.addObject("invoiceReport", invReport); 
		mav.addObject("product", product);
		mav.addObject("customer", customer);
		
		
		return mav;
	}
	


	
	
	
	
	
}
