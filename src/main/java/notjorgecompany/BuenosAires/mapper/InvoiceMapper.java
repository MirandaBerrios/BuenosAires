package notjorgecompany.BuenosAires.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import notjorgecompany.BuenosAires.odt.Invoice;

@Mapper
public interface InvoiceMapper {

@Select({" SELECT "
		+ "    id_invoice as \"id\","
		+ "    id_customer as \"idCustomer\","
		+ "    date_invoice as \"date\","
		+ "    description_invoice as \"description\","
		+ "    id_sell as \"idSell\",\r\n"
		+ "    id_release_order as \"idReleaseOrder\","
		+ "    id_product as \"idProduct\","
		+ "    id_service as \"idService\", "
		+ "	   amount "
		+ " FROM "
		+ " invoice"})
 List<Invoice> getAllInvoice();





}
