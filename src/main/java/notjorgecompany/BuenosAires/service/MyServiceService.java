package notjorgecompany.BuenosAires.service;

import java.util.List;

import notjorgecompany.BuenosAires.odt.MyService;

public interface MyServiceService {
	public List<MyService> getAllService(String idCustomer);
	public boolean insertNewService(MyService myService);
}
