package ariservice.izay.product.dto;

import java.util.List;

import lombok.Data;

@Data
public class AddProductCategory {

	private Long productId;
	
	private List<CategoryIdDto> categoryIdList;
	
}
