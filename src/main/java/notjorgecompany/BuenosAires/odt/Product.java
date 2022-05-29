package notjorgecompany.BuenosAires.odt;

import java.util.Base64;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product {

	private String id; 
	private String name; 
	private String value; 
	private String mark; 
	private String isAvailable; 
	private String image; 
	private String isOfert; 
	private String model; 
	private String category; 
	private String description; 
}
