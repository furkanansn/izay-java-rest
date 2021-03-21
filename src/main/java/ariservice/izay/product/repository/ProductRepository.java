package ariservice.izay.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ariservice.izay.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	

}


