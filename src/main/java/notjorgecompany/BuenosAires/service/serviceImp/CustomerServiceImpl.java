package notjorgecompany.BuenosAires.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import notjorgecompany.BuenosAires.mapper.CustomerMapper;
import notjorgecompany.BuenosAires.object.Customer;
import notjorgecompany.BuenosAires.service.CustomerService;



@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerMapper customerMapper; 
	
	@Override
	public void insertNewCustomer(Customer customer) {
		customerMapper.insertNewCustomer(customer);


	}

	@Override
	public Customer getCustomerById(String id) {
		return customerMapper.getCustomerById(id);
		
	}
	
	@Override
	 public void updateCustomer(Customer customer){
		try {
			customerMapper.updateCustomer(customer);
		} catch (Exception e) {
			System.err.println(e);
		}
		
		
		
	}


}
