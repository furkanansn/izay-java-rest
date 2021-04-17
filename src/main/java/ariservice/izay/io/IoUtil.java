package ariservice.izay.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Base64;

import org.apache.commons.io.FileUtils;


public class IoUtil {
	
	private static String rootPath = "/var";
	
	


	public static String decoder(String base64Image) throws IOException {
		
			String pathString = getPath(base64Image);
		
	    	FileOutputStream imageOutFile = new FileOutputStream(pathString);

	    	byte[] imageByteArray = Base64.getDecoder().decode(base64Image.split(",")[1]);
	    	
	        imageOutFile.write(imageByteArray);
	        
	        imageOutFile.close();
	        
	        return pathString.substring(pathString.indexOf("files/"));
	    
	}
	
	public static String updateDecoder(String base64Image,String path) throws IOException {
		
		File file = new File(rootPath + "/" +path);
		
		file.delete();
		
		String pathString = getPath(base64Image);
	
    	FileOutputStream imageOutFile = new FileOutputStream(pathString);

    	byte[] imageByteArray = Base64.getDecoder().decode(base64Image.split(",")[1]);
    	
        imageOutFile.write(imageByteArray);
        
        imageOutFile.close();
        
        return pathString.substring(pathString.indexOf("files/"));    
}
	
	public static boolean deleteFile(String path) {
		
		File file = new File(rootPath + "/" + path);
		
		if(file.delete()) {
			return true;
		}
		return false;
	}
	
	private static String getPath(String base64Image) {
		
        File dir = new File(rootPath + File.separator + "files");
        if (!dir.exists())
            dir.mkdirs();
        

        String fileNameString = getFileName(base64Image);
        
        String Path = dir.getAbsolutePath() 
        		+ File.separator 
        		+ fileNameString;
        
        return Path;
		
	}
	
	
	private static String getFileName(String base64Image) {
        java.util.Date date= new java.util.Date();

        String fileNameString = (new Timestamp(date.getTime())).toString().replace(":", "")
        		.toString().replace(".", ".").toString().replace(" ","")
        		.toString().replace("-","").toString() + getExtensionOfImage(base64Image);
        
        return fileNameString;
        
	}
	
	private static String getExtensionOfImage(String base64String) {
		
		String[] strings = base64String.split(",");
		String extension;
		
		switch (strings[0]) {
		    case "data:image/jpeg;base64":
		        extension = ".jpeg";
		        break;
		    case "data:image/png;base64":
		        extension = ".png";
		        break;
		    case "data:image/svg+xml;base64":
		    	extension = ".svg";
		    	break;
		    default:
		        extension = ".pdf";
		        break;
		}
		
		return extension;
		
	}
	
	  public byte[] generateResponseFile(String rootPath,String filename) throws
	  IOException {
	  
	  File dir = new File(rootPath + File.separator + "files");
	  
	  byte[] image = new byte[0];
	  
	  image = FileUtils.readFileToByteArray( new File( dir.getAbsolutePath() +
	  File.separator + filename));
	  
	  return image;
	  
	  }
	 
	
}

