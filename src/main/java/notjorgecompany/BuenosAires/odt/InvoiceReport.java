package notjorgecompany.BuenosAires.odt;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InvoiceReport {
	  	private String numeroFactura;
	    private String nameCustomer;
	    private String date;
	    private String description;
	    private String amount;
	    private String releaseOrder;
	    private String stateReleaseOrder;
	    private String stateService;

}
