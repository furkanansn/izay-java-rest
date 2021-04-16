package ariservice.izay.product.serviceImpl;



import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ariservice.izay.category.entity.Category;
import ariservice.izay.category.repository.CategoryRepository;
import ariservice.izay.io.IoUtil;
import ariservice.izay.product.dto.AddIconDto;
import ariservice.izay.product.dto.AddProductCategory;
import ariservice.izay.product.dto.AddProductDto;
import ariservice.izay.product.dto.IconId;
import ariservice.izay.product.dto.UpdateProductDto;
import ariservice.izay.product.entity.Icons;
import ariservice.izay.product.entity.Product;
import ariservice.izay.product.repository.IconRepository;
import ariservice.izay.product.repository.ProductRepository;
import ariservice.izay.product.service.ProductService;
import ariservice.izay.util.CombineDto;
import ariservice.izay.util.SlugUtil;

@Service
public class ProductServiceImpl implements ProductService{
	
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	private final IconRepository iconRepository;
	private final ModelMapper modelMapper;

	
	public ProductServiceImpl(ProductRepository productRepository,CategoryRepository categoryRepository,ModelMapper modelMapper,IconRepository iconRepository) {
		super();
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
		this.modelMapper = modelMapper;
		this.iconRepository = iconRepository;

	}

	@Override
	public Product add(AddProductDto addProductDto) throws IOException {
		
		Product product = new Product();
		product = modelMapper.map(addProductDto, Product.class);
		
		
		String imagePathString = IoUtil.decoder(addProductDto.getImageBase64());

		product.setImagePath(imagePathString);
		
		product.setSlug(SlugUtil.toSlug(product.getName()));
		
		
		
		List<IconId> iconIds = addProductDto.getIcons();
		Set<Icons> iconsList = new HashSet<Icons>();
		for (IconId iconId : iconIds) {
			
			Icons icons = iconRepository.findById(iconId.getId()).get();
			iconsList.add(icons);
		}
		product.setIconsOfProduct(iconsList);
			
		return productRepository.save(product);
		
	}

	@Override
	public Boolean delete(Long id) {
	
		Optional<Product> product = productRepository.findById(id);
		
		if(product.isPresent()) {
			
			IoUtil.deleteFile(product.get().getImagePath());
			
			productRepository.delete(product.get());
			
			return true;
		}
		
		return false;
	}

	@Override
	public Product update(UpdateProductDto updateProductDto) throws IOException {
		
		Product product = productRepository.findById(updateProductDto.getId()).get();
		
		String pathString = product.getImagePath();
		
		product = modelMapper.map(updateProductDto, Product.class);
		
		if(!updateProductDto.getImageBase64().isEmpty()) {
		
			String imageString = IoUtil.updateDecoder(updateProductDto.getImageBase64(), product.getImagePath());
			
			product.setImagePath(imageString);
			
		}else {
			product.setImagePath(pathString);
		}
		
		product.setSlug(SlugUtil.toSlug(product.getName()));
		
		
		List<IconId> iconIds = updateProductDto.getIcons();
		
		Set<Icons> iconsList = new HashSet<Icons>();
		for (IconId iconId : iconIds) {
			
			Icons icons = iconRepository.findById(iconId.getId()).get();
			iconsList.add(icons);
		}
		product.setIconsOfProduct(iconsList);

		
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

	@Override
	public Object searchProduct(String query) {
		
		Optional<List<Product>> products = Optional.ofNullable(productRepository.searchProduct(query));
		
		if(products.isPresent()) {
			return products;
		}
		
		return null;
	}

	@Override
	public Object getBySlug(String slug) {
		
		Optional<List<Product>> productsOptional = Optional.ofNullable(productRepository.findBySlug(slug));
		if(productsOptional.isPresent()) {
			return productsOptional;
		}
		
		return null;
	}
	
	public Object addIcon(AddIconDto icons) throws IOException {
		
		String svgPathString = IoUtil.decoder(icons.getSvg());
		
		Icons iconEntity = new Icons();
		iconEntity.setImagePath(svgPathString);
		iconEntity.setName(icons.getName());
		iconRepository.save(iconEntity);	
		return iconEntity;
	}
	
	public Object deleteIcon(Long id) {
		
		Optional<Icons> icons = iconRepository.findById(id);
		if(icons.isPresent()) {
			
			Icons resIcons = icons.get();
			
			Set<Product> products = resIcons.getProducts();
			products.forEach(prod ->
			prod.getIconsOfProduct()
			        .removeIf(r -> r.getId() == resIcons.getId()));
			products.clear();
			
			iconRepository.delete(resIcons);
		}
		return "Ok";
		
	}
	
	public Object getIcons() {
		return iconRepository.findAll();
	}
	
	

}
