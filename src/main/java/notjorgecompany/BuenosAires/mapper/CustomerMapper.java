package notjorgecompany.BuenosAires.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import notjorgecompany.BuenosAires.object.Customer;

@Mapper
public interface CustomerMapper {

@Insert({"INSERT INTO customer ("
		+ "    name_customer,"
		+ "    lastname_customer,"
		+ "    password_customer,"
		+ "    repeatpassword_customer,"
		+ "    rut_customer,"
		+ "    email_customer,"
		+ "    adress_customer"
		+ ") VALUES ("
		+ "    #{name},"
		+ "    #{lastName},"
		+ "    #{password},"
		+ "    #{repeatPassword},"
		+ "    #{rut},"
		+ "    #{email},"
		+ "    #{adress}"
		+ ")"})
public int insertNewCustomer(Customer customer);

@Select({"Select "
			+ " id_customer as id, "
			+ " name_customer as name, "
			+ " lastname_customer as lastName, "
			+ " password_customer as password, "
			+ " repeatpassword_customer as repeatPassword, "
			+ " rut_customer as rut, "	
			+ " email_customer as email, "
			+ " adress_customer as adress, "
			+ "	is_authenticate as isAuthenticate, "
			+ " is_online as isOnline "
			+ " FROM customer"
			+ "	where id_customer = #{id}"})
public Customer getCustomerById(@Param("id") String id);

@Update({ " update customer set "
		+ " name_customer= '${customer.name}', "
		+ " lastname_customer = '${customer.lastName}', "
		+ " password_customer = '${customer.password}', "
		+ " repeatpassword_customer = '${customer.repeatPassword}', "
		+ " email_customer = '${customer.email}', "
		+ " adress_customer = '${customer.adress}', "
		+ " is_authenticate = '${customer.isAuthenticate}', "
		+ " is_online = '${customer.isOnline}' "
		+ " WHERE id_customer = '${customer.id}'"})
public void updateCustomer(@Param("customer") Customer customer);

@Select({"Select id_role from customer"
		+ " where email_customer = #{email} "
		+ " and password_customer = #{password}"})
public String getIdRole(@Param("email") String email, @Param("password") String password);



}
