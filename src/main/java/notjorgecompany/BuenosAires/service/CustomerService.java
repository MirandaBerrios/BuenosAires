package notjorgecompany.BuenosAires.service;

import notjorgecompany.BuenosAires.object.Customer;

public interface CustomerService {
	public void insertNewCustomer(Customer customer);
	public Customer getCustomerById(String id); 
	public void updateCustomer(Customer customer);
}
