package ariservice.izay.meetUs.entity;

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
import lombok.Data;

@SuppressWarnings("serial")
@Data
@Table(name = "meet_us")
@Entity

public class MeetUs extends BaseEntity implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	@Column(name = "trust_partner_tr")
	private String trustPartnerTr;
	
	@Lob
	@Column(name = "trust_partner_en")
	private String trustPartnerEn;
	
	@Lob
	@Column(name = "our_difference_tr")
	private String ourDifferenceTr;
	
	@Lob
	@Column(name = "our_difference_en")
	private String ourDifferenceEn;
	
	@Lob
	@Column(name = "our_service_tr")
	private String ourServiceTr;
	
	@Lob
	@Column(name = "our_service_en")
	private String ourServiceEn;
	
	@Lob
	@Column(name = "our_innovation_tr")
	private String ourInnovationTr;
	
	@Lob
	@Column(name = "our_innovation_en")
	private String ourInnovationEn;
	
	
	@Lob
	@Column(name = "image_path")
	private String imagePath;
	
	@Lob
	@Column(name = "text_tr")
	private String textTr;
	
	@Lob
	@Column(name = "text_en")
	private String textEn;

}
