package ariservice.izay;

import org.apache.commons.io.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;
import java.io.IOException;


@RestController
@RequestMapping(value = "/files")
public class ShowFile {

		
	String rootPath = System.getProperty("catalina.home");
    File dir = new File(rootPath + File.separator + "files");
	
    @GetMapping("/{filename}")
    public ResponseEntity<byte[]> getImage(@PathVariable("filename") String filename) {
        byte[] image = new byte[0];
        try {
            image = FileUtils.readFileToByteArray(
            		new File(
            		dir.getAbsolutePath() 
            		+ File.separator 
            		+ filename));
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        if(filename.contains("png")) {
            return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(image);
	
        }
        else if(filename.contains("jpg") || filename.contains("jpeg")) {
        	return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
        }
        else if(filename.contains("svg") ) {
        	return ResponseEntity.ok().contentType(MediaType.APPLICATION_XML).body(image);
        }
       
        
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(image);

        
    }
}
