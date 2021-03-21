package ariservice.izay.util;

import java.util.Set;

import ariservice.izay.category.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CombineDto {
	
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
	private Set<Category> categories;
	

}
