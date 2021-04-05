package ariservice.izay.util;

import java.io.IOException;

public interface GeneralService {

public Object add(Object object) throws IOException;
	
public	Boolean delete(Long id);
	
public	Object update(Object object) throws IOException;
	
public	Object getAll();
	
public	Object getById(Long id);
	
}
