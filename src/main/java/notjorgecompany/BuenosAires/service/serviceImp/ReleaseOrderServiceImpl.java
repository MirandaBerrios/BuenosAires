package notjorgecompany.BuenosAires.service.serviceImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import notjorgecompany.BuenosAires.mapper.ReleaseOrderMapper;
import notjorgecompany.BuenosAires.odt.ReleaseOrder;
import notjorgecompany.BuenosAires.service.ReleaseOrderService;


@Service
public class ReleaseOrderServiceImpl implements ReleaseOrderService {
	@Autowired
	ReleaseOrderMapper releaseOrderMapper;
	@Override
	public void insertReleaseOrder(ReleaseOrder releaseOrder) {
		releaseOrderMapper.insertReleaseOrder(releaseOrder);
		System.err.println("insertamos orden");
	}

}
