package ariservice.izay.auth.controller;


import java.security.NoSuchAlgorithmException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ariservice.izay.auth.dto.AuthDto;
import ariservice.izay.auth.dto.LoginDto;
import ariservice.izay.security.JwtHelper;
import ariservice.izay.util.ApiPaths;
import ariservice.izay.util.GeneralResponse;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping(ApiPaths.AuthCtrl.CTRL)

public class AuthController {
	
	@PostMapping()
	ResponseEntity<GeneralResponse> login(@RequestBody LoginDto loginDto){
		
		AuthDto authDto = new AuthDto();

		try {
			
			if(loginDto.getUsername().equals("test") && loginDto.getPassword().equals("test")) {
				
				
				JwtHelper jwtHelper = new JwtHelper();
				
				authDto.setAccessToken(jwtHelper.buildJwt());
				
				return ResponseEntity.ok(new GeneralResponse(true,authDto,""));	
					
				}
				
				
				return ResponseEntity.ok(new GeneralResponse(false,null,"Yetkisiz Erişim"));
			
		} catch (Exception e) {
			

			String errorString = "AuthController on login "  +  e.getMessage();
			return ResponseEntity.ok(new GeneralResponse(false,null,errorString));
			
		}
		
	}
	
	
	@GetMapping("/checkJwt")
	ResponseEntity<Boolean> checkJwt(@RequestParam String jwt) throws NoSuchAlgorithmException{
		
		try {
			JwtHelper jwtHelper = new JwtHelper();
			String aString = jwtHelper.verifyJwt(jwt);
			

			if(aString ==null) {
				return ResponseEntity.ok(false);
	
			}
			return ResponseEntity.ok(true);
			
		} catch (Exception e) {
			
			return ResponseEntity.ok(false);
		}
		
	}

	

}
