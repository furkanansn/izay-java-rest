package ariservice.izay.product.service;

import ariservice.izay.product.dto.AddProductCategory;
import ariservice.izay.product.dto.AddProductDto;
import ariservice.izay.product.dto.UpdateProductDto;
import ariservice.izay.product.entity.Product;

public interface ProductService {
	
	Product add(AddProductDto addProductDto);
	
	Boolean delete(Long id);
	
	Product update(UpdateProductDto updateProductDto);
	
	Object getAll();
	
	Object getById(Long id);
	
	Object addProductCategory(AddProductCategory addProductCategory);
	
	Object searchProduct(String query);
	
}
