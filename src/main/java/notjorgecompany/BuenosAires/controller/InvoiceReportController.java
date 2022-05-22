package notjorgecompany.BuenosAires.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import notjorgecompany.BuenosAires.odt.Invoice;
import notjorgecompany.BuenosAires.odt.InvoiceReport;
import notjorgecompany.BuenosAires.service.InvoiceReportService;

@Controller
public class InvoiceReportController {
	@Autowired
	InvoiceReportService invoiceReportService;
	
	@GetMapping("/invoiceReport")
	public String showInvoices(Model model)  {
		
		List<InvoiceReport> invoiceReportList = invoiceReportService.getInvoiceReportByQueryAdmin();
		System.err.println("listas->>"+invoiceReportList);
		model.addAttribute("invoiceReportList", invoiceReportList);
		System.err.println("cargando página invoices");
		
	
	return "invoice";

}
	
	
}
