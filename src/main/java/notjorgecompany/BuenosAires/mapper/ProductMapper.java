	package notjorgecompany.BuenosAires.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
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
		+ " is_available as isAvailable , "
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
		+ " where id = #{id} "})	
public Product getProductById(@Param("id") String id);


@Insert({"INSERT INTO product ("
		+ "    name,"
		+ "    value,"
		+ "    mark,"
		+ "    is_available,"
		+ "    image_01,"
		+ "    is_ofert,"
		+ "    model,"
		+ "    category,"
		+ "    description"
		+ ") VALUES ("
		+ "    #{name},"
		+ "    #{value},"
		+ "    #{mark},"
		+ "    #{isAvailable},"
		+ "    #{image},"
		+ "    #{isOfert},"
		+ "    #{model},"
		+ "    #{category},"
		+ "    #{description}"
		+ ")"})
public int addNewProduct(Product product); 

}
