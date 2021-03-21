package ariservice.izay.category.dto;

import java.util.Set;

import ariservice.izay.product.entity.Product;
import lombok.Data;

@Data

public class AddCategoryDto {

	private String nameTr;
	private String nameEn;
	private String subTitleTr;
	private String descriptionTr;
	private String subTitleEn;
	private String descriptionEn;
	Set<Product> products;

}
