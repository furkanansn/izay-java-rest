package ariservice.izay.home;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import ariservice.izay.blog.repository.BlogRepository;
import ariservice.izay.category.entity.Category;
import ariservice.izay.category.repository.CategoryRepository;
import ariservice.izay.documents.repository.DocumentRepository;
import ariservice.izay.home.dto.CategoryDto;
import ariservice.izay.home.repository.HomeRepository;
import ariservice.izay.meetUs.repository.MeetUsRepository;

@Service
public class HomeService {

	private final CategoryRepository categoryRepository;
	private final HomeRepository homeRepository;
	private final DocumentRepository documentRepository;
	private final BlogRepository blogRepository;
	private final MeetUsRepository meetUsRepository;
	private final ModelMapper modelMapper;
	
	public HomeService(ModelMapper modelMapper,CategoryRepository categoryRepository, HomeRepository homeRepository,
			DocumentRepository documentRepository, BlogRepository blogRepository, MeetUsRepository meetUsRepository) {
		super();
		this.categoryRepository = categoryRepository;
		this.homeRepository = homeRepository;
		this.documentRepository = documentRepository;
		this.blogRepository = blogRepository;
		this.meetUsRepository = meetUsRepository;
		this.modelMapper = modelMapper;
	}
	
	
	public Object getAllItemsForHome() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Category> category = categoryRepository.findAll();
		
		List<CategoryDto> categoryDto = Arrays.asList(modelMapper.map(category, CategoryDto[].class));
		
		Object about = "null";
		try {
			about =  (homeRepository.findById((long) 1).get() == null) ? "null" : homeRepository.findById((long) 1).get();
		} catch (Exception e) {
			about = "null";
		}
		Object contact = "null";
		try {
			about = (meetUsRepository.findById((long) 1).get() == null) ? "null" : meetUsRepository.findById((long) 1).get();	
		} catch (Exception e) {
			about = "null";
		}
		

		map.put("category", categoryDto);
		map.put("about", about);
		map.put("document", documentRepository.findAll());
		map.put("blog", blogRepository.findAll());
		map.put("contact", contact);
		
		
		return map;
	}
	
	
	
}
