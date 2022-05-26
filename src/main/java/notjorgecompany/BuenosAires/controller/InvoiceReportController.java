package notjorgecompany.BuenosAires.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import notjorgecompany.BuenosAires.odt.InvoiceReport;
import notjorgecompany.BuenosAires.service.InvoiceReportService;

@Controller
public class InvoiceReportController {
	@Autowired
	InvoiceReportService invoiceReportService;
	
	@GetMapping("/invoice_report_admin")
	public String showInvoicesAdmin(Model model)  {
		
		List<InvoiceReport> invoiceReportList = invoiceReportService.getInvoiceReportByQueryAdmin();
		System.err.println("listas->>"+invoiceReportList);
		model.addAttribute("invoiceReportList", invoiceReportList);
		System.err.println("cargando página invoices");
		
	
	return "invoice";

}
	@GetMapping("invoice_report_customer/{idCustomer}")
	@PostMapping("ajax/invoice_report_customer/{idCustomer}")
	public String showInvoicesCustomer(Model model, @PathVariable("idCustomer") String idCustomer, HttpServletRequest request)  {		
		List<InvoiceReport> invoiceReportList = invoiceReportService.getInvoiceReportByQueryCustomer(idCustomer); 
		System.err.println(" ");
		System.err.println("customers ->>"+invoiceReportList);
		model.addAttribute("invoiceReportList", invoiceReportList);
		System.err.println("cargando página invoices");
		
	
	return "invoice-customer";

}
	
	
}
