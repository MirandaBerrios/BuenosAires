package notjorgecompany.BuenosAires.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import notjorgecompany.BuenosAires.odt.Product;

@Mapper
public interface ProductMapper {

			
@Select({" SELECT "
		+ " id  as id , "
		+ " name as name, "
		+ " value  as value, "
		+ " description  as description, "
		+ " is_available as isAvailiable , "
		+ " is_ofert as isOfert , "
		+ " category as category"
		+ " from product"})	
public List<Product> getAllProduct(); 

@Select({" SELECT name from product "})
public String getNombre();



}
