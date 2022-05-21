package notjorgecompany.BuenosAires.service.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import notjorgecompany.BuenosAires.mapper.InvoiceMapper;
import notjorgecompany.BuenosAires.odt.Invoice;
import notjorgecompany.BuenosAires.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	InvoiceMapper invoiceMapper; 
	

	@Override
	public List<Invoice> getAllInvoices() {
		
		return  invoiceMapper.getAllInvoice();
		
	}

}
