package ariservice.izay.blog.serviceImpl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import ariservice.izay.blog.repository.BlogRepository;
import ariservice.izay.util.GeneralService;
import ariservice.izay.blog.dto.UpdateBlogDto;
import ariservice.izay.blog.entity.Blog;

@Service
public class BlogServiceImpl implements GeneralService{

	private final BlogRepository repo;
	private final ModelMapper modelMapper;
	
	
	public BlogServiceImpl(BlogRepository repo, ModelMapper modelMapper) {
		super();
		this.repo = repo;
		this.modelMapper = modelMapper;
	}


	@Override
	public Object add(Object object) {
		
		Blog blog = modelMapper.map(object, Blog.class);
		
		return repo.save(blog);
	}

	@Override
	public Boolean delete(Long id) {
		
		Optional<Blog> blog = repo.findById(id);
		
		if (blog.isPresent()) {
			repo.delete(blog.get());
			return true;
		}
		
		return false;
	}

	@Override
	public Object update(Object object) {
		
		
		Optional<Blog> blog = repo.findById(((UpdateBlogDto) object).getId());
		
		if (blog.isPresent()) {
			Blog blog2 = blog.get();
			blog2 = modelMapper.map(object, Blog.class);
			
			
			return repo.save(blog2);
		}
		
		return null;
	}

	@Override
	public Object getAll() {

		return repo.findAll();

	}
	

	@Override
	public Object getById(Long id) {
		
		return repo.findById(id);
		
	}

}
