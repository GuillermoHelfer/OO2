package ar.edu.unlp.info.oo2.biblioteca;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JACKSONExporter extends VoorheesExporter {
	
	@Override
	public String exportar(List<Socio> socios) {
		 ObjectMapper mapper = new ObjectMapper();
		 String salida = "";
		 try {
			   salida = mapper.writeValueAsString(socios);
		 }
		 catch (JsonProcessingException e) {
			e.printStackTrace();
		 }
		 return salida;
	}

}
