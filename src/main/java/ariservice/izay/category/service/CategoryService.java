package ariservice.izay.category.service;



import ariservice.izay.category.dto.CategoryAddDto;
import ariservice.izay.category.dto.CategoryUpdateDto;
import ariservice.izay.category.entity.Category;

public interface CategoryService {
	
	Category add(CategoryAddDto category);
	
	Boolean delete(Long id);
	
	Category update(CategoryUpdateDto category);
	
	Object getAll();
	
	Object getById(Long id);

}
