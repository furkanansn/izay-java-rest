package ariservice.izay.meetUs.dto;

import lombok.Data;

@Data
public class MeetUsDto {
	private Long id;
	private String trustPartnerTr;
	private String trustPartnerEn;
	private String ourDifferenceTr;
	private String ourDifferenceEn;
	private String ourServiceTr;
	private String ourServiceEn;
	private String ourInnovationTr;
	private String ourInnovationEn;
	private String imageBase64;
	private String textTr;
	private String textEn;

}
