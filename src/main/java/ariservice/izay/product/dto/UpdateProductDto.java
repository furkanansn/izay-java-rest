package ariservice.izay.product.dto;

import java.util.List;

import lombok.Data;

@Data
public class UpdateProductDto {
	
	private Long id;
	private String name;
	private String voltage;
	private String serialNo;
	private String imageBase64;
	private String subTitleTr;
	private String subTitleEn;
	private String structureTr;
	private String technicalInfoTr;
	private String structureEn;
	private String technicalInfoEn;
	private String nominalVoltage;
	private String testVoltage;
	private String iletkenTipiTr;
	private String iletkenTipiEn;
	private String sinifiTr;
	private String sinifiEn;
	private String yalitimKaplamaTr;	
	private String yalitimKaplamaEn;
	private String kilifTr;
	private String kilifEn;
	private String damarRenkleriTr;
	private String damarRenkleriEn;
	private String kilifRenkleriTr;
	private String kilifRenkleriEn;
	private String calismaSicakligi;
	private String kisaDevreSicakligi;
	private String nerelerdeKullanilirTr;
	private String nerelerdeKullanilirEn;
	private List<IconId> icons;

		
	
}
