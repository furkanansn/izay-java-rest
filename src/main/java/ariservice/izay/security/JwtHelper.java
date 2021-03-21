package ariservice.izay.security;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.json.JSONArray;
import org.json.JSONObject;

public class JwtHelper {
	
	private static final int EXPIRY_DAYS = 36500;
	
	public String buildJwt() {
		
		JSONObject jwtPayload = new JSONObject();
		jwtPayload.put("status", 0);

		JSONArray audArray = new JSONArray();
		audArray.put("admin"); 
		jwtPayload.put("sub", "anşin");

		jwtPayload.put("aud", audArray);
		LocalDateTime ldt = LocalDateTime.now().plusDays(EXPIRY_DAYS);
		jwtPayload.put("exp", ldt.toEpochSecond(ZoneOffset.UTC)); //this needs to be configured
		        
		String token = new SecurityJwt(jwtPayload).toString();
		
		return token;
		
	}
	
	public String verifyJwt(String bearerToken) throws NoSuchAlgorithmException {
		
		String tokenString = bearerToken.substring(bearerToken.lastIndexOf(" ") + 1);
		
		SecurityJwt incomingToken = new SecurityJwt(tokenString);
		if (!incomingToken.isValid()) {
		    
		    return null;
		    
		}
		
		return incomingToken.getAudience().get(0) + " " + incomingToken.getSubject();
		
	}

}
