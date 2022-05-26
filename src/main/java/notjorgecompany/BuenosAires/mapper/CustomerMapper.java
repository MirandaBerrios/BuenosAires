package notjorgecompany.BuenosAires.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

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
public int insertNewCustomer(Customer customer);}
