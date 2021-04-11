package ariservice.izay.blog.entity;

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
@Table(name = "blog")
@Entity
public class Blog extends BaseEntity implements Serializable{
	
	
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
	@Column(name = "text_tr")
	private String textTr;
	
	@Lob
	@Column(name = "text_en")
	private String textEn;
	
	@Column(name = "slug")
	private String slug;

}
