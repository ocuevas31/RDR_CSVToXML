import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

public class Ficheros {

    public ArrayList<HashMap<String,String>> obtenerDatos(File fich){  
	ArrayList<HashMap<String,String>> obj=new  ArrayList<HashMap<String,String>>();
	FileInputStream fis = null;	InputStreamReader fr = null;	    BufferedReader br = null;
	String linea = "";		File f = fich;	     

	try    {
	    fis = new FileInputStream(f);	fr = new InputStreamReader(fis, "UTF-8");	br = new BufferedReader(fr);	    
	  //  fis = new FileInputStream(f);	fr = new InputStreamReader(fis, "ISO-8859-1");	br = new BufferedReader(fr);
	    if (f.exists()) {
		int contador=0;
		ArrayList<String> cabecera=new ArrayList<String>();
		while((linea=br.readLine())!=null)  {
		    HashMap<String,String> cad_linea=new  HashMap<String,String>();
		    contador++;  
		    String[] str_linea =linea.split(";");

		    if(contador==1){
			for( int i = 0 ; i < str_linea.length ; i++ ){
			    if(str_linea[0]!=null && !str_linea[0].isEmpty() && !str_linea[0].trim().equals("")){	
				cabecera.add(str_linea[i].trim()); 
			    }
			}
		    }
		    else{
			for( int i = 0 ; i < str_linea.length ; i++ ){
			    String dato=new String();
			    String[] str_dato =str_linea[i].split("~");
			    for( int j = 0 ; j < str_dato.length ; j++ ){
				if(str_dato[j]!=null && !str_dato[j].isEmpty() && !str_dato[j].trim().equals("")){	
				    dato=xmlEscapeText(str_dato[j].trim()); 
				}else {
				    dato="";
				}
			    }
			    cad_linea.put(cabecera.get(i),dato);
			}
			obj.add(cad_linea);
		    }
		} 
	    }
	    br.close(); 	fis.close(); 		fr.close();
	} catch (FileNotFoundException e) {  e.printStackTrace();
	} catch (UnsupportedEncodingException e) {  e.printStackTrace();
	} catch (IOException e) {  e.printStackTrace();	 } 
	return obj;
    }	
    String xmlEscapeText(String t) {
	   StringBuilder sb = new StringBuilder();
	   for(int i = 0; i < t.length(); i++){
	      char c = t.charAt(i);
	      switch(c){
	      case '�': 	sb.append("�"); 	break;
	      case '�': 	sb.append("�"); 	break;
	      case '�': 	sb.append("�"); 	break;
	      case '�': 	sb.append("�"); 	break;
	      case '�': 	sb.append("�"); 	break;
	      case '�': 	sb.append("�"); 	break;
	      case '�': 	sb.append("�"); 	break;
	      case '�': 	sb.append("�"); 	break;
	      case '�': 	sb.append("�"); 	break;
	      case '�': 	sb.append("�"); 	break;
	      case '<': 	sb.append("&lt;"); 	break;
	      case '>': 	sb.append("&gt;"); 	break;
	      case '\"': 	sb.append("&quot;"); 	break;
	      case '&': 	sb.append("&amp;"); 	break;
	      case '\'': 	sb.append("&apos;"); 	break;
	      case '�': 	sb.append("�"); 	break;
	      case '�': 	sb.append("�"); 	break;
	      default:
	         if(c>0x7e) {	sb.append("&#"+((int)c)+";");
	         }else{         sb.append(c);	}
	      }
	   }
	   return sb.toString();
	}
    
    public void escribirDatos(String direct, String XML_SALIDA){ 
	/*Date fechaActual = new Date();        DateFormat formatoFecha = new SimpleDateFormat("yyyyMMddhhmmss");
	String fich_sal=direct+"/COMPASS_"+formatoFecha.format(fechaActual)+".xml";	*/
	String fich_sal=direct;
	PrintWriter pw = null;		OutputStreamWriter os = null;		FileOutputStream fos = null;
	try {  	    
	    fos = new FileOutputStream(new File(fich_sal));	os = new OutputStreamWriter(fos,"UTF-8");	pw = new PrintWriter(os);
	    //fos = new FileOutputStream(new File(fich_sal));	os = new OutputStreamWriter(fos,"ISO-8859-1");	pw = new PrintWriter(os);
	} catch (FileNotFoundException e){	e.printStackTrace();
	} catch (UnsupportedEncodingException e) {	e.printStackTrace();	}
	pw.print(XML_SALIDA);

	try { pw.close(); os.close(); fos.close(); } catch (IOException e) {	e.printStackTrace();	}
    }
}
