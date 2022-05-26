package notjorgecompany.BuenosAires.ApiRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import notjorgecompany.BuenosAires.odt.InvoiceReport;
import notjorgecompany.BuenosAires.odt.Product;
import notjorgecompany.BuenosAires.service.InvoiceReportService;
import notjorgecompany.BuenosAires.service.ProductService;

@RestController
@RequestMapping("/api")

public class ApiRest {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	InvoiceReportService invoiceReportService; 
	
	@GetMapping("product")
	public ResponseEntity<?> getAllProduct() {
		try {
			List<Product> productList= productService.getAllProducts(); 
			return new ResponseEntity<List<Product>>(productList , HttpStatus.OK);
		} catch (Error  e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping("product/{id}")
	public ResponseEntity<?> getProductById(@PathVariable("id") String id) throws JsonProcessingException {
		try {
			Product producto = productService.getProductById(id);
			return new ResponseEntity<Product>(producto , HttpStatus.OK);
			
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}

	}
	
	@GetMapping("invoice")
	public ResponseEntity<?> getAllInvoices(){
		try {
			List<InvoiceReport> invoiceList= invoiceReportService.getInvoiceReportByQueryAdmin();
			return new ResponseEntity<List<InvoiceReport>>(invoiceList, HttpStatus.OK);
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}
	
	
	
	
	
	
}
