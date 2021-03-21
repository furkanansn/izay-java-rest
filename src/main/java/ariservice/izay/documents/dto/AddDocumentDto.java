package ariservice.izay.documents.dto;

import lombok.Data;

@Data
public class AddDocumentDto {
	
	private String nameTr;
	private String nameEn;
	private String imagePath;
	private String pdfPath;

}
