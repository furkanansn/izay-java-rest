package ariservice.izay.product.dto;

import lombok.Data;

@Data
public class UpdateProductDto {
	
	private Long id;
	private String name;
	private String voltage;
	private String serialNo;
	private String imagePath;
	private String subTitleTr;
	private String subTitleEn;
	private String structureTr;
	private String technicalInfoTr;
	private String structureEn;
	private String technicalInfoEn;
		
	
}
