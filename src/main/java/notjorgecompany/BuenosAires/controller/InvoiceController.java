package notjorgecompany.BuenosAires.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import notjorgecompany.BuenosAires.odt.Invoice;
import notjorgecompany.BuenosAires.service.InvoiceService;

@Controller
public class InvoiceController {
	
	@Autowired
	InvoiceService invoiceService; 
	
	@GetMapping("/invoices")
	public String showInvoices(Model model)  {
			
			List<Invoice> invoiceList = invoiceService.getAllInvoices();
			System.err.println("listas->>"+invoiceList);
			model.addAttribute("invoiceList", invoiceList);
			System.err.println("cargando página invoices");
			
		
		return "invoice";

	}

}
	

