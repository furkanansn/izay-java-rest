package ariservice.izay.blog.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ariservice.izay.blog.dto.AddBlogDto;
import ariservice.izay.blog.dto.UpdateBlogDto;
import ariservice.izay.blog.serviceImpl.BlogServiceImpl;
import ariservice.izay.security.JwtHelper;
import ariservice.izay.util.ApiPaths;
import ariservice.izay.util.GeneralResponse;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping(ApiPaths.BlogCtrl.CTRL)

public class BlogController {
	
	private final BlogServiceImpl impl;
	JwtHelper jwtHelper;
	
	public BlogController(BlogServiceImpl impl) {
		super();
		this.impl = impl;
		jwtHelper  = new JwtHelper();
	}


	@GetMapping()
	ResponseEntity<Object> getAllBlog(){
		try {
			
			return ResponseEntity.ok(new GeneralResponse(true,impl.getAll(),""));

		} catch (Exception e) {
			
			String errorString = "BlogController on getAllBlog "  +  e.getMessage();
			return ResponseEntity.ok(new GeneralResponse(false,null,errorString));

		}
		
	}
	
	
	@PostMapping("/add")
	ResponseEntity<GeneralResponse> addBlog(@RequestHeader(value = "Authorization", required = false)String token,@RequestBody AddBlogDto Blog){
		
		try {

			String aString = jwtHelper.verifyJwt(token);
			
			return ResponseEntity.ok(new GeneralResponse(true,impl.add(Blog),""));
			
		} catch (Exception e) {
			
			String errorString = "BlogController on addBlog "  +  e.getMessage();
			return ResponseEntity.ok(new GeneralResponse(false,null,errorString));
			
		}
		
		
	
	}
	
	@PostMapping("/update")
	ResponseEntity<GeneralResponse> updateBlog(@RequestHeader(value = "Authorization", required = false)String token,@RequestBody UpdateBlogDto Blog){
		
		try {
			
			String aString = jwtHelper.verifyJwt(token);
			
			return ResponseEntity.ok(new GeneralResponse(true,impl.update(Blog),""));
			
		} catch (Exception e) {
			
			String errorString = "BlogController on updateBlog "  +  e.getMessage();
			return ResponseEntity.ok(new GeneralResponse(false,null,errorString));
			
		}
		
	
	}
	
	@GetMapping("/delete")
	ResponseEntity<GeneralResponse> deleteBlog(@RequestHeader(value = "Authorization", required = false)String token,@RequestParam Long id){
		try {
			
			String aString = jwtHelper.verifyJwt(token);
			
			Boolean okBoolean = impl.delete(id);
			
			if(!okBoolean) {
				return ResponseEntity.ok(new GeneralResponse(false,null,"Böyle bir Yazı bulunamadı"));
			}
			
			
			return ResponseEntity.ok(new GeneralResponse(true,true,""));
			
		} catch (Exception e) {
			
			String errorString = "BlogController on deleteBlog "  +  e.getMessage();
			return ResponseEntity.ok(new GeneralResponse(false,null,errorString));
			
		}
	
	
	}
	
	@GetMapping("/get")
	ResponseEntity<GeneralResponse> getBlog(@RequestParam Long id){
		try {
			
			Object okObject = impl.getById(id);
			
			if(okObject == null) {
				return ResponseEntity.ok(new GeneralResponse(false,null,"Böyle bir Yazı bulunamadı"));
			}
			
			
			return ResponseEntity.ok(new GeneralResponse(true,okObject,""));
			
		} catch (Exception e) {
			
			String errorString = "BlogController on getBlog "  +  e.getMessage();
			return ResponseEntity.ok(new GeneralResponse(false,null,errorString));
			
		}
		
	}
	

	@GetMapping("/getSlug")
	ResponseEntity<GeneralResponse> getBlogBySlug(@RequestParam String slug){
		try {
			
			Object okObject = impl.getBySlug(slug);
			
			if(okObject == null) {
				return ResponseEntity.ok(new GeneralResponse(false,null,"Böyle bir Yazı bulunamadı"));
			}
			
			
			return ResponseEntity.ok(new GeneralResponse(true,okObject,""));
			
		} catch (Exception e) {
			
			String errorString = "BlogController on getBlog "  +  e.getMessage();
			return ResponseEntity.ok(new GeneralResponse(false,null,errorString));
			
		}
		
	}

}
