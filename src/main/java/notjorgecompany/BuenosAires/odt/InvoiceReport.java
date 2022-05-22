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
	    private String fecha;
	    private String descripcion;
	    private String monto;
	    private String ordenDespacho;
	    private String estadoOrdenDespacho;
	    private String numeroServicio;
	    private String stateServicio;

}
