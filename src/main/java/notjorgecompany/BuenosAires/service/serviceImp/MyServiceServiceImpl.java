package notjorgecompany.BuenosAires.service.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import notjorgecompany.BuenosAires.mapper.MyServiceMapper;
import notjorgecompany.BuenosAires.odt.MyService;
import notjorgecompany.BuenosAires.service.MyServiceService;
@Log4j2
@Service
public class MyServiceServiceImpl implements MyServiceService {

	@Autowired
	MyServiceMapper myServiceMapper;
		
	@Override
	public List<MyService> getAllService(String idCustomer) {
		log.info("Se obtienen todos los servicios para el usuario : "+ idCustomer );
		return myServiceMapper.getAllServiceByQuery(idCustomer);

	}

	@Override
	public boolean insertNewService(MyService myService) {
		if(myServiceMapper.insertNewService(myService)) {
			log.info("Se insertado un nuevo Servicio de manera correcta el servicio" + myService.getId());
			return true;
		}
		log.error("Ha ocurrido un errror al intentar guardar el servicio"+ myService.getId());
		return false;
	}

}
