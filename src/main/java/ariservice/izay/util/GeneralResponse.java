package ariservice.izay.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneralResponse {
	
	private boolean success;
	private Object data;
	private String errorMessage;
	
	
	
	
	
}
