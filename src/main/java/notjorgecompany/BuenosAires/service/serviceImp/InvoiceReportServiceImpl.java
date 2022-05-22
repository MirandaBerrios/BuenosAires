package notjorgecompany.BuenosAires.service.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import notjorgecompany.BuenosAires.mapper.InvoiceReportMapper;
import notjorgecompany.BuenosAires.odt.Invoice;
import notjorgecompany.BuenosAires.odt.InvoiceReport;
import notjorgecompany.BuenosAires.service.InvoiceReportService;

@Service
public class InvoiceReportServiceImpl implements InvoiceReportService {
	
	@Autowired
	InvoiceReportMapper invoiceReportMapper;
	
	@Override
	public List<InvoiceReport> getInvoiceReportByQueryAdmin() {
		System.err.println(invoiceReportMapper.getInvioceReportByQuery());
		return invoiceReportMapper.getInvioceReportByQuery();
		
	}

	@Override
	public List<InvoiceReport> getInvoiceReportByQueryCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

}
