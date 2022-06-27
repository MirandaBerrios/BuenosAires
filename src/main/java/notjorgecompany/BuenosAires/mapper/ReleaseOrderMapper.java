package notjorgecompany.BuenosAires.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import notjorgecompany.BuenosAires.odt.ReleaseOrder;

@Mapper
public interface ReleaseOrderMapper {
	@Select({"SELECT"
			+ "    id_release_order as \"id\", "
			+ "    id_customer as \"idCustomer\", "
			+ "    id_state as \"idState\", "
			+ "    id_product as \"idProduct\", "
			+ "    id_sell as \"idSell\", "
			+ "    id_invoice as \"idInvoice\""
			+ "FROM"
			+ "    release_order"})
	public List<ReleaseOrder> getAllReleaseOrder();
	
	@Insert({"INSERT INTO release_order ( "
			+ "    id_release_order, "
			+ "    id_customer, "
			+ "    id_state, "
			+ "    id_product, "
			+ "    id_sell, "
			+ "    id_invoice "
			+ ") VALUES ( "
			+ "    #{releaseOrder.id}, "
			+ "    #{releaseOrder.idCustomer}, "
			+ "    #{releaseOrder.idState}, "
			+ "    #{releaseOrder.idProduct}, "
			+ "    #{releaseOrder.idSell}, "
			+ "    #{releaseOrder.idInvoice} "
			+ ")"})
	public void insertReleaseOrder(@Param("releaseOrder")ReleaseOrder releaseOrder);
	
}	

