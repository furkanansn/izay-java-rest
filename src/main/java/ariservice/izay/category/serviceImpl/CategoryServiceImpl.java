package ariservice.izay.category.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ariservice.izay.category.dto.CategoryAddDto;
import ariservice.izay.category.dto.CategoryUpdateDto;
import ariservice.izay.category.entity.Category;
import ariservice.izay.category.repository.CategoryRepository;
import ariservice.izay.category.service.CategoryService;

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
	public Category add(CategoryAddDto category) {
		
		Category category2 = modelMapper.map(category, Category.class);
		
		
		Category resCategory = categoryRepository.save(category2);
		
		return resCategory;
	}

	@Override
	public Boolean delete(Long id) {
			
		Optional<Category> category = categoryRepository.findById(id);
		
		if(category.isPresent()) {
			
			categoryRepository.delete(category.get());
			
			return true;
			
		}
		
			return false;
			
	}

	@Override
	public Category update(CategoryUpdateDto category) {
		
		
		Category category2 = categoryRepository.getOne(category.getId());
		

		category2.setDescriptionEn(category.getDescriptionEn());
		category2.setDescriptionTr(category.getDescriptionTr());
		category2.setImage(category.getImagePath());
		category2.setNameEn(category.getNameEn());
		category2.setNameTr(category.getNameTr());
		category2.setSubTitleEn(category.getSubTitleEn());
		category2.setSubTitleTr(category.getSubTitleTr());
		
		
		Category resCategory = categoryRepository.save(category2);
		
		return resCategory;
	}

	@Override
	public Object getAll() {
		
		
		List<Category> category = categoryRepository.findAll();
		
		/*
		 * List<CategoryDto> categoryDto = new ArrayList();
		 * 
		 * for (Category category2 : category) {
		 * 
		 * CategoryDto cDto = new CategoryDto();
		 * 
		 * cDto.setDescriptionEn(category2.getDescriptionEn());
		 * cDto.setDescriptionTr(category2.getDescriptionTr());
		 * cDto.setImagePath(category2.getImagePath());
		 * cDto.setNameEn(category2.getNameEn()); cDto.setNameTr(category2.getNameTr());
		 * cDto.setSubTitleEn(category2.getSubTitleEn());
		 * cDto.setSubTitleTr(category2.getSubTitleTr());
		 * cDto.setProducs(category2.getProducts());
		 * 
		 * categoryDto.add(cDto); }
		 */
		
		 //Arrays.asList(modelMapper.map(category, CategoryDto[].class));
		
		return category;
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
