package ariservice.izay.meetUs.Controller;

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

import ariservice.izay.io.IoUtil;
import ariservice.izay.meetUs.dto.AddMeetUsDto;
import ariservice.izay.meetUs.dto.MeetUsDto;
import ariservice.izay.meetUs.entity.MeetUs;
import ariservice.izay.meetUs.repository.MeetUsRepository;
import ariservice.izay.security.JwtHelper;
import ariservice.izay.util.ApiPaths;
import ariservice.izay.util.GeneralResponse;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping(ApiPaths.MeetUsCtrl.CTRL)
public class MeetUsController {

	private final MeetUsRepository repo;
	private final ModelMapper modelMapper;
	JwtHelper jwtHelper;

	public MeetUsController(MeetUsRepository repo, ModelMapper modelMapper) {
		super();
		this.repo = repo;
		this.modelMapper = modelMapper;
		jwtHelper  = new JwtHelper();

	}


	
	@PostMapping("/add")
	ResponseEntity<GeneralResponse> addMeet(@RequestHeader(value = "Authorization", required = false)String token,@RequestBody AddMeetUsDto addMeetDto){
		
		try {
			String aString = jwtHelper.verifyJwt(token);

			MeetUs Meet = modelMapper.map(addMeetDto, MeetUs.class);
			
			String imagePathString = IoUtil.decoder(addMeetDto.getImageBase64());
			
			Meet.setImagePath(imagePathString);
			
			return ResponseEntity.ok(new GeneralResponse(true,repo.save(Meet),""));
			
		} catch (Exception e) {
			
			String errorString = "MeetController on addMeet "  +  e.getMessage();
			return ResponseEntity.ok(new GeneralResponse(false,null,errorString));
		}
		

	}
	
	
	@PostMapping("/update")
	ResponseEntity<GeneralResponse> updateMeet(@RequestHeader(value = "Authorization", required = false)String token,@RequestBody MeetUsDto dto){
		
		try {
			String aString = jwtHelper.verifyJwt(token);

			Optional<MeetUs> Meet = repo.findById(dto.getId());
			if(Meet.isPresent()) {
				MeetUs Meet2 = Meet.get();
				Meet2 = modelMapper.map(dto, MeetUs.class);
				
				if(dto.getImageBase64() != null || dto.getImageBase64().length() > 1) {
				
					String imagePathString = IoUtil.updateDecoder(dto.getImageBase64(),Meet2.getImagePath());
					
					Meet2.setImagePath(imagePathString);
					
				}
				

				return ResponseEntity.ok(new GeneralResponse(true,repo.save(Meet2),""));

			}else {
				return ResponseEntity.ok(new GeneralResponse(false,null,"Böyle bir döküman bulunamadı"));

			}
			
		} catch (Exception e) {
			
			String errorString = "MeetController on updateMeet "  +  e.getMessage();
			return ResponseEntity.ok(new GeneralResponse(false,null,errorString));
		}
		

	}
	
	@GetMapping("/delete")
	ResponseEntity<GeneralResponse> deleteMeet(@RequestHeader(value = "Authorization", required = false)String token,@RequestParam Long id){
		
		try {
			String aString = jwtHelper.verifyJwt(token);

			Optional<MeetUs> Meet = repo.findById(id);
			if(Meet.isPresent()) {
				MeetUs Meet2 = Meet.get();
				IoUtil.deleteFile(Meet2.getImagePath());
				repo.delete(Meet2);
				return ResponseEntity.ok(new GeneralResponse(true,null,""));

			}else {
				return ResponseEntity.ok(new GeneralResponse(false,null,"Böyle bir döküman bulunamadı"));

			}
			
		} catch (Exception e) {
			
			String errorString = "MeetController on deleteMeet "  +  e.getMessage();
			return ResponseEntity.ok(new GeneralResponse(false,null,errorString));
		}
		

	}
	
	@GetMapping("/get")
	ResponseEntity<GeneralResponse> getMeet(@RequestParam Long id){
		
		try {
			
			Optional<MeetUs> Meet = repo.findById(id);
			if(Meet.isPresent()) {
				MeetUs Meet2 = Meet.get();
				
				return ResponseEntity.ok(new GeneralResponse(true,Meet2,""));

			}else {
				return ResponseEntity.ok(new GeneralResponse(false,null,"Böyle bir döküman bulunamadı"));

			}
			
		} catch (Exception e) {
			
			String errorString = "MeetController on getMeet "  +  e.getMessage();
			return ResponseEntity.ok(new GeneralResponse(false,null,errorString));
		}
		

	}
}
