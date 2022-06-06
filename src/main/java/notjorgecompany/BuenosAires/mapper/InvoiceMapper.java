package notjorgecompany.BuenosAires.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Insert;
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
		+ "    id_sell as \"idSell\","
		+ "    id_release_order as \"idReleaseOrder\","
		+ "    id_product as \"idProduct\","
		+ "    id_service as \"idService\", "
		+ "	   amount "
		+ " FROM "
		+ " invoice"})
 List<Invoice> getAllInvoice();


@Insert({"INSERT INTO invoice ("
		+ "    id_invoice,"
		+ "    id_customer,"
		+ "    date_invoice,"
		+ "    description_invoice,"
		+ "    id_sell,"
		+ "    id_release_order,"
		+ "    id_product,"
		+ "    id_service,"
		+ "    amount"
		+ ") VALUES ("
		+ "    #{id}"
		+ "    #{idCustomer},"
		+ "    #{date},"
		+ "    #{desscription},"
		+ "    #{idSell},"
		+ "    #{idReleaseOrder},"
		+ "    #{idProduct},"
		+ "    #{idServive},"
		+ "    #{amount})"
		})
public int insertInvoice(Invoice invoice); 





}
