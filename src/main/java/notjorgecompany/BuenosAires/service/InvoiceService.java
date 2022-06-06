package notjorgecompany.BuenosAires.service;

import java.util.List;

import notjorgecompany.BuenosAires.odt.Invoice;

public interface InvoiceService {

	public List<Invoice> getAllInvoices(); 
	
	public boolean insertNewInvoice(Invoice invoice); 
}
