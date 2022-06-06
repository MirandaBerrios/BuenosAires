package notjorgecompany.BuenosAires.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import notjorgecompany.BuenosAires.odt.InvoiceReport;


@Mapper
public interface InvoiceReportMapper {

	@Select({"SELECT"
			+ "    inc.id_invoice        AS \"numberInvoice\","
			+ "    cu.name_customer      AS \"nameCustomer\","
			+ "    inc.date_invoice      AS \"date\","
			+ "    pr.name               AS \"description\","
			+ "    pr.value              AS \"amount\","
			+ "    ro.id_release_order   AS \"releaseOrder\","
			+ "    sto.state             AS \"stateReleaseOrder\","
			+ "    se.id_service         AS \"numberService\","
			+ "    stse.state            AS \"stateService\" "
			+ "FROM"
			+ "    invoice               inc"
			+ "    JOIN customer              cu ON inc.id_customer = cu.id_customer"
			+ "    JOIN product               pr ON pr.id = inc.id_product"
			+ "    JOIN service               se ON se.id_service = inc.id_service"
			+ "    JOIN release_order         ro ON ro.id_release_order = inc.id_release_order"
			+ "    JOIN state_release_order   sto ON sto.id_state_release_order = ro.id_state"
			+ "    JOIN state_service         stse ON stse.id_state_service = se.id_state"})
	public List<InvoiceReport> getInvioceReportByQuery();
	
	
	@Select({"SELECT"
			+ "    inc.id_invoice        AS \"numberInvoice\","
			+ "    cu.name_customer      AS \"nameCustomer\","
			+ "    inc.date_invoice      AS \"date\","
			+ "    pr.name               AS \"description\","
			+ "    pr.value              AS \"amount\","
			+ "    ro.id_release_order   AS \"releaseOrder\","
			+ "    sto.state             AS \"stateReleaseOrder\","
			+ "    se.id_service         AS \"numberService\","
			+ "    stse.state            AS \"stateService\" "
			+ "FROM"
			+ "    invoice               inc"
			+ "    JOIN customer              cu ON inc.id_customer = cu.id_customer"
			+ "    JOIN product               pr ON pr.id = inc.id_product"
			+ "    JOIN service               se ON se.id_service = inc.id_service"
			+ "    JOIN release_order         ro ON ro.id_release_order = inc.id_release_order"
			+ "    JOIN state_release_order   sto ON sto.id_state_release_order = ro.id_state"
			+ "    JOIN state_service         stse ON stse.id_state_service = se.id_state"
			+ " WHERE cu.id_customer = #{idCustomer}"})
	public List<InvoiceReport> getInvioceReportByQueryCustomer(@Param("idCustomer") String idCustomer);
}
