package notjorgecompany.BuenosAires.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import notjorgecompany.BuenosAires.odt.MyService;

@Mapper
public interface MyServiceMapper {
	
@Select({"SELECT "
		+ "    se.id_service as \"id\","
		+ "    se.description_service as \"description\","
		+ "    se.price_service as \"price\","
		+ "    CONCAT(CONCAT(emp.name_employee ,' ' ),emp.lastname_employee) as \"idEmployee\","
		+ "    se.id_customer as \"idCustomer\","
		+ "    se.date_service as \"date\","
		+ "    se.hour_service as \"hour\","
		+ "    st.state as \"idState\""
		+ " FROM  service se "
		+ " join employee emp on se.id_employee=emp.id_employee "
		+ " join state_service st  on se.id_state = st.id_state_service "
		+ " WHERE id_customer = #{idCustomer}"})
public List<MyService> getAllServiceByQuery(@Param("idCustomer") String idCustomer);


@Insert({"INSERT INTO service ("
		+ "    id_service,"
		+ "    description_service,"
		+ "    price_service,"
		+ "    id_employee,"
		+ "    id_customer,"
		+ "    date_service,"
		+ "    hour_service,"
		+ "    id_state"
		+ ") VALUES ("
		+ "    #{id},"
		+ "    #{description},"
		+ "    #{price},"
		+ "    #{idEmployee},"
		+ "    #{idCustomer},"
		+ "    #{date},"
		+ "    #{hour},"
		+ "    #{idState}"
		+ ")"})
public boolean insertNewService(MyService myService);
}
