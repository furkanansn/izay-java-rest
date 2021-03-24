package ariservice.izay.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ariservice.izay.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	

	@Query(value="SELECT * FROM product p WHERE \n"
			+ "p.name LIKE %:query%\n"
			+ "OR p.voltage LIKE %:query%\n"
			+ "OR p.serial_no LIKE %:query%\n"
			+ "OR p.sub_title_tr LIKE %:query%\n"
			+ "OR p.sub_title_en LIKE %:query%\n"
			+ "OR p.structure_tr LIKE %:query%\n"
			+ "OR p.structure_en LIKE %:query%\n"
			+ "OR p.technical_info_tr LIKE %:query%\n"
			+ "OR p.technical_info_en LIKE %:query%")
	
	List<Product> searchProduct(@Param("query") String query);
	
	
	
	
}


