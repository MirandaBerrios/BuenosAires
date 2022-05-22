package notjorgecompany.BuenosAires.service;

import java.util.List;

import notjorgecompany.BuenosAires.odt.InvoiceReport;

public interface InvoiceReportService {

	public List<InvoiceReport> getInvoiceReportByQueryAdmin();
	public List<InvoiceReport> getInvoiceReportByQueryCustomer();
	
}
