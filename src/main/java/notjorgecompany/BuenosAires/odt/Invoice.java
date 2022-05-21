package notjorgecompany.BuenosAires.odt;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Invoice {

	private  String id; 
	private  String idCustomer;
	private  String date; 
	private  String description; 
	private  String amount; 
	private  String idSell; 
	private  String idReleaseOrder; 
	private  String idProduct; 
	private  String idService;
}
