package ariservice.izay.category.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import ariservice.izay.product.entity.Product;
import ariservice.izay.util.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Table(name = "category")
@Getter
@Setter
@Entity

public class Category extends BaseEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "image_path")
	private String image;
	
	
	@Column(name = "name_tr")
	private String nameTr;
	
	
	@Column(name = "name_en")
	private String nameEn;
	
	
	@Column(name = "sub_title_tr")
	private String subTitleTr;
	
	
	@Column(name = "description_tr")
	private String descriptionTr;
	
	
	@Column(name = "sub_title_en")
	private String subTitleEn;
	
	
	@Column(name = "description_en")
	private String descriptionEn;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "categories")
	private Set<Product> products;
	
}
