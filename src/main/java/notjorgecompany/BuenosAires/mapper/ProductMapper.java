package notjorgecompany.BuenosAires.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

@Select({" SELECT "
		+ " id as id,"
		+ "        name as name,"
		+ "        value as value,"
		+ "        mark as mark,"
		+ "        is_available as isAvailable,"
		+ "        is_ofert as isOfert,"
		+ "        model as model,"
		+ "        category as category,"
		+ "        description as description "
		+ " from product "
		+ " where id = 10 "})	
public Product getProductById(); 

@Select({" SELECT "
		+ " id  as id , "
		+ " name as name, "
		+ " value  as value, "
		+ " description  as description, "
		+ " is_available as isAvailiable , "
		+ " is_ofert as isOfert , "
		+ " category as category"
		+ " from product "
		+ " where id = #{id} "})	
public Product getProductById1(@Param("id") String id); 

}
