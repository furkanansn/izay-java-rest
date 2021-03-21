package ariservice.izay.product.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ariservice.izay.product.dto.AddProductCategory;
import ariservice.izay.product.dto.AddProductDto;
import ariservice.izay.product.dto.UpdateProductDto;
import ariservice.izay.product.serviceImpl.ProductServiceImpl;
import ariservice.izay.security.JwtHelper;
import ariservice.izay.util.ApiPaths;
import ariservice.izay.util.GeneralResponse;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping(ApiPaths.ProdcutCtrl.CTRL)

public class ProductController {
	
	private final ProductServiceImpl impl;
	JwtHelper jwtHelper;

	public ProductController(ProductServiceImpl productServiceImpl) {
		super();
		this.impl = productServiceImpl;
		jwtHelper  = new JwtHelper();

	}
	
	@GetMapping()
	ResponseEntity<GeneralResponse> getAllProducts(){
		try {
			return ResponseEntity.ok(new GeneralResponse(true,impl.getAll(),""));

		} catch (Exception e) {
			
			String errorString = "ProductController on getAllProducts "  +  e.getMessage();
			return ResponseEntity.ok(new GeneralResponse(false,null,errorString));

		}
		
	}
	
	
	@PostMapping("/add")
	ResponseEntity<GeneralResponse> addProduct(@RequestHeader(value = "Authorization", required = false)String token,@RequestBody AddProductDto aDto){
		
		try {
			String aString = jwtHelper.verifyJwt(token);

			return ResponseEntity.ok(new GeneralResponse(true,impl.add(aDto),""));
			
		} catch (Exception e) {
			
			String errorString = "ProductController on addProduct "  +  e.getMessage();
			return ResponseEntity.ok(new GeneralResponse(false,null,errorString));
			
		}
		
		
	
	}
	
	@PostMapping("/addProductCategory")
	ResponseEntity<GeneralResponse> addProductAndCategory(@RequestHeader(value = "Authorization", required = false)String token,@RequestBody AddProductCategory aDto){
		
		try {
			String aString = jwtHelper.verifyJwt(token);

			return ResponseEntity.ok(new GeneralResponse(true,impl.addProductCategory(aDto),""));
			
		} catch (Exception e) {
			
			String errorString = "ProductController on addProduct "  +  e.getMessage();
			return ResponseEntity.ok(new GeneralResponse(false,null,errorString));
			
		}
		
		
	
	}
	
	@PostMapping("/update")
	ResponseEntity<GeneralResponse> updateProduct(@RequestHeader(value = "Authorization", required = false)String token,@RequestBody UpdateProductDto updateProductDto){
		
		try {
			String aString = jwtHelper.verifyJwt(token);

			return ResponseEntity.ok(new GeneralResponse(true,impl.update(updateProductDto),""));
			
		} catch (Exception e) {
			
			String errorString = "ProductController on updateProduct "  +  e.getMessage();
			return ResponseEntity.ok(new GeneralResponse(false,null,errorString));
			
		}
		
	
	}
	
	@GetMapping("/delete")
	ResponseEntity<GeneralResponse> deleteProduct(@RequestHeader(value = "Authorization", required = false)String token,@RequestParam Long id){
		try {
			String aString = jwtHelper.verifyJwt(token);

			Boolean okBoolean = impl.delete(id);
			
			if(!okBoolean) {
				return ResponseEntity.ok(new GeneralResponse(false,null,"Böyle bir ürün bulunamadı"));
			}
			
			
			return ResponseEntity.ok(new GeneralResponse(true,true,""));
			
		} catch (Exception e) {
			
			String errorString = "ProductController on deleteProduct "  +  e.getMessage();
			return ResponseEntity.ok(new GeneralResponse(false,null,errorString));
			
		}
	
	
	}
	
	@GetMapping("/get")
	ResponseEntity<GeneralResponse> getProduct(@RequestParam Long id){
		try {
			
			Object okObject = impl.getById(id);
			
			if(okObject == null) {
				return ResponseEntity.ok(new GeneralResponse(false,null,"Böyle bir ürün bulunamadı"));
			}
			
			
			return ResponseEntity.ok(new GeneralResponse(true,okObject,""));
			
		} catch (Exception e) {
			
			String errorString = "ProductController on getProduct "  +  e.getMessage();
			return ResponseEntity.ok(new GeneralResponse(false,null,errorString));
			
		}
		
	}
	
}
