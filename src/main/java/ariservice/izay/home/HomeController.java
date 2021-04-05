package ariservice.izay.home;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ariservice.izay.category.entity.Category;
import ariservice.izay.category.repository.CategoryRepository;
import ariservice.izay.home.entity.Home;
import ariservice.izay.home.repository.HomeRepository;
import ariservice.izay.io.IoUtil;
import ariservice.izay.security.JwtHelper;
import ariservice.izay.util.ApiPaths;
import ariservice.izay.util.GeneralResponse;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping(ApiPaths.HomeCtrl.CTRL)

public class HomeController {
	
	private final HomeRepository repo;
	private final ModelMapper modelMapper;
	JwtHelper jwtHelper;
	private final HomeService homeService;
	
	public HomeController(HomeRepository repo, ModelMapper modelMapper,HomeService homeService) {
		super();
		this.repo = repo;
		this.modelMapper = modelMapper;
		jwtHelper  = new JwtHelper();
		this.homeService = homeService;
	}
	
	
	
	@PostMapping("/add")
	ResponseEntity<GeneralResponse> addHome(@RequestHeader(value = "Authorization", required = false)String token,@RequestBody Home home){
		
		try {
			String aString = jwtHelper.verifyJwt(token);
			
			String imagePathString = IoUtil.decoder(home.getMainImage());
			
			home.setMainImage(imagePathString);
			
			
			
			return ResponseEntity.ok(new GeneralResponse(true,repo.save(home),""));
			
		} catch (Exception e) {
			
			String errorString = "HomeController on addHome "  +  e.getMessage();
			return ResponseEntity.ok(new GeneralResponse(false,null,errorString));
		}
		

	}
	
	
	@PostMapping("/update")
	ResponseEntity<GeneralResponse> updateHome(@RequestHeader(value = "Authorization", required = false)String token,@RequestBody Home dto){
		
		try {
			String aString = jwtHelper.verifyJwt(token);

			if(dto.getMainImage() != null || dto.getMainImage().length() > 1) {
				
				String imagePathString = IoUtil.decoder(dto.getMainImage());
				
				dto.setMainImage(imagePathString);	
			}
			
			
				return ResponseEntity.ok(new GeneralResponse(true,repo.save(dto),""));

		
			
		} catch (Exception e) {
			
			String errorString = "HomeController on updateHome "  +  e.getMessage();
			return ResponseEntity.ok(new GeneralResponse(false,null,errorString));
		}
		

	}
	
	@GetMapping("/delete")
	ResponseEntity<GeneralResponse> deleteHome(@RequestHeader(value = "Authorization", required = false)String token,@RequestParam Long id){
		
		try {
			String aString = jwtHelper.verifyJwt(token);

			Optional<Home> Homeument = repo.findById(id);
			if(Homeument.isPresent()) {
				Home Homeument2 = Homeument.get();
				
				IoUtil.deleteFile(Homeument2.getMainImage());
				
				repo.delete(Homeument2);
				return ResponseEntity.ok(new GeneralResponse(true,null,""));

			}else {
				return ResponseEntity.ok(new GeneralResponse(false,null,"Böyle bir döküman bulunamadı"));

			}
			
		} catch (Exception e) {
			
			String errorString = "HomeController on deleteHome "  +  e.getMessage();
			return ResponseEntity.ok(new GeneralResponse(false,null,errorString));
		}
		

	}
	
	@GetMapping("/get")
	ResponseEntity<GeneralResponse> getHome(){
		
		try {
			
				return ResponseEntity.ok(new GeneralResponse(true,repo.findAll(),""));
			
			
		} catch (Exception e) {
			
			String errorString = "HomeController on getHome "  +  e.getMessage();
			return ResponseEntity.ok(new GeneralResponse(false,null,errorString));
		}
		

	}
	
	
	@GetMapping()
	ResponseEntity<GeneralResponse> home(){
		
		try {
	
		return ResponseEntity.ok(new GeneralResponse(true,homeService.getAllItemsForHome(),""));
			
			
		} catch (Exception e) {
			
			String errorString = "HomeController on getHome "  +  e.getMessage();
			return ResponseEntity.ok(new GeneralResponse(false,null,errorString));
		}
		

	}

}
