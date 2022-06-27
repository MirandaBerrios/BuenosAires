package notjorgecompany.BuenosAires.odt;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ReleaseOrder {
	private String id;
	private String idCustomer;
	private String idState;
	private String idProduct;
	private String idSell;
	private String idInvoice;
}
