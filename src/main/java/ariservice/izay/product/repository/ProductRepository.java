package ariservice.izay.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ariservice.izay.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	

	@Query(value="select * from product p where \n"
			+ "p.name LIKE %:query%\n"
			+ "OR p.voltage LIKE %:query%\n"
			+ "OR p.serial_no LIKE %:query%\n"
			+ "OR p.sub_title_tr LIKE %:query%\n"
			+ "OR p.sub_title_en LIKE %:query%\n"
			+ "OR p.technical_info_tr LIKE %:query%\n"
			+ "OR p.technical_info_en LIKE %:query%",nativeQuery = true)
	
	List<Product> searchProduct(@Param("query") String query);
	
	List<Product> findBySlug(String slug);
	
	
	
	
}


