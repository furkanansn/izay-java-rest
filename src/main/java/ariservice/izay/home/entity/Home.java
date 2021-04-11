package ariservice.izay.home.entity;

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
@Table(name = "home")
@Entity

public class Home extends BaseEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@Lob
	@Column(name = "main_image")
	private String mainImage;
	

	@Lob
	@Column(name = "phone")
	private String phone;
	

	@Lob
	@Column(name = "whatsapp")
	private String whatsapp;
	
	@Lob
	@Column(name = "email")
	private String email;
	
	@Lob
	@Column(name = "facebook")
	private String facebook;
	
	@Lob
	@Column(name = "instagram")
	private String instagram;
	
	@Lob
	@Column(name = "twitter")
	private String twitter;
	
	@Lob
	@Column(name = "youtube")
	private String youtube;
	
	@Lob
	@Column(name = "linkedln")
	private String linkedln;
	
	@Lob
	@Column(name = "question_text_tr")
	private String questionTextTr;
	
	@Lob
	@Column(name = "question_sub_text_tr")
	private String questionSubTextTr;
	
	@Lob
	@Column(name = "question_text_en")
	private String questionTextEn;
	
	@Lob
	@Column(name = "question_sub_text_en")
	private String questionSubTextEn;
	
	
	@Lob
	@Column(name = "whatsapp_text_en")
	private String whatsappTextEn;
	

	@Lob
	@Column(name = "whatsapp_text_tr")
	private String whatsappTextTr;

	
	@Lob
	@Column(name = "phone_text_en")
	private String phoneTextEn;
	

	@Lob
	@Column(name = "phone_text_tr")
	private String phoneTextTr;
	
	@Lob
	@Column(name = "mail_text_en")
	private String mailTextEn;
	

	@Lob
	@Column(name = "mail_text_tr")
	private String mailTextTr;
	
	

	

}
