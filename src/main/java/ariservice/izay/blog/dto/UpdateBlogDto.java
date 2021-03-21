package ariservice.izay.blog.dto;

import lombok.Data;

@Data
public class UpdateBlogDto {
	
	private Long id;
	private String nameTr;
	private String nameEn;
	private String imagePath;
	private String textTr;
	private String textEn;

}
