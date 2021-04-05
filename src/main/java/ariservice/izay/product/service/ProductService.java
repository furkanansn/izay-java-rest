package ariservice.izay.product.service;

import java.io.IOException;

import ariservice.izay.product.dto.AddProductCategory;
import ariservice.izay.product.dto.AddProductDto;
import ariservice.izay.product.dto.UpdateProductDto;
import ariservice.izay.product.entity.Product;

public interface ProductService {
	
	Product add(AddProductDto addProductDto) throws IOException;
	
	Boolean delete(Long id);
	
	Product update(UpdateProductDto updateProductDto) throws IOException;
	
	Object getAll();
	
	Object getById(Long id);
	
	Object addProductCategory(AddProductCategory addProductCategory);
	
	Object searchProduct(String query);
	
}
