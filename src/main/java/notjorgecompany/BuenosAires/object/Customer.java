package notjorgecompany.BuenosAires.object;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Customer {

	private String id;
	private String name;
	private String lastName;
	private String password;
	private String repeatPassword;
	private String rut;
	private String email;
	private String adress;
	private String isAuthenticate;
	private String isOnline;
}
