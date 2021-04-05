package ariservice.izay.documents.dto;

import lombok.Data;

@Data
public class UpdateDocumentDto {
	
	private Long id;
	private String nameTr;
	private String nameEn;
	private String imagePath;
	private String pdfBase64;

}
