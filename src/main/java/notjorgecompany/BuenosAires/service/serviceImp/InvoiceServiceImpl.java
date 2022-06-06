package notjorgecompany.BuenosAires.service.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import notjorgecompany.BuenosAires.mapper.InvoiceMapper;
import notjorgecompany.BuenosAires.odt.Invoice;
import notjorgecompany.BuenosAires.service.InvoiceService;
@Log4j2
@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	InvoiceMapper invoiceMapper; 
	

	@Override
	public List<Invoice> getAllInvoices() {
		
		return  invoiceMapper.getAllInvoice();
		
	}


	@Override
	public boolean insertNewInvoice(Invoice invoice) {
		if(invoiceMapper.insertInvoice(invoice) == 1) {
			log.info("Se ha insertado con éxito una nueva factura");
			return true; 
		}
		
		return false;
	}

}
