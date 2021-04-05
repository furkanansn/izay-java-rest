package ariservice.izay.category.service;



import java.io.IOException;

import ariservice.izay.category.dto.CategoryAddDto;
import ariservice.izay.category.dto.CategoryUpdateDto;
import ariservice.izay.category.entity.Category;

public interface CategoryService {
	
	Category add(CategoryAddDto category) throws IOException;
	
	Boolean delete(Long id);
	
	Category update(CategoryUpdateDto category) throws IOException;
	
	Object getAll();
	
	Object getById(Long id);

}
