package ariservice.izay.category.dto;

import java.util.List;
import java.util.Set;

import ariservice.izay.product.entity.Product;
import lombok.Data;

@Data
public class CategoryDto {
	
	private String imagePath;
	private String nameTr;
	private String nameEn;
	private String subTitleTr;
	private String descriptionTr;
	private String subTitleEn;
	private String descriptionEn;
	//Set<Product> products;

}
