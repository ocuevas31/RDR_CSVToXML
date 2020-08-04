import java.util.HashMap;


public class GenerarXML2 {
    
    
    
    
    
    
    
    public String obtenerXML(HashMap<String,String> obj_line, int i, String usuario){  

	String XML_SALIDA="";
	if(usuario!=null&&!usuario.trim().equals("")){
	    XML_SALIDA="<PARTYSETUP><AUDIT_INFORMATION><USER>"+usuario+"</USER></AUDIT_INFORMATION><GLOBALS><GLOBAL>";
	} else{
	    XML_SALIDA="<PARTYSETUP><AUDIT_INFORMATION></AUDIT_INFORMATION><GLOBALS><GLOBAL>";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	 XML_SALIDA=XML_SALIDA+"</OPERATIVE></OPERATIVES></LOCAL></LOCALS></GLOBAL></GLOBALS></PARTYSETUP>";
	return XML_SALIDA;	
    }
}
