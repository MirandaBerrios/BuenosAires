package notjorgecompany.BuenosAires.odt;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InvoiceReport {
	  	private String numberInvoice;
	    private String nameCustomer;
	    private String date;
	    private String description;
	    private String amount;
	    private String releaseOrder;
	    private String stateReleaseOrder;
	    private String numberService;
	    private String stateService;

}
