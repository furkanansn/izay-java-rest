package ariservice.izay.documents.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import ariservice.izay.util.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Table(name = "document")
@Entity

public class Document extends BaseEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	@Column(name = "name_tr")
	private String nameTr;
	
	@Lob
	@Column(name = "name_en")
	private String nameEn;
	
	@Lob
	@Column(name = "image_path")
	private String imagePath;
	

	@Lob
	@Column(name = "pdf_path")
	private String pdfPath;
	
	@Column(name = "slug")
	private String slug;
	

}
