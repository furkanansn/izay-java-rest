package ariservice.izay.category.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ariservice.izay.category.dto.CategoryAddDto;
import ariservice.izay.category.dto.CategoryDto;
import ariservice.izay.category.dto.CategoryUpdateDto;
import ariservice.izay.category.entity.Category;
import ariservice.izay.category.serviceImpl.CategoryServiceImpl;
import ariservice.izay.security.JwtHelper;
import ariservice.izay.util.ApiPaths;
import ariservice.izay.util.GeneralResponse;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping(ApiPaths.CategoryCtrl.CTRL)

public class CategoryController {
	
	JwtHelper jwtHelper;
	private final CategoryServiceImpl impl;
	
	public CategoryController(CategoryServiceImpl categoryServiceImpl) {
		jwtHelper = new JwtHelper();
		this.impl = categoryServiceImpl;
	}
	
	
	@GetMapping()
	ResponseEntity<GeneralResponse> getAllCategories(){
		try {
			return ResponseEntity.ok(new GeneralResponse(true,impl.getAll(),""));

		} catch (Exception e) {
			
			String errorString = "CategoryController on getAllCategories "  +  e.getMessage();
			return ResponseEntity.ok(new GeneralResponse(false,null,errorString));

		}
		
	}
	
	
	@PostMapping("/add")
	ResponseEntity<GeneralResponse> addCategory(@RequestHeader(value = "Authorization", required = false)String token,@RequestBody CategoryAddDto category){
		
		try {
			String aString = jwtHelper.verifyJwt(token);
			return ResponseEntity.ok(new GeneralResponse(true,impl.add(category),""));
			
		} catch (Exception e) {
			
			String errorString = "CategoryController on addCategory "  +  e.getMessage();
			return ResponseEntity.ok(new GeneralResponse(false,null,errorString));
			
		}
		
		
	
	}
	
	@PostMapping("/update")
	ResponseEntity<GeneralResponse> updateCategory(@RequestHeader(value = "Authorization", required = false)String token,@RequestBody CategoryUpdateDto category){
		
		try {
			String aString = jwtHelper.verifyJwt(token);
			return ResponseEntity.ok(new GeneralResponse(true,impl.update(category),""));
			
		} catch (Exception e) {
			
			String errorString = "CategoryController on updateCategory "  +  e.getMessage();
			return ResponseEntity.ok(new GeneralResponse(false,null,errorString));
			
		}
		
	
	}
	
	@GetMapping("/delete")
	ResponseEntity<GeneralResponse> deleteCategory(@RequestHeader(value = "Authorization", required = false)String token,@RequestParam Long id){
		try {
			String aString = jwtHelper.verifyJwt(token);
			Boolean okBoolean = impl.delete(id);
			
			if(!okBoolean) {
				return ResponseEntity.ok(new GeneralResponse(false,null,"Böyle bir kategori bulunamadı"));
			}
			
			
			return ResponseEntity.ok(new GeneralResponse(true,true,""));
			
		} catch (Exception e) {
			
			String errorString = "CategoryController on deleteCategory "  +  e.getMessage();
			return ResponseEntity.ok(new GeneralResponse(false,null,errorString));
			
		}
	
	
	}
	
	@GetMapping("/get")
	ResponseEntity<GeneralResponse> getCategory(@RequestParam Long id){
		try {
			
			Object okObject = impl.getById(id);
			
			if(okObject == null) {
				return ResponseEntity.ok(new GeneralResponse(false,null,"Böyle bir kategori bulunamadı"));
			}
			
			
			return ResponseEntity.ok(new GeneralResponse(true,okObject,""));
			
		} catch (Exception e) {
			
			String errorString = "CategoryController on getCategory "  +  e.getMessage();
			return ResponseEntity.ok(new GeneralResponse(false,null,errorString));
			
		}
		
	}

}
