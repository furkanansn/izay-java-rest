package ariservice.izay.product.entity;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import ariservice.izay.category.entity.Category;
import ariservice.izay.util.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@SuppressWarnings("serial")
@Entity
@Table(name = "product")
@Getter
@Setter
public class Product extends BaseEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "voltage")
	private String voltage;
	
	@Column(name = "serial_no")
	private String serialNo;
	
	@Column(name = "image_path")
	private String imagePath;
	
	@Column(name = "sub_title_tr")
	private String subTitleTr;
	
	@Column(name = "sub_title_en")
	private String subTitleEn;

	
	@Column(name = "technical_info_en")
	private String technicalInfoEn;
	
	@Column(name = "technical_info_tr")
	private String technicalInfoTr;
	
	@Column(name = "slug")
	private String slug;
	
	@Column(name = "nominalVoltage")
	private String nominalVoltage;
	
	@Column(name = "testVoltage")
	private String testVoltage;
	
	@Column(name = "iletkenTipiTr")
	private String iletkenTipiTr;
	
	@Column(name = "iletkenTipiEn")
	private String iletkenTipiEn;
	
	@Column(name = "sinifiTr")
	private String sinifiTr;
	
	@Column(name = "sinifiEn")
	private String sinifiEn;

	@Column(name = "yalitimKaplamaTr")
	private String yalitimKaplamaTr;
	
	@Column(name = "yalitimKaplamaEn")
	private String yalitimKaplamaEn;
	
	@Column(name = "kilifTr")
	private String kilifTr;
	
	@Column(name = "kilifEn")
	private String kilifEn;
	
	@Column(name = "damarRenkleriTr")
	private String damarRenkleriTr;
	
	@Column(name = "damarRenkleriEn")
	private String damarRenkleriEn;

	@Column(name = "kilifRenkleriTr")
	private String kilifRenkleriTr;
	
	@Column(name = "kilifRenkleriEn")
	private String kilifRenkleriEn;
	
	@Column(name = "calismaSicakligi")
	private String calismaSicakligi;
	
	@Column(name = "kisaDevreSicakligi")
	private String kisaDevreSicakligi;
	
	@Column(name = "nerelerdeKullanilirTr")
	private String nerelerdeKullanilirTr;
	
	@Column(name = "nerelerdeKullanilirEn")
	private String nerelerdeKullanilirEn;
	
	@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE},fetch = FetchType.LAZY)
	@JoinTable(name = "icon_product",joinColumns = @JoinColumn(name="product_id",referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name="icon_id",referencedColumnName = "id"))
	private Set<Icons> iconsOfProduct;
	
	@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE},fetch = FetchType.LAZY)
	@JoinTable(name = "category_product",joinColumns = @JoinColumn(name="product_id",referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name="category_id",referencedColumnName = "id"))
	private Set<Category> categories;
	
	
}
