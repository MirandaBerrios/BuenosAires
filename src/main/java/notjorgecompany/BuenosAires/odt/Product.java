package notjorgecompany.BuenosAires.odt;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

	private String id; 
	private String name; 
	private String value; 
	private String mark; 
	private String isAvailiable; 
	private List<Image> image; 
	private String isOfert; 
	private String model; 
	private Category category; 
	private String description; 
}
