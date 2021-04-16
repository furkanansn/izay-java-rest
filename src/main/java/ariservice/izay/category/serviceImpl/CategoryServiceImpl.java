package ariservice.izay.category.serviceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ariservice.izay.category.dto.CategoryAddDto;
import ariservice.izay.category.dto.CategoryUpdateDto;
import ariservice.izay.category.entity.Category;
import ariservice.izay.category.repository.CategoryRepository;
import ariservice.izay.category.service.CategoryService;
import ariservice.izay.io.IoUtil;
import ariservice.izay.product.entity.Product;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	private final CategoryRepository categoryRepository;
	private final ModelMapper modelMapper;

	public CategoryServiceImpl(CategoryRepository categoryRepository,ModelMapper modelMapper) {
		super();
		this.categoryRepository = categoryRepository;
		this.modelMapper = modelMapper;
	}

	
	
	@Override
	public Category add(CategoryAddDto category) throws IOException {
		
		Category category2 = modelMapper.map(category, Category.class);
		
		String imagePath = IoUtil.decoder(category.getImageBase64());
		
		category2.setImage(imagePath);
		
		Category resCategory = categoryRepository.save(category2);
		
		return resCategory;
	}

	@Override
	public Boolean delete(Long id) {
			
		Optional<Category> category = categoryRepository.findById(id);
		
		if(category.isPresent()) {
			
			Category resCategory = category.get();
			
			IoUtil.deleteFile(category.get().getImage());
			
			
			Set<Product> products = resCategory.getProducts();
			
			products.forEach(prod ->
				
			prod.getCategories().removeIf(c -> c.getId() == resCategory.getId()));
			
			products.clear();
			
			
			categoryRepository.delete(resCategory);
			
			return true;
			
		}
		
			return false;
			
	}

	@Override
	public Category update(CategoryUpdateDto category) throws IOException {
		
		
		Category category2 = categoryRepository.getOne(category.getId());
		

		if(!category.getImageBase64().isEmpty()) {
			
		String imagePath = IoUtil.updateDecoder(category.getImageBase64(), category2.getImage());
		
		category2.setImage(imagePath);

		}
		
		category2.setDescriptionEn(category.getDescriptionEn());
		category2.setDescriptionTr(category.getDescriptionTr());
		category2.setNameEn(category.getNameEn());
		category2.setNameTr(category.getNameTr());
		category2.setSubTitleEn(category.getSubTitleEn());
		category2.setSubTitleTr(category.getSubTitleTr());
		
		
		Category resCategory = categoryRepository.save(category2);
		
		return resCategory;
	}

	@Override
	public Object getAll() {
		
		
		return categoryRepository.findAll();
	}

	@Override
	public Object getById(Long id) {
		
		Optional<Category> cateOptional = categoryRepository.findById(id); 
			
		if(cateOptional.isPresent()) {
			
			return cateOptional.get();
			
		}
		
		return null;
	}

	

}
