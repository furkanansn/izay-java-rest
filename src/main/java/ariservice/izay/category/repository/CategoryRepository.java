package ariservice.izay.category.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import ariservice.izay.category.entity.Category;


public interface CategoryRepository extends JpaRepository<Category, Long>{
		
	
}
