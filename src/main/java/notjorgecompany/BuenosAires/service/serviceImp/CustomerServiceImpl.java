package notjorgecompany.BuenosAires.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import notjorgecompany.BuenosAires.mapper.CustomerMapper;
import notjorgecompany.BuenosAires.object.Customer;
import notjorgecompany.BuenosAires.service.CustomerService;


@Log4j2
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerMapper customerMapper; 
	
	@Override
	public void insertNewCustomer(Customer customer) {
		int registro = customerMapper.insertNewCustomer(customer);
		log.info("Se ha creado con éxito " + registro + "nuevo cliente");

	}

}
