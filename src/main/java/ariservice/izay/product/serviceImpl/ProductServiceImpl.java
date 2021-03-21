package ariservice.izay.product.serviceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import ariservice.izay.category.entity.Category;
import ariservice.izay.category.repository.CategoryRepository;
import ariservice.izay.product.dto.AddProductCategory;
import ariservice.izay.product.dto.AddProductDto;
import ariservice.izay.product.dto.UpdateProductDto;
import ariservice.izay.product.entity.Product;
import ariservice.izay.product.repository.ProductRepository;
import ariservice.izay.product.service.ProductService;
import ariservice.izay.util.CombineDto;

@Service
public class ProductServiceImpl implements ProductService{
	
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	private final ModelMapper modelMapper;

	
	public ProductServiceImpl(ProductRepository productRepository,CategoryRepository categoryRepository,ModelMapper modelMapper) {
		super();
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
		this.modelMapper = modelMapper;

	}

	@Override
	public Product add(AddProductDto addProductDto) {
		
		Product product = modelMapper.map(addProductDto, Product.class);
		

		
		return productRepository.save(product);
		
	}

	@Override
	public Boolean delete(Long id) {
	
		Optional<Product> product = productRepository.findById(id);
		
		if(product.isPresent()) {
			
			productRepository.delete(product.get());
			
			return true;
		}
		
		return false;
	}

	@Override
	public Product update(UpdateProductDto updateProductDto) {
		
		Product product = productRepository.findById(updateProductDto.getId()).get();
		
		product = modelMapper.map(updateProductDto, Product.class);
		
		return productRepository.save(product);
	}

	@Override
	public Object getAll() {

		return productRepository.findAll();
	
	}

	@Override
	public Object getById(Long id) {
	
		return productRepository.findById(id).get();
	
	}

	@Override
	public Object addProductCategory(AddProductCategory addProductCategory) {
		
		Product product = productRepository.findById(addProductCategory.getProductId()).get();
		
	
		for(int i = 0 ; i < addProductCategory.getCategoryIdList().size() ; i++) {
			
			Category category = new Category();
			
			category = categoryRepository.findById(addProductCategory.getCategoryIdList().get(i).getId()).get();
			
			product.getCategories().add(category);
			
		}
		
		
		
		productRepository.save(product);
		
		
		CombineDto combineDto = modelMapper.map(product, CombineDto.class);
				
		
		return combineDto;
	}

}
